package com.heymate.reckon.custom

import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import com.heymate.reckon.R

class HMButton : AppCompatButton {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HMTextView)
        val fontName = typedArray.getInt(R.styleable.HMTextView_fontName, 0)
        typeface = FontCache.getTypeface(getContext(), fontName)
        typedArray.recycle()
    }


}
