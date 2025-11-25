package com_korit.jpa_study.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import jdk.jfr.Name;
import jdk.jfr.Threshold;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Enabled
@Table(name = "post_tb")

public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 키 생성되는 옵션을 가져오는 옵션이다.
    @Id
    private Integer postId;
    private String title;
    private String content;
    private Integer userId;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}
