package home.desafiopolvo.Post;

import home.desafiopolvo.Usuario.RepositoryUsuarios;
import home.desafiopolvo.Tratamento.ValidarExepction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicePost {
    @Autowired
    private RepositoryPost repository;

    @Autowired
    private RepositoryUsuarios repositoryUsuarios;

    @Transactional
    public ResponseEntity fazerpost(DadosPost dados) {
        var autorOptional = repositoryUsuarios.findById(Long.valueOf(dados.autor()));
        if (autorOptional.isEmpty()) {
            throw new ValidarExepction("O autor do post não foi encontrado no banco de dados.");
        }

        var autor = autorOptional.get();

        Post novoPost = new Post();
        novoPost.setTitulo(dados.titulo());
        novoPost.setConteudo(dados.conteudo());
        novoPost.setAutor(autor.getNome());
        novoPost.setHorapublica(dados.dataPublicacao());

        repository.save(novoPost);


        var response = new DadosPost(
                novoPost.getTitulo(),
                novoPost.getConteudo(),
                autor.getNome(),
                novoPost.getHorapublica()
        );

        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity atualizarPost(Long id, DadosPost dadosPost) {
        var verificar = repository.findById(id);

        if (verificar.isEmpty()) {
            throw new ValidarExepction("Não foi possível encontrar o Post.");
        }

        Post postAtualizado = verificar.get();

        if (dadosPost.titulo() != null) {
            postAtualizado.setTitulo(dadosPost.titulo());
        }
        if (dadosPost.conteudo() != null) {
            postAtualizado.setConteudo(dadosPost.conteudo());
        }
        if (dadosPost.autor() != null) {
            var autorOptional = repositoryUsuarios.findById(Long.valueOf(dadosPost.autor()));
            if (autorOptional.isEmpty()) {
                throw new ValidarExepction("O autor especificado não foi encontrado.");
            }
            postAtualizado.setAutor(autorOptional.get().getNome());
        }
        if (dadosPost.dataPublicacao() != null) {
            postAtualizado.setHorapublica(dadosPost.dataPublicacao());
        }

        repository.save(postAtualizado);

        var response = new DadosPost(
                postAtualizado.getTitulo(),
                postAtualizado.getConteudo(),
                postAtualizado.getAutor(),
                postAtualizado.getHorapublica()
        );

        return ResponseEntity.ok(response);
    }



    @Transactional
    public ResponseEntity deletarPost(Long id) {
        var post = repository.findById(id);

        if (post.isEmpty()) {
            throw new ValidarExepction("Não foi possível encontrar o post para deletar.");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @Transactional
    public ResponseEntity listarPosts() {
        var posts = repository.findAll()
                .stream()
                .map(post -> new DadosPost(
                        post.getTitulo(),
                        post.getConteudo(),
                        post.getAutor(),
                        post.getHorapublica()
                ))
                .toList();

        return ResponseEntity.ok(posts);
    }
}
