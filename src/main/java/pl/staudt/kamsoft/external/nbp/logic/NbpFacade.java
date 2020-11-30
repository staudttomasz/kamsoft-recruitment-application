package pl.staudt.kamsoft.external.nbp.logic;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import pl.staudt.kamsoft.external.nbp.model.Exchange;

import java.time.LocalDate;

@RequiredArgsConstructor
class NbpFacade implements NbpApi {

    private final NbpClient nbpClient;

    @Override
    public Try<Exchange> getRate(String currencyCode) {
        return Try.of(() -> nbpClient.exchangeRate(currencyCode, LocalDate.now()));
    }

}
