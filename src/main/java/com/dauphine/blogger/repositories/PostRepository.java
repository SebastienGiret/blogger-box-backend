package com.dauphine.blogger.repositories;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    @Query("""
           SELECT p
           FROM Post p
           WHERE (:contentOrTitle IS NULL OR p.title LIKE CONCAT('%', :contentOrTitle, '%') OR p.content LIKE CONCAT('%', :contentOrTitle, '%'))
    """)
    List<Post> findAllByTitleOrContent(@Param("contentOrTitle") String contentOrTitle);
}
