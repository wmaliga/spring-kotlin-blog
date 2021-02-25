package com.wojtek.blog.repository

import com.wojtek.blog.entity.Article
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ArticleRepositoryTest @Autowired constructor(
    val articleRepository: ArticleRepository
) {

    @Test
    fun `Find all articles`() {
        val articles = articleRepository.findAllByOrderByAddedDesc()

        assertThat(articles).extracting<String>(Article::title)
            .contains("Pieski kotki", "Dupa maryna", "Crossfit")
    }

    @Test
    fun `Find by slug`() {
        val article = articleRepository.findBySlug("pieski-kotki")

        assertThat(article?.title).isEqualTo("Pieski kotki")
    }
}
