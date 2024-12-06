package home.desafiopolvo.Post;

import java.time.LocalDateTime;

public record DadosPost(String titulo, String conteudo, String autor, LocalDateTime dataPublicacao) {
}
