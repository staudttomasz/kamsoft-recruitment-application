package pl.staudt.kamsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KamsoftRecruitmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(KamsoftRecruitmentApplication.class, args);
    }

}