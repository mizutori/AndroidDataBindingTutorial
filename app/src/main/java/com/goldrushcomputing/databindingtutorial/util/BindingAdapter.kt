package com.goldrushcomputing.databindingtutorial.util

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.util.*

object BindingAdapter {

    //Typefaceオブジェクトを保持するキャッシュ
    private val typefaceCache: Map<String, Typeface> =
        HashMap()

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(
        imageView: ImageView,
        profileImageUrl: String
    ) {
        Picasso.get()
            .load(profileImageUrl)
            .into(imageView)
    }

    @BindingAdapter("font")
    @JvmStatic
    fun setTypeface(textView: TextView, fontName: String) {
        val typeface =
            if (typefaceCache.containsKey(fontName)) {
                typefaceCache.get(fontName)
            } else {
                Typeface.createFromAsset(textView.context.assets, "fonts/$fontName")
            }
        typeface?.let {
            textView.setTypeface(typeface)
        }
    }
}