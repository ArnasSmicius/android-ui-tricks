package com.arnassmicius.androiduitricks.coordinatorlayout.views

import android.animation.AnimatorInflater
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.appcompat.view.ContextThemeWrapper
import androidx.cardview.widget.CardView
import com.arnassmicius.androiduitricks.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.view_collapsing_toolbar_with_fab.view.*

class CollapsingToolbarWithFabView(
        context: Context,
        attrs: AttributeSet
) : MaterialCardView(context, attrs) {

    var title = ""
        set(value) {
            field = value
            titleTextView.text = value
        }

    init {
        View.inflate(context, R.layout.view_collapsing_toolbar_with_fab, this)
        stateListAnimator = AnimatorInflater.loadStateListAnimator(context, R.animator.clickable_state_animator)

        val attributes = intArrayOf(android.R.attr.selectableItemBackground)
        val ta = (context as Activity).obtainStyledAttributes(attributes)
        foreground = ta.getDrawable(0)
        ta.recycle()

        coordinatorLayoutFab.setOnClickListener {
            callOnClick()
        }

        val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.CollapsingToolbarWithFabView,
                0,
                0
        )
        try {
            val text = typedArray.getString(R.styleable.CollapsingToolbarWithFabView_title)
            text?.let {
                title = text
            }
        } finally {
            typedArray.recycle()
        }
    }
}