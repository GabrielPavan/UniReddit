package com.unesc.unireddit.Controller;

import com.unesc.unireddit.DTO.ComunidadeResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unesc.unireddit.DTO.ComunidadeDTO;
import com.unesc.unireddit.Service.ComunidadeService;

import java.util.List;

@RestController
@RequestMapping("/comunidades")
public class ComunidadeController {

    private final ComunidadeService service;

    public ComunidadeController(ComunidadeService service) {
        this.service = service;
    }

    // Criar comunidade
    @PostMapping
    public ResponseEntity<ComunidadeResponseDTO> criar(@RequestBody ComunidadeDTO dto) {
        ComunidadeResponseDTO response = service.criarComunidade(dto);
        return ResponseEntity.ok(response);
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<ComunidadeResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<ComunidadeResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Buscar por nome (ex: /comunidades/search?nome=java)
    @GetMapping("/search")
    public ResponseEntity<List<ComunidadeResponseDTO>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }
}