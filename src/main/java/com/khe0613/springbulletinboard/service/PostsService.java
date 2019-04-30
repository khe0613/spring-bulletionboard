package com.khe0613.springbulletinboard.service;

import com.khe0613.springbulletinboard.domain.posts.PostsRepository;
import com.khe0613.springbulletinboard.dto.posts.PostsListResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // (readOnly = true) 옵션을 주면 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어
    // 조회 속도가 개선됨. 따라서 CREATE/UPDATE/DELETE 기능이 없는 메소드라면 사용하는게 좋음
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}