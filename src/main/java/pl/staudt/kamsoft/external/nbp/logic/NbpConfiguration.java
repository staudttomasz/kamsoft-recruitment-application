package pl.staudt.kamsoft.external.nbp.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NbpConfiguration {

    @Bean
    NbpApi nbpApi(NbpClient nbpClient) {
        return new NbpFacade(nbpClient);
    }
}
