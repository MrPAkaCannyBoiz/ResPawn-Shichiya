package org.example.respawnmarket.Service;

import org.example.respawnmarket.dtos.ResellerLoginRequestDto;
import org.example.respawnmarket.dtos.ResellerLoginResponseDto;
import org.example.respawnmarket.entities.ResellerEntity;
import org.example.respawnmarket.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResellerLoginService
{
    private final ResellerRepository resellerRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ResellerLoginService(ResellerRepository resellerRepository) {
        this.resellerRepository = resellerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public ResellerLoginResponseDto login(ResellerLoginRequestDto request) {
        var resellerOpt = resellerRepository.findByUsername(request.getUsername());

        if (!resellerOpt.isPresent()) {
            throw new RuntimeException("Invalid username or password");
        }

        ResellerEntity reseller = resellerOpt.get();

        //check the passwprd = BCrypt
        if (!passwordEncoder.matches(request.getPassword(), reseller.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // Login ok -> id + username
        return new ResellerLoginResponseDto(reseller.getId(), reseller.getUsername());
    }
}