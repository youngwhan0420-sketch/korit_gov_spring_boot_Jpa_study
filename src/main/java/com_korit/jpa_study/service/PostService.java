package com_korit.jpa_study.service;

import com_korit.jpa_study.dto.AddPostReqDto;
import com_korit.jpa_study.dto.ApiRespDto;
import com_korit.jpa_study.dto.EditPostReqDto;
import com_korit.jpa_study.entity.Post;
import com_korit.jpa_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public ApiRespDto<?> addPost(AddPostReqDto addPostReqDto) {
        return new ApiRespDto<>("success", "추가 성공", postRepository.save(addPostReqDto.toEntity()));
    }
    public ApiRespDto<?> getPostAll() {
        return new ApiRespDto<>("success", "전체 조회 성공", postRepository.findAll());
    }
    public ApiRespDto<?> getPostByPostId(Integer postId) {
        Optional<Post> foundPost = postRepository.findById(postId);
        if (foundPost.isEmpty()) {
            return new ApiRespDto<>("failed", "해당 게시물이 존재하지 않습니다.", null);
        }
        Post post = foundPost.get();

        return new ApiRespDto<>("success", "단건 조회 성공", postRepository.save(post));
    }
    public ApiRespDto<?> editPost(EditPostReqDto editPostReqDto) {
        //수정을 할려면 일단 찾기
        Optional<Post> foundPost = postRepository.findById(editPostReqDto.getPostId());
        if (foundPost.isEmpty()) {
            return new ApiRespDto<>("failed", "해당 게시물이 존재하지 않습니다.", null);
        }
        return new ApiRespDto<>("success", "수정 성공", postRepository.save(editPostReqDto.toEntity(post.getUserId())));
    }
    public ApiRespDto<?> removePost(Integer postId) {
        // 삭제하기 전에 있는지 확인하기
        Optional<Post> foundPost = postRepository.findById(postId);
        if (foundPost.isEmpty()) {
            return new ApiRespDto<>("failed", "해당 게시물이 존재하지 않습니다.", null);
        }
        postRepository.deleteById(postId);
        return new ApiRespDto<>("success", "삭제 성공", null);
    }
}
