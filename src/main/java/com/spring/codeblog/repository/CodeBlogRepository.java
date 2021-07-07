package com.spring.codeblog.repository;

import com.spring.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//Essa interface vai gerenciar a percistencia de dados do DB
//Spring Data
public interface CodeBlogRepository extends JpaRepository<Post, Long> {
}
