package home.desafiopolvo.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPost extends JpaRepository<Post , Long> {

}
