package com.unesc.unireddit.Repository;

import com.unesc.unireddit.Model.TipoVoto;
import com.unesc.unireddit.Model.VotosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotosRepository extends JpaRepository<VotosModel, Long> {

    List<VotosModel> findByPostagemId(Long postagemId);

    List<VotosModel> findByUsuarioId(Long usuarioId);

    List<VotosModel> findByTipo(TipoVoto tipo);
}

