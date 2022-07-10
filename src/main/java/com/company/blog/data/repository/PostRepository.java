package com.company.blog.data.repository;

import com.company.blog.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends JpaRepository<Post,Long>, PagingAndSortingRepository<Post,Long> {
}
