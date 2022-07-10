package com.company.blog.mapper;

import com.company.blog.data.dto.response.PostResponseDto;
import com.company.blog.data.entity.Post;
import com.company.blog.data.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Mapper
public interface EntityToDto {
    EntityToDto INSTANCE = Mappers.getMapper(EntityToDto.class);
    PostResponseDto toDto(Post post);
}
