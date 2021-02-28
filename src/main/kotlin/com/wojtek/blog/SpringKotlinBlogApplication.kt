package com.wojtek.blog

import com.wojtek.blog.configuration.BlogProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class SpringKotlinBlogApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinBlogApplication>(*args)
}
