package com.codersee.jsonviewtutorial.controller

import com.codersee.jsonviewtutorial.dto.ArticleDto
import com.fasterxml.jackson.annotation.JsonView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticleController {

    private val articles = mapOf(
        1L to ArticleDto(
            1L, "Article 1", "Spring Framework",
            "Content 1", 1000, 30
        ),
        2L to ArticleDto(
            2L, "Article 2", "Kotlin",
            "Content 2", 5000, 54
        )
    )

    @GetMapping
    @JsonView(Views.List::class)
    fun getAllArticles(): List<ArticleDto> =
        articles.values.toList()


    @GetMapping("/{id}")
    fun getArticleDetails(@PathVariable id: Long): ArticleDto? =
        articles[id]

    @JsonView(Views.Analytics::class)
    @GetMapping("/{id}/analytics")
    fun getArticleAnalytics(@PathVariable id: Long): ArticleDto? =
        articles[id]

    @JsonView(Views.ListAndAnalytics::class)
    @GetMapping("/{id}/list-and-analytics")
    fun getArticleListAndAnalytics(@PathVariable id: Long): ArticleDto? =
        articles[id]

}