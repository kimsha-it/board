package com.example.board.repository;

import java.util.List;
import com.example.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // 기본 CRUD 메서드

    // 1. 비영속 (id가 부여되지 않음)
    // new Post("title", "content");
    // 저장 (INSERT or UPDATE)
    // Post save(Post entity);

    // => persist()
    // 조회
    // Optional<Post> findById(Long id);
    // List<Post> findAll();
    // List<Post> findAll(Sort sort);

    // 2. 영속 (id가 부여됨)
    // em.persist(post);

    // => detach(), clear()

    // 3. 준영속 (detached 수정하는중)
    // em.detach(post)

    // => merger() => 영속으로 돌아감

    // 4. 삭제
    // em.remove(post)
    // 삭제
    // void deleteById(Long id);
    // void delete(Post entity);

    // 개수 조회
    // long count();
    // 존재 여부 확인
    // boolean existsById(Long id);

    // findBy + 필드명 + 조건

    // LIKE %keyword%
    List<Post> findByTitleContaining(String keyword);

    // LIKE keyword%
    List<Post> findByTitleStartingWith(String keyword);

    // >
    List<Post> findByIdGreaterThan(Long id);

    // ORDER BY id DESC
    List<Post> findAllByOrderByIdDesc();

    // 제목, 내용
    List<Post> findByTitleContainingOrContentContaining(
            String titleKeyword, String contentKeyword);
}
