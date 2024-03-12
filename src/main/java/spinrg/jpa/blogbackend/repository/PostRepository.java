package spinrg.jpa.blogbackend.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spinrg.jpa.blogbackend.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
