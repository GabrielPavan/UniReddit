package com.unesc.unireddit.Controller;

import com.unesc.unireddit.Config.TokenConfig;
import com.unesc.unireddit.DTO.Request.LoginRequest;
import com.unesc.unireddit.DTO.Response.LoginResponse;
import com.unesc.unireddit.DTO.Response.RegistroUsuarioReponse;
import com.unesc.unireddit.DTO.Request.RegistroUsuarioRequest;
import com.unesc.unireddit.Model.UsuarioModel;
import com.unesc.unireddit.Model.UsuarioRole;
import com.unesc.unireddit.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthController(UsuarioRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.mail(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        UsuarioModel user = (UsuarioModel) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<RegistroUsuarioReponse> register(@Valid @RequestBody RegistroUsuarioRequest request) {
        UsuarioModel newUser = new UsuarioModel();
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setMail(request.mail());
        newUser.setName(request.name());

        if (request.role() != null) {
            newUser.setRoles(Set.of(request.role()));
        } else {
            newUser.setRoles(Set.of(UsuarioRole.ROLE_USER));
        }

        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegistroUsuarioReponse(newUser.getName(), newUser.getMail()));
    }
}
