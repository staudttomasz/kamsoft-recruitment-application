package pl.staudt.kamsoft.currency;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.staudt.kamsoft.currency.logic.CurrencyApi;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyRequest;
import pl.staudt.kamsoft.currency.model.ChangeCurrencyResponse;

import java.util.function.Function;

@Api(tags = "Currency")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
@Slf4j
public class CurrencyController {

    private final CurrencyApi currencyApi;

    @PostMapping("/currency")
    public ResponseEntity<ChangeCurrencyResponse> change(@RequestBody ChangeCurrencyRequest request) throws Throwable {
        return currencyApi.changeCurrency(request)
                .map(ResponseEntity::ok)
                .onFailure(ex -> log.error(ex.getMessage()))
                .getOrElse(ResponseEntity.notFound().build());
    }
}
