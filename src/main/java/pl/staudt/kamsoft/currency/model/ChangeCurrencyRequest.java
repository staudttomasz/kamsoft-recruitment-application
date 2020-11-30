package pl.staudt.kamsoft.currency.model;

import io.vavr.control.Option;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@RequiredArgsConstructor
@Builder(toBuilder = true)
public class ChangeCurrencyRequest {

    @NonNull
    String sourceCurrencyCode;
    @NonNull
    String buyCurrencyCode;
    @NonNull
    BigDecimal amount;

    public Option<String> getSourceCurrencyCode() {
        return Option.of(sourceCurrencyCode);
    }

    public Option<String> getBuyCurrencyCode() {
        return Option.of(buyCurrencyCode);
    }
}
