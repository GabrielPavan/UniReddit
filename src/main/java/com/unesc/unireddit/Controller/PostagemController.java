package com.unesc.unireddit.Controller;

import com.unesc.unireddit.DTO.PostagemDTO;
import com.unesc.unireddit.DTO.PostagemResponseDTO;
import com.unesc.unireddit.Service.PostagemService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService postagemService;

    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @PostMapping
    public PostagemResponseDTO criar(@Valid @RequestBody PostagemDTO dto) {
        return postagemService.criar(dto);
    }

    @GetMapping("/{id}")
    public PostagemResponseDTO buscar(@PathVariable Long id) {
        return postagemService.buscarPorId(id);
    }

    @GetMapping
    public List<PostagemResponseDTO> listar() {
        return postagemService.listar();
    }

    @GetMapping("/comunidade/{comunidadeId}")
    public List<PostagemResponseDTO> listarPorComunidade(@PathVariable Long comunidadeId) {
        return postagemService.listarPorComunidade(comunidadeId);
    }

    @PutMapping("/{id}")
    public PostagemResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PostagemDTO dto) {
        return postagemService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postagemService.deletar(id);
    }
}
