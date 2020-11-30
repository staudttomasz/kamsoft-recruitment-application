package pl.staudt.kamsoft.currency.logic;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.staudt.kamsoft.currency.exception.BusinessException;
import pl.staudt.kamsoft.currency.exception.CodeBook;
import pl.staudt.kamsoft.currency.mapping.ExchangeMapper;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyRequest;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyResponse;
import pl.staudt.kamsoft.currency.model.Currency;
import pl.staudt.kamsoft.external.nbp.logic.NbpApi;
import pl.staudt.kamsoft.external.nbp.model.Exchange;

import java.math.RoundingMode;

@RequiredArgsConstructor
@Slf4j
class CurrencyFacade implements CurrencyApi {

    public static final String PLN = "PLN";

    private final NbpApi nbpApi;
    private final ExchangeMapper exchangeMapper;

    @Override
    public Try<ChangeCurrencyResponse> changeCurrency(ChangeCurrencyRequest request) {

        Try<Currency> currencyToSell = request.getSourceCurrencyCode()
                .map(code -> {
                    if (!code.equalsIgnoreCase(PLN)) {
                        return nbpApi.getRate(request.getSourceCurrencyCode().get())
                                .map(exchangeMapper::convert)
                                .orElse(Try.failure(new BusinessException(CodeBook.EXTERNAL_CALL_FAILURE)));
                    }
                    return Try.of(() -> exchangeMapper.convert(Exchange.builder().code(PLN).build()));
                }).get();

        Try<Currency> currencyToBuy = request.getBuyCurrencyCode()
                .map(code -> {
                    if (!code.equalsIgnoreCase(PLN)) {
                        return nbpApi.getRate(request.getBuyCurrencyCode().get())
                                .map(exchangeMapper::convert)
                                .orElse(Try.failure(new BusinessException(CodeBook.EXTERNAL_CALL_FAILURE)));
                    }
                    return Try.of(() -> exchangeMapper.convert(Exchange.builder().currency(PLN).build()));
                }).get();

        return Try.of(() -> {
            Currency toBuy = currencyToBuy.get();
            Currency toSell = currencyToSell.get();

            return ChangeCurrencyResponse.builder()
                    .currencyCode(toBuy.getCurrencyCode())
                    .amount(request.getAmount().multiply(toSell.getBuy().divide(toBuy.getSell(), RoundingMode.HALF_EVEN)))
                    .build();
        });
    }
}
