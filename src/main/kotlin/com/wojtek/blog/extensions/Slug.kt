package com.wojtek.blog.extensions

fun String.toSlug() = toLowerCase()
    .replace("\n", " ")
    .split(" ")
    .joinToString("-")