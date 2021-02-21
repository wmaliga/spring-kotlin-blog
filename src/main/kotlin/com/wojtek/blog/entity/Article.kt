package com.wojtek.blog.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    var added: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)
