package pl.staudt.kamsoft.external.nbp.logic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.staudt.kamsoft.external.nbp.model.Exchange;

import java.time.LocalDate;

@FeignClient(name = "nbpClient", url = "http://api.nbp.pl")
interface NbpClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/exchangerates/rates/c/{currencyCode}/{date}/?format=json",
            consumes = "application/json")
    Exchange exchangeRate(@PathVariable("currencyCode") String currencyCode, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date);
}
