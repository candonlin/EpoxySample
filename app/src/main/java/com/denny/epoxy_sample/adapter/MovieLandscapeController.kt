package com.denny.epoxy_sample.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.denny.epoxy_sample.bean.MovieListResponse
import com.denny.epoxy_sample.bean.display5StarsRating
import com.denny.epoxy_sample.ui.MovieLandscapeHolder_


/**
 * author: Denny
 * created on: 2022/3/2 下午 02:05
 */
class MovieLandscapeController : TypedEpoxyController<ArrayList<MovieListResponse>>() {
    override fun buildModels(data: ArrayList<MovieListResponse>?) {
        data?.forEachIndexed { index, movie ->
            MovieLandscapeHolder_()
                .id(movie.id)
                .rating(movie.display5StarsRating())
                .ratingTotalCountText(movie.voteCount.toString())
                .imagePoster(movie.posterPath.toString())
                .textTitle(movie.title.toString())
                .releaseDateText(movie.releaseDate)
//                .genre(it.g?.map { it.name }?.joinToString())
                .addTo(this)
        }


    }


}