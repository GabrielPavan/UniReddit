package com.unesc.unireddit.Repository;

import com.unesc.unireddit.Model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

    List<PostagemModel> findByComunidadeId(Long comunidadeId);

    List<PostagemModel> findByAutorId(Long autorId);
}
