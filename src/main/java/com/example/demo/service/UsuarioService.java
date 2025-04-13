package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;




@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public List<Usuario> listarTodos(){
        return repo.findAll();
    }

    public Usuario novo(Usuario usuario) {
        
        if(usuario == null ||
            usuario.getNome() == null ||
            usuario.getNome().isBlank() ||
            usuario.getSenha() == null ||
            usuario.getSenha().isBlank()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados Invalidos!");
        }
        return repo.save(usuario);
    }

    public Usuario buscarPorId (Long idUsuario){

        Optional<Usuario> usuarioOp = repo.findById(idUsuario);

        if(usuarioOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não Encontrado!");
        }
        return usuarioOp.get();

    }


    
}
