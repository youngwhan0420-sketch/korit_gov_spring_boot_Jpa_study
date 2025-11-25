package com_korit.jpa_study.dto;

import com_korit.jpa_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class EditPostReqDto {
    private Integer postId;
    private String title;
    private String content;

    public Post toEntity(Integer userId, LocalDateTime createDt) {
        return Post.builder()
                .userId(userId)
                .postId(postId)
                .title(title)
                .content(content)
                .createDt(createDt)
                .updateDt(LocalDateTime.now())
                .build();
    }
}
