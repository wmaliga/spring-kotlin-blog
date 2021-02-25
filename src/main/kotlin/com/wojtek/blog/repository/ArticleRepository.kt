package com.wojtek.blog.repository

import com.wojtek.blog.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository: CrudRepository<Article, Long> {
    fun findAllByOrderByAddedDesc(): List<Article>
    fun findBySlug(slug: String): Article?
}
