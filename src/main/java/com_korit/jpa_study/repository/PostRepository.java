package com_korit.jpa_study.repository;

import com_korit.jpa_study.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> { //<>에는 해당엔티티와 엔티티에 해당하는 기본키를 넣어준다.
    Optional<Post> findByTitle(String title);
    List<Post> findAllByUserId(Integer userId);


}
