package pl.staudt.kamsoft.currency.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.staudt.kamsoft.currency.mapping.ExchangeMapper;
import pl.staudt.kamsoft.external.nbp.logic.NbpApi;

@Configuration
public class CurrencyConfiguration {

    @Bean
    CurrencyApi currencyApi(NbpApi nbpApi, ExchangeMapper exchangeMapper) {
        return new CurrencyFacade(nbpApi, exchangeMapper);
    }

    @Bean
    ExchangeMapper exchangeMapper() {
        return new ExchangeMapper();
    }

}
