package com.wojtek.blog.entity

import com.wojtek.blog.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var added: LocalDateTime = LocalDateTime.now(),
    var slug: String = title.toSlug(),
    @Id @GeneratedValue var id: Long? = null
)
