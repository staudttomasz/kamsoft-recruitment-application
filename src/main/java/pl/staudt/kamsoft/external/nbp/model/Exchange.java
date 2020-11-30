package pl.staudt.kamsoft.external.nbp.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class Exchange {

    String table;
    String currency;
    String code;
    List<Rate> rates;


}
