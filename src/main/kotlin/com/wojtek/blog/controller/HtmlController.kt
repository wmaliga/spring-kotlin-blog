package com.wojtek.blog.controller

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
        model["articles"] = this.articleRepository.findAllByOrderByAddedDesc()
        return "blog"
    }
}
