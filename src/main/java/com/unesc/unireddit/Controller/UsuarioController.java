package com.unesc.unireddit.Controller;

import com.unesc.unireddit.DTO.UsuarioResponseDTO;
import com.unesc.unireddit.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.BuscarPorId(id);
    }
    @GetMapping("/{mail}")
    public UsuarioResponseDTO buscarPorMail(@PathVariable String mail) { return usuarioService.BuscarPorMail(mail); }
    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioService.ListarTodos();
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}
