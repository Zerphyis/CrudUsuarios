package home.desafiopolvo.Post;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_post")
@EqualsAndHashCode(of = "id")

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private  String titulo;
    @NotBlank
    private String conteudo;
    private LocalDateTime horapublica;
    @NotBlank
    private String autor;


    public Post(){

    }
    public Post(DadosPost dadosPost){
        this.autor= dadosPost.autor();
        this.conteudo= dadosPost.conteudo();
        this.titulo= dadosPost.conteudo();
        this.horapublica=dadosPost.dataPublicacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getHorapublica() {
        return horapublica;
    }

    public void setHorapublica(LocalDateTime horapublica) {
        this.horapublica = horapublica;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
