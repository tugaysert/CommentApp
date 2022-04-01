package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Like;


public interface LikeRepository extends JpaRepository<Like, Long> {

}
