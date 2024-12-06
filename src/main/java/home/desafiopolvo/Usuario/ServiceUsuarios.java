package home.desafiopolvo.Usuario;

import home.desafiopolvo.Tratamento.ValidarExepction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarios {
    @Autowired
    private RepositoryUsuarios repository;

    @Transactional
    public ResponseEntity adicionarUsuarios(DadosUsuarios dados) {
        Usuario novoUsuario = new Usuario(dados);
        repository.save(novoUsuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @Transactional
    public ResponseEntity atualizarUsuarios(Long id, DadosUsuarios dadosUsuarios) {
        var verificar = repository.findById(id);

        if (verificar.isEmpty()) {
            throw new ValidarExepction("Não foi possível encontrar o usuário");
        }

        Usuario usuarioAtualizado = verificar.get();
        if (dadosUsuarios.nome() != null) {
            usuarioAtualizado.setNome(dadosUsuarios.nome());
        }
        if (dadosUsuarios.email() != null) {
            usuarioAtualizado.setEmail(dadosUsuarios.email());
        }
        if (dadosUsuarios.cpf() != null) {
            usuarioAtualizado.setCpf(dadosUsuarios.cpf());
        }
        repository.save(usuarioAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @Transactional
    public ResponseEntity deletarUsuarios(Long id) {
        var usuario = repository.findById(id);

        if (usuario.isEmpty()) {
            throw new ValidarExepction("Não foi possível encontrar o usuário para deletar");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public ResponseEntity listarUsuarios() {
        var usuarios = repository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
