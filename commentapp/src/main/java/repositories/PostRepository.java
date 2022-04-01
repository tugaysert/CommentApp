package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
