package com.wojtek.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinBlogApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinBlogApplication>(*args)
}
