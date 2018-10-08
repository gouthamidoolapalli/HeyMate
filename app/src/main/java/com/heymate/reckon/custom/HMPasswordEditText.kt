package com.heymate.reckon.custom

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.AttrRes
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.widget.AppCompatEditText
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import com.heymate.reckon.R

class HMPasswordEditText : AppCompatEditText {
        private var eye: Drawable? = null
        private var eyeWithStrike: Drawable? = null
        private var alphaEnabled: Int = 0
        private var alphaDisabled: Int = 0
        private var visible = false
        private var useStrikeThrough = true
        private var drawableClick: Boolean = false

        constructor(context: Context) : super(context) {
            init(null)
        }

        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
            init(attrs)
        }

        constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
            init(attrs)
        }

        private fun init(attrs: AttributeSet?) {
            if (attrs != null) {

                val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HMTextView)
                val fontName = typedArray.getInt(R.styleable.PasswordView_useStrikeThrough, 0)
                setTypeface(FontCache.getTypeface(context, fontName))
                useStrikeThrough = typedArray.getBoolean(R.styleable.PasswordView_useStrikeThrough, true)
                typedArray.recycle()

            }

            val enabledColor = resolveAttr(android.R.attr.textColorPrimary)
            val isIconDark = isDark(enabledColor)
            alphaEnabled = (255 * if (isIconDark) ALPHA_ENABLED_DARK else ALPHA_ENABLED_LIGHT).toInt()
            alphaDisabled = (255 * if (isIconDark) ALPHA_DISABLED_DARK else ALPHA_DISABLED_LIGHT).toInt()

            eye = getToggleDrawable(context, R.drawable.ic_eye, enabledColor)
            eyeWithStrike = getToggleDrawable(context, R.drawable.ic_eye_strike, enabledColor)
            eyeWithStrike!!.alpha = alphaEnabled
            setup()
        }

        @ColorInt
        private fun resolveAttr(@AttrRes attrRes: Int): Int {
            val ta = TypedValue()
            context.theme.resolveAttribute(attrRes, ta, true)
            return ContextCompat.getColor(context, ta.resourceId)
        }

        private fun getToggleDrawable(context: Context, @DrawableRes drawableResId: Int, @ColorInt tint: Int): Drawable {
            // Make sure to mutate so that if there are multiple password fields, they can have
            // different visibilities.
            val drawable = getVectorDrawableWithIntrinsicBounds(context, drawableResId).mutate()
            DrawableCompat.setTint(drawable, tint)
            return drawable
        }

        private fun getVectorDrawableWithIntrinsicBounds(context: Context, @DrawableRes drawableResId: Int): Drawable {
            val drawable = getVectorDrawable(context, drawableResId)
            drawable!!.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
            return drawable
        }

        private fun getVectorDrawable(context: Context, @DrawableRes drawableResId: Int): Drawable? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.getDrawable(drawableResId)
            } else {
                VectorDrawableCompat.create(context.resources, drawableResId, context.theme)
            }
        }

        protected fun setup() {
            val start = selectionStart
            val end = selectionEnd
            inputType = InputType.TYPE_CLASS_TEXT or if (visible) InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD else InputType.TYPE_TEXT_VARIATION_PASSWORD
            setSelection(start, end)
            val drawable = if (useStrikeThrough && !visible) eyeWithStrike else eye
            val drawables = compoundDrawables
            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3])
            eye!!.alpha = if (visible && !useStrikeThrough) alphaEnabled else alphaDisabled
        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            val drawableRightX = width - paddingRight
            val drawableLeftX = drawableRightX - compoundDrawables[2].bounds.width()
            val eyeClicked = event.x >= drawableLeftX && event.x <= drawableRightX

            if (event.action == MotionEvent.ACTION_DOWN && eyeClicked) {
                drawableClick = true
                return true
            }

            if (event.action == MotionEvent.ACTION_UP) {
                if (eyeClicked && drawableClick) {
                    drawableClick = false
                    visible = !visible
                    setup()
                    invalidate()
                    return true
                } else {
                    drawableClick = false
                }
            }

            return super.onTouchEvent(event)
        }

        override fun setInputType(type: Int) {
            this.typeface = getTypeface()
            super.setInputType(type)
            setTypeface(typeface)
        }

        override fun setError(error: CharSequence) {
            throw RuntimeException("Please use TextInputLayout.setError() instead!")
        }

        override fun setError(error: CharSequence, icon: Drawable) {
            throw RuntimeException("Please use TextInputLayout.setError() instead!")
        }

        fun setUseStrikeThrough(useStrikeThrough: Boolean) {
            this.useStrikeThrough = useStrikeThrough
        }

        companion object {

            private val ALPHA_ENABLED_DARK = .54f
            private val ALPHA_DISABLED_DARK = .38f
            private val ALPHA_ENABLED_LIGHT = 1f
            private val ALPHA_DISABLED_LIGHT = .5f

            private fun isDark(hsl: FloatArray): Boolean {
                return hsl[2] < 0.5f
            }

            fun isDark(@ColorInt color: Int): Boolean {
                val hsl = FloatArray(3)
                android.support.v4.graphics.ColorUtils.colorToHSL(color, hsl)
                return isDark(hsl)
            }
        }


}