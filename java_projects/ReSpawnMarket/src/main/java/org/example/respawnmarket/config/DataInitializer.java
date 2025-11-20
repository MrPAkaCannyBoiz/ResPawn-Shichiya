package org.example.respawnmarket.config;

import org.example.respawnmarket.entities.ResellerEntity;
import org.example.respawnmarket.repositories.ResellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ResellerRepository resellerRepository;

    public DataInitializer(ResellerRepository resellerRepository) {
        this.resellerRepository = resellerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // add reseller for test
        if (resellerRepository.count() == 0) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            ResellerEntity reseller = new ResellerEntity();
            reseller.setName("Test Reseller");
            reseller.setUsername("reseller1");
            reseller.setPassword(encoder.encode("password1"));

            resellerRepository.save(reseller);
            System.out.println(">>> Created test reseller: username=reseller1, password=password1");
        }
    }
}