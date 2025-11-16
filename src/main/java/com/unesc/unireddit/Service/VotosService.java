package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.VotosDTO;
import com.unesc.unireddit.Model.TipoVoto;
import com.unesc.unireddit.Model.VotosModel;
import com.unesc.unireddit.Repository.VotosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotosService {

    private final VotosRepository repository;

    public VotosService(VotosRepository repository) {
        this.repository = repository;
    }

    public VotosModel salvar(VotosDTO dto) {

        VotosModel voto = new VotosModel();
        voto.setTipo(TipoVoto.fromInt(dto.getTipo()));
        voto.setUsuarioId(dto.getUsuarioId());
        voto.setPostagemId(dto.getPostagemId());

        return repository.save(voto);
    }

    public List<VotosModel> buscarPorPostagem(Long postagemId) {
        return repository.findByPostagemId(postagemId);
    }

    public List<VotosModel> buscarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<VotosModel> buscarPorTipo(int tipo) {
        return repository.findByTipo(TipoVoto.fromInt(tipo));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Voto não encontrado");
        }
        repository.deleteById(id);
    }
}
