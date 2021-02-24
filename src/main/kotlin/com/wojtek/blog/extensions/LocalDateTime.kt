package com.wojtek.blog.extensions

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder

fun LocalDateTime.format(): String = this.format(formatter)

private val formatter = DateTimeFormatterBuilder()
    .appendPattern("yyyy-MM-dd HH:MM:SS")
    .toFormatter()
