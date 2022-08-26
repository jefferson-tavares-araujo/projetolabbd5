package br.gov.sp.fatec.projetolab5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolab5.entity.Usuario;
import br.gov.sp.fatec.projetolab5.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if (usuario.getNome() == null ||
         usuario.getNome().isEmpty() ||
          usuario.getSenha() ==null ||
           usuario.getSenha().isEmpty()){
            throw new InvalidParameterException(msg: "Parametros invalidos");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
        Usuario usuario = new usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        return novoUsuario(Usuario);
    }

    @Override
    public List<Usuario> todoUsuarios() {
        // TODO Auto-generated method stub
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
       Optional<Usuario> optionalUsuario = usuarioRepo.findById(id)
       if(optionalUsuario.isEmpty()){
            throw new IllegalArgumentException(s: "Id nao existe")
       }
        return optionalUsuario.get();
    }
    
}
