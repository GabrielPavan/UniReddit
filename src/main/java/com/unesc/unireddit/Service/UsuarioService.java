package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.UsuarioResponseDTO;
import com.unesc.unireddit.Model.UsuarioModel;
import com.unesc.unireddit.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> ListarTodos () {
        return usuarioRepository.findAll()
                .stream()
                .map( u -> new UsuarioResponseDTO(
                        u.getId(),
                        u.getUsername(),
                        u.getMail()
                )).collect(Collectors.toList());
    }
    public  UsuarioResponseDTO BuscarPorId(Long id){
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return new UsuarioResponseDTO(
                usuarioModel.getId(),
                usuarioModel.getUsername(),
                usuarioModel.getMail());
    }
    public UsuarioResponseDTO BuscarPorMail(String mail){
        UsuarioModel usuarioModel = usuarioRepository.findByMail(mail)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        return new UsuarioResponseDTO(
                usuarioModel.getId(),
                usuarioModel.getUsername(),
                usuarioModel.getMail());
    };

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
