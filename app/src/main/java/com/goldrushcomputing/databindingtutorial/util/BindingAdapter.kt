package com.goldrushcomputing.databindingtutorial.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.graphics.Typeface
import android.view.View
import android.widget.Button
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

    // ViewのVisibility変更時にフェードイン／アウトのアニメーション効果を加えるBindingAdapter
    @BindingAdapter("bind:visibilityWithAnimation")
    @JvmStatic
    fun setVisibility(
        view: View,
        visibility: Int
    ) {

        //特定のクラスにだけアニメーションを適用したり外したりする場合。
        if (view is Button) {
        }

        //特定のタグのビューだけアニメーションを変えたり、外したりする場合。
        if (view.tag == "foo") {
        }

        //今のvisibilityから変化がないので何もしない
        if (view.visibility == visibility) {
            return
        }
        val startAlpha =
            if (view.visibility == View.VISIBLE) 1f else 0f
        val endAlpha = if (visibility == View.VISIBLE) 1f else 0f
        val animator = ObjectAnimator.ofFloat(
            view,
            View.ALPHA, startAlpha, endAlpha
        )
        animator.setAutoCancel(true)
        animator.duration = 1000
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(anim: Animator) {
                view.visibility = View.VISIBLE
            }

            override fun onAnimationCancel(anim: Animator) {}
            override fun onAnimationEnd(anim: Animator) {
                view.alpha = 1f
                view.visibility = visibility
            }
        })
        animator.start()
    }
}