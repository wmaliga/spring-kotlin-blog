package com.wojtek.blog.repository

import com.wojtek.blog.entity.Article
import com.wojtek.blog.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.TestPropertySource
import java.time.LocalDateTime

@DataJpaTest
@TestPropertySource(properties = ["spring.datasource.initialization-mode=never"])
class ArticleRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository
) {

    @Test
    fun `Find all articles`() {
        val added = LocalDateTime.now()

        val author = User("login", "First Name", "Last Name")

        val article1 = Article("Title 1", "Headline 1", "Content 1", author, added.minusDays(1))
        val article2 = Article("Title 2", "Headline 2", "Content 2", author, added.minusDays(2))
        val article3 = Article("Title 3", "Headline 3", "Content 3", author, added.minusDays(3))

        entityManager.persist(author)

        entityManager.persist(article1)
        entityManager.persist(article2)
        entityManager.persist(article3)

        entityManager.flush()

        val articles = articleRepository.findAllByOrderByAddedDesc()

        assertThat(articles).extracting<String>(Article::title).containsOnly("Title 3", "Title 2", "Title 1")
    }
}
