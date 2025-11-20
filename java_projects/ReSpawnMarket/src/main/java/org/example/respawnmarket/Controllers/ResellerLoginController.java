package org.example.respawnmarket.Controllers;

import org.example.respawnmarket.Service.ResellerLoginService;
import org.example.respawnmarket.dtos.ResellerLoginRequestDto;
import org.example.respawnmarket.dtos.ResellerLoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/resellers")

    public class ResellerLoginController {

        private final ResellerLoginService resellerLoginService;

        @Autowired
        public ResellerLoginController(ResellerLoginService resellerLoginService) {
            this.resellerLoginService = resellerLoginService;
        }

        @PostMapping("/login")
        public ResellerLoginResponseDto login(@RequestBody ResellerLoginRequestDto request) {
            return resellerLoginService.login(request);
        }
    }