package com.ortiz.foroHub.Controllers;

import com.ortiz.foroHub.domain.usuarios.DatosAutenticacion;
import com.ortiz.foroHub.domain.usuarios.Usuario;
import com.ortiz.foroHub.infra.security.DatosTokenJWT;
import com.ortiz.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity iniciarSession(@RequestBody @Valid DatosAutenticacion datos) {
        System.out.println("Correo recibido: " + datos.correo());
        var Autenticationtoken = new UsernamePasswordAuthenticationToken(datos.correo(), datos.contrasenia());
        var autenticacion = manager.authenticate(Autenticationtoken);
        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}