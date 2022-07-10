package com.company.blog.mapper;

import com.company.blog.data.dto.request.PostRequestDto;
import com.company.blog.data.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToEntity {
    DtoToEntity INSTANCE = Mappers.getMapper(DtoToEntity.class);
//    Post toEntity(PostRequestDto postRequestDto);
}
