package com.codersee.jsonviewtutorial.dto

import com.codersee.jsonviewtutorial.controller.Views
import com.fasterxml.jackson.annotation.JsonView

data class ArticleDto(
    @field:JsonView(Views.List::class)
    val id: Long,
    @field:JsonView(Views.List::class)
    val title: String,
    @field:JsonView(Views.List::class)
    val category: String,
    val content: String,
    @field:JsonView(Views.Analytics::class)
    val views: Long,
    @field:JsonView(Views.Analytics::class)
    val likes: Long
)