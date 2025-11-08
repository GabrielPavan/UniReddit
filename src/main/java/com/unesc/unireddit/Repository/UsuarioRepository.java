package com.unesc.unireddit.Repository;

import com.unesc.unireddit.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModel, Long> {
    Optional<UserDetails> findUserByMail(String username);
}