package com.denny.epoxy_sample.bean

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

/**
 * author: Denny
 * created on: 2022/3/2 上午 10:20
 */
data class MovieListResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("poster_path")
    // 這邊使用 @ColumnInfo 是為了讓這個欄位可以在 DAO 直接使用 target entity 來更新 @Entity
    // 要讓欄位名稱可以對的起來而加上去的，不是為了存資料庫欄位
    val posterPath: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

//    @SerializedName("genres")
//    var genreList: List<Genre>?,

    @SerializedName("vote_average")
    val voteAverage: Float?,

    @SerializedName("vote_count")
    val voteCount: Int? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("genre_ids")
    val genreIds: List<Int>?

)
fun MovieListResponse.display5StarsRating(): Float = this.voteAverage?.div(2) ?: 0.0f
//fun MovieListResponse.displayVoteCount(): String = this.voteCount?.format() ?: PLACEHOLDER

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?
)

data class BaseList<T>(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: ArrayList<T>?,

    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)