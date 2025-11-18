package com.unesc.unireddit.Controller;

import com.unesc.unireddit.DTO.ComentarioDTO;
import com.unesc.unireddit.DTO.ComentarioResponseDTO;
import com.unesc.unireddit.Service.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    // Criar novo comentário
    @PostMapping
    public ComentarioResponseDTO criar(@RequestBody ComentarioDTO dto) {
        return comentarioService.criarComentario(dto);
    }

    // Atualizar comentário
    @PutMapping("/{id}")
    public ComentarioResponseDTO atualizar(@PathVariable Long id, @RequestBody ComentarioDTO dto) {
        return comentarioService.atualizarComentario(id, dto);
    }

    // Listar comentários principais de uma postagem com sub-respostas
    @GetMapping("/postagem/{postagemId}")
    public List<ComentarioResponseDTO> listarPorPostagem(@PathVariable Long postagemId) {
        return comentarioService.listarPorPostagem(postagemId);
    }

    // Listar respostas de um comentário específico
    @GetMapping("/{id}/respostas")
    public List<ComentarioResponseDTO> listarRespostas(@PathVariable Long id) {
        return comentarioService.listarRespostas(id);
    }

    // Deletar comentário
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        comentarioService.deletarComentario(id);
    }
}
