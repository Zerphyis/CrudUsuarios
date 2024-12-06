package home.desafiopolvo.Controller;

import home.desafiopolvo.Post.DadosPost;
import home.desafiopolvo.Post.Post;
import home.desafiopolvo.Post.ServicePost;
import home.desafiopolvo.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class ControllerPost {
    @Autowired
    private ServicePost service;

    @PostMapping("/adicionar")
    public ResponseEntity<Post> publicarPost(@RequestBody DadosPost dados){
        return service.fazerpost(dados);
    }
    @PutMapping("/atualziar/{id}")
    public ResponseEntity<Post> atualizarPost(@PathVariable Long id,@RequestBody DadosPost dados){
        return service.atualizarPost(id, dados);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        return service.deletarPost(id);
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return service.listarPosts();
    }
}
