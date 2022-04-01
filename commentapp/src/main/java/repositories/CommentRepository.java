package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
