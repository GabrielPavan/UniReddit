package com.unesc.unireddit.Controller;

import com.unesc.unireddit.DTO.VotosDTO;
import com.unesc.unireddit.Model.VotosModel;
import com.unesc.unireddit.Service.VotosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votos")
public class VotosController {

    private final VotosService service;

    public VotosController(VotosService service) {
        this.service = service;
    }

    @PostMapping
    public VotosModel criar(@Valid  @RequestBody VotosDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/postagem/{id}")
    public List<VotosModel> buscarPorPostagem(@PathVariable Long id) {
        return service.buscarPorPostagem(id);
    }

    @GetMapping("/usuario/{id}")
    public List<VotosModel> buscarPorUsuario(@PathVariable Long id) {
        return service.buscarPorUsuario(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<VotosModel> buscarPorTipo(@PathVariable int tipo) {
        return service.buscarPorTipo(tipo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

