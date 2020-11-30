package pl.staudt.kamsoft.external.nbp.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Rate {

    String number;
    LocalDate effectiveDate;
    BigDecimal bid;
    BigDecimal ask;

}
