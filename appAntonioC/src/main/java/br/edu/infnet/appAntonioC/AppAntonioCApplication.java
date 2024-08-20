package br.edu.infnet.appAntonioC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.infnet.appAntonioC.service", "br.edu.infnet.appAntonioC.controller", "br.edu.infnet.appAntonioC"})
public class AppAntonioCApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAntonioCApplication.class, args);
    }
}
