package pl.staudt.kamsoft.currency.logic;

import io.vavr.control.Try;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyRequest;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyResponse;

public interface CurrencyApi {

    Try<ChangeCurrencyResponse> changeCurrency(ChangeCurrencyRequest request);

}
