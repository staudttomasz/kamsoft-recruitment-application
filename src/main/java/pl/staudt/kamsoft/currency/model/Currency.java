package pl.staudt.kamsoft.currency.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class Currency {

    String currencyCode;
    BigDecimal buy;
    BigDecimal sell;

}
