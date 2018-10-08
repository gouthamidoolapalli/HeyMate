package com.heymate.reckon.custom

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.heymate.reckon.R

class HMTextView : AppCompatTextView {
    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr){
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HMTextView)
        val fontName = typedArray.getInt(R.styleable.HMTextView_fontName, 0)
        typeface = FontCache.getTypeface(getContext(), fontName)
        typedArray.recycle()
    }
}