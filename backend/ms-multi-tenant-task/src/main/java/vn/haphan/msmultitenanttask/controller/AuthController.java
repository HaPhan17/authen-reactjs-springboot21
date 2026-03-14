package vn.haphan.msmultitenanttask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.haphan.msmultitenanttask.bean.LoginReq;
import vn.haphan.msmultitenanttask.config.JwtService;

/**
 * @author : Hà Phan
 * created date : 2/24/2026
 * project-name : ms-learn-spring40
 * package-name : vn.haphan.msmultitenanttask.controller
 **/
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

@PostMapping("/login")
public String login(@RequestBody LoginReq loginReq) {
        return jwtService.generateToken(loginReq.email(), loginReq.password());
}
}
