package com.company.blog.service.impl;

import com.company.blog.config.ModelMapperConfiguration;
import com.company.blog.data.dto.request.PostRequestDto;
import com.company.blog.data.dto.response.CommentResponseDto;
import com.company.blog.data.dto.response.PaginationInfoPostResponseDto;
import com.company.blog.data.dto.response.PostResponseDto;
import com.company.blog.data.entity.Comment;
import com.company.blog.data.entity.Post;
import com.company.blog.data.repository.PostRepository;
import com.company.blog.exception.ResourceNotFoundException;
import com.company.blog.mapper.PostMapperUtility;
import com.company.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.company.blog.mapper.EntityToDto.INSTANCE;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapperUtility postMapperUtility;

    @Override
    public PaginationInfoPostResponseDto getAll(Integer pageNumber, Integer pageSize, String sortBy, String sortType) {
        Sort sort = sortType.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> postRepositoryAll = postRepository.findAll(pageable);
        List<Post> postList = postRepositoryAll.getContent();
        return postMapperUtility.preparePaginationInfoPostResponseDto(postList, postRepositoryAll);
    }

    @Override
    public PostResponseDto createPost(PostRequestDto requestDto) {
        return INSTANCE.toDto(postRepository.save(ModelMapperConfiguration.map(requestDto, Post.class)));
    }

    @Override
    public PostResponseDto getById(Long id) {
        return ModelMapperConfiguration.map(postRepository.getById(id), PostResponseDto.class);
    }

    @Override
    public PostResponseDto updateById(Long id, PostRequestDto postRequestDto) {
        return ModelMapperConfiguration.map(postRepository.save(ModelMapperConfiguration.map(postRequestDto, postRepository.getById(id))), PostResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.delete(postRepository.getById(id));
    }
}
