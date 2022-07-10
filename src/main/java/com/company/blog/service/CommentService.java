package com.company.blog.service;

import com.company.blog.data.dto.request.CommentRequestDto;
import com.company.blog.data.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    CommentResponseDto createComment(Long postId, CommentRequestDto commentRequestDto);

    List<CommentResponseDto> getAllByPostId(Long postId);

    CommentResponseDto getByPostAndCommentId(Long postId, Long commentId);

    CommentResponseDto updateComment(Long postId, Long commentId, CommentRequestDto requestDto);

    void deleteComment(Long postId, Long commentId);
}
