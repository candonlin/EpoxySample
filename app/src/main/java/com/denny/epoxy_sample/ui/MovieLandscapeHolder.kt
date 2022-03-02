package com.denny.epoxy_sample.ui

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.denny.epoxy_sample.R
import java.util.*

/**
 * author: Denny
 * created on: 2022/3/2 下午 05:26
 */
@EpoxyModelClass(layout = R.layout.movie_land_holder)
abstract class MovieLandscapeHolder : EpoxyModelWithHolder<MovieLandscapeHolder.Holder>() {

    @EpoxyAttribute
    var movieId = ""

    @EpoxyAttribute
    var imagePoster = ""

    @EpoxyAttribute
    var textTitle = "--"

    @EpoxyAttribute
    var rating = 0.0f

    @EpoxyAttribute
    var ratingTotalCountText: String? = null

    @EpoxyAttribute
    var releaseDateText: String? = null

    @EpoxyAttribute
    var genre: String? = null

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var itemClickListener: (String) -> Unit = {}

    override fun bind(holder: Holder) {
        Glide
            .with(holder.itemView)
            .asBitmap()
            .load("https://image.tmdb.org/t/p/w185"+imagePoster).into(holder.imagePoster)
//        holder.imagePoster.loadImage(imagePoster)
        holder.textTitle.text = textTitle
        holder.ratingBar.rating = rating
        holder.textRating.text = "%.1f (%s)".format(rating, ratingTotalCountText)
        holder.textReleaseDate.text = releaseDateText
        holder.textGenres.text = genre
        holder.itemView.setOnClickListener { itemClickListener(movieId) }
    }

    class Holder : EpoxyHolder() {

        lateinit var itemView: View
        lateinit var imagePoster: ImageView
        lateinit var textTitle: TextView
        lateinit var ratingBar: RatingBar
        lateinit var textRating: TextView
        lateinit var textReleaseDate: TextView
        lateinit var textGenres: TextView
        lateinit var buttonBookmark: ImageButton

        override fun bindView(itemView: View) {
            this.itemView = itemView
            imagePoster = itemView.findViewById(R.id.imagePoster)
            textTitle = itemView.findViewById(R.id.textTitle)
            ratingBar = itemView.findViewById(R.id.ratingBar)
            textRating = itemView.findViewById(R.id.textRating)
            textReleaseDate = itemView.findViewById(R.id.textReleaseDate)
            textGenres = itemView.findViewById(R.id.textGenres)
            buttonBookmark = itemView.findViewById(R.id.buttonBookmark)
        }

    }
}
//@Composable
//@Preview
//fun MovieLandscapeWidgetPreview() {
//    MovieLandscapeWidget(
//        movieId = UUID.randomUUID().toString(),
//        imagePoster = "https://image.tmdb.org/t/p/w780//1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
//        textTitle = "Spider-Man: No Way Home",
//        isBookmark = true,
//        rating = 9.5f,
//        ratingTotalCountText = "1.14k review",
//        releaseDateText = "2021-12-15",
//        genre = "Actions, Adventure, Science Fiction"
//    )
//}