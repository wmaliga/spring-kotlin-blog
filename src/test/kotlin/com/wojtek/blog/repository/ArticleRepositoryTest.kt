package com.wojtek.blog.repository

import com.wojtek.blog.entity.Article
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDateTime

@DataJpaTest
class ArticleRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `Find all articles`() {
        val added = LocalDateTime.now();

        val article1 = Article("Title 1", "Headline 1", "Content 1", added.minusDays(1))
        val article2 = Article("Title 2", "Headline 2", "Content 2", added.minusDays(2))
        val article3 = Article("Title 3", "Headline 3", "Content 3", added.minusDays(3))

        entityManager.persist(article1)
        entityManager.persist(article2)
        entityManager.persist(article3)

        entityManager.flush()

        val articles = articleRepository.findAllByOrderByAddedDesc()

        assertThat(articles).extracting<String>(Article::title).containsOnly("Title 3", "Title 2", "Title 1")
    }
}