package com.bank.ojbank.controller;

import com.bank.ojbank.model.Usuario;
import com.bank.ojbank.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return service.criarUsuario(usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios() {
    return service.listarUsuarios();
    }
}
