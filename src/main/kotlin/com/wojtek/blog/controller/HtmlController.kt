package com.wojtek.blog.controller

import com.wojtek.blog.entity.Article
import com.wojtek.blog.extensions.format
import com.wojtek.blog.repository.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val articleRepository: ArticleRepository) {

    @GetMapping("/")
    fun blog(model: Model): String {
        model["title"] = "Blog"
        model["articles"] = this.articleRepository.findAllByOrderByAddedDesc().map { it.render() }
        return "blog"
    }

    fun Article.render() = ArticleRender(
        title,
        headline,
        content,
        author = "${author.firstName} ${author.lastName}",
        added.format()
    )

    data class ArticleRender(
        var title: String,
        var headline: String,
        var content: String,
        var author: String,
        var added: String,
    )
}
