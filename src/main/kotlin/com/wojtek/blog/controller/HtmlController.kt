package com.wojtek.blog.controller

import com.wojtek.blog.entity.Article
import com.wojtek.blog.extensions.format
import com.wojtek.blog.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(private val articleRepository: ArticleRepository) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = this.articleRepository.findAllByOrderByAddedDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = this.articleRepository
            .findBySlug(slug)
            ?.render()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found")
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = ArticleRender(
        title,
        headline,
        content,
        author = "${author.firstName} ${author.lastName}",
        added.format(),
        slug
    )

    data class ArticleRender(
        var title: String,
        var headline: String,
        var content: String,
        var author: String,
        var added: String,
        var slug: String,
    )
}
