package com.example.gallerysorta.data

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.gallerysorta.R

data class Item(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)

class Datasource {
    fun loadItems(): List<Item> {
        return listOf<Item>(
            Item(
                R.string.qoute_1,
                R.drawable.image1
            ),
            Item(
                R.string.qoute_2,
                R.drawable.image2
            ),
            Item(
                R.string.qoute_3,
                R.drawable.image3
            ),
            Item(
                R.string.qoute_4,
                R.drawable.image4
            ),
            Item(
                R.string.qoute_5,
                R.drawable.image5
            ),
            Item(
                R.string.qoute_6,
                R.drawable.image6
            ),
            Item(
                R.string.qoute_7,
                R.drawable.image7
            ),
            Item(
                R.string.qoute_8,
                R.drawable.image8
            ),
        )
    }
}