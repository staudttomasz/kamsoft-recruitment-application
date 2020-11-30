package pl.staudt.kamsoft.currency.mapping;

import pl.staudt.kamsoft.currency.model.Currency;
import pl.staudt.kamsoft.external.nbp.model.Exchange;
import pl.staudt.kamsoft.external.nbp.model.Rate;

import java.math.BigDecimal;
import java.util.Optional;

public class ExchangeMapper implements Mapper<Exchange, Currency> {

    @Override
    public Currency convert(Exchange source) {

        Currency.CurrencyBuilder currencyBuilder = Currency.builder().currencyCode(source.getCode());

        if (source.getCurrency().equalsIgnoreCase("PLN")) {
            return Currency.builder().sell(BigDecimal.ONE).buy(BigDecimal.ONE).currencyCode("PLN").build();
        }

        Optional<Rate> rate = source.getRates().stream().findFirst();

        return currencyBuilder
                .currencyCode(source.getCode())
                .buy(rate.map(Rate::getBid).orElse(null))
                .sell(rate.map(Rate::getAsk).orElse(null))
                .build();
    }
}
