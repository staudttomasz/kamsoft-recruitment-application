package pl.staudt.kamsoft.external.nbp.logic;

import io.vavr.control.Try;
import pl.staudt.kamsoft.external.nbp.model.Exchange;

public interface NbpApi {

    Try<Exchange> getRate(String currencyCode);

}
