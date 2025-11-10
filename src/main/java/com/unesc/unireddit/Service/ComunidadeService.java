package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.ComunidadeResponseDTO;
import org.springframework.stereotype.Service;
import com.unesc.unireddit.Model.ComunidadeModel;
import com.unesc.unireddit.DTO.ComunidadeDTO;
import com.unesc.unireddit.Repository.ComunidadeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunidadeService {

    private final ComunidadeRepository repository;

    public ComunidadeService(ComunidadeRepository repository) {
        this.repository = repository;
    }

    public ComunidadeResponseDTO criarComunidade(ComunidadeDTO dto) {
        ComunidadeModel comunidade = new ComunidadeModel();
        comunidade.setName(dto.getName());
        comunidade.setDescription(dto.getDescription());
        comunidade.setPrivate(dto.isPrivate());

        ComunidadeModel salva = repository.save(comunidade);

        return new ComunidadeResponseDTO(
                salva.getId(),
                salva.getName(),
                salva.getDescription(),
                salva.isPrivate(),
                salva.getCreateAt()
        );
    }

    public List<ComunidadeResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(c -> new ComunidadeResponseDTO(
                        c.getId(),
                        c.getName(),
                        c.getDescription(),
                        c.isPrivate(),
                        c.getCreateAt()))
                .collect(Collectors.toList());
    }

    public ComunidadeResponseDTO buscarPorId(Long id) {
        ComunidadeModel c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunidade não encontrada"));

        return new ComunidadeResponseDTO(
                c.getId(),
                c.getName(),
                c.getDescription(),
                c.isPrivate(),
                c.getCreateAt());
    }

    public List<ComunidadeResponseDTO> buscarPorNome(String nome) {
        return repository.findByNameContainingIgnoreCase(nome)
                .stream()
                .map(c -> new ComunidadeResponseDTO(
                        c.getId(),
                        c.getName(),
                        c.getDescription(),
                        c.isPrivate(),
                        c.getCreateAt()))
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Comunidade não encontrada");
        }
        repository.deleteById(id);
    }

}