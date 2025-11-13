package com.unesc.unireddit.Repository;

import com.unesc.unireddit.Model.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, Long> {
    List<ComentarioModel> findByPostagemId(Long postagemId);
    List<ComentarioModel> findByParentId(Long parentId);
}
