package com.unesc.unireddit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unesc.unireddit.Model.ComunidadeModel;

import java.util.List;

public interface ComunidadeRepository extends JpaRepository<ComunidadeModel, Long> {
    // Busca por nome exato
    List<ComunidadeModel> findByName(String name);

    // Busca por parte do nome (ignora maiúsculas/minúsculas)
    List<ComunidadeModel> findByNameContainingIgnoreCase(String name);
}

