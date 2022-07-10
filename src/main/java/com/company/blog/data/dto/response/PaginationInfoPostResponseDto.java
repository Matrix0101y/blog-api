package com.company.blog.data.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class PaginationInfoPostResponseDto {
    private List<PostResponseDto> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}
