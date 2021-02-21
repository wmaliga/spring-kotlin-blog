package com.wojtek.blog.extensions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SlugTest {

    @Test
    fun `Convert text to slug`() {
        assertThat("Text To Convert".toSlug()).isEqualTo("text-to-convert")
    }
}
