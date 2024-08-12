package br.edu.infnet.appAntonioC;

import br.edu.infnet.service.LibraryService;
import br.edu.infnet.controller.AuthorController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.infnet.service", "br.edu.infnet.controller", "br.edu.infnet.appAntonioC"})
public class AppAntonioCApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppAntonioCApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LibraryService libraryService) {
        return args -> {
            System.out.println("\navailable authors:");
            libraryService.getAuthors().forEach(author -> {
                System.out.println(author);
                author.getBooks().forEach(book -> System.out.println("  - " + book));
            });

            System.out.println("\navailable books:");
            libraryService.getBooks().forEach(System.out::println);
        };
    }
}
