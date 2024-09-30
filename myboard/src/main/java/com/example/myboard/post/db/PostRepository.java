package com.example.myboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

    // select * from post where id=? and status=? orderby id desc limit 1
    // FirstBy 이므로 limit 1 로 제일 첫번째 값만 가져온다
    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);

    // 모든 게시글 조회 시 삭제되지 않은 글만 가져오기
    public List<PostEntity> findAllByStatusOrderByIdDesc(String status);
}
