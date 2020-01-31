package com.jcbivfaulm.mvvmexample.movie.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
	val image: String? = null,
	val rating: Double? = null,
	val genre: List<String?>? = null,
	val title: String? = null,
	val releaseYear: Int? = null
):Parcelable
