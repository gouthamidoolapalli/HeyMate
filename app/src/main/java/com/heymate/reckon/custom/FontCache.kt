package com.heymate.reckon.custom

import android.content.Context
import android.graphics.Typeface
import java.util.HashMap

class FontCache {
    companion object {
        val LIGHT = 0
        val ROMAN = 1
        val MEDIUM = 2
        val BOLD = 3

        private val mFontCache = HashMap<String, Typeface>()

        /**
         * @param context
         * @param typeValue
         * @return
         */


        fun getTypeface(context: Context, typeValue: Int): Typeface? {
            var typeface: Typeface? = null
            val typefaceName = getFontName(typeValue)
            if (mFontCache.containsKey(typefaceName)) {
                typeface = mFontCache[typefaceName]
            } else {
                typeface = Typeface.createFromAsset(context.assets, "fonts/$typefaceName")
                mFontCache[typefaceName] = typeface
            }
            return typeface
        }


        /**
         * @param typeValue
         * @return
         */


        fun getFontName(typeValue: Int): String {
            when (typeValue) {

                LIGHT -> return "Poppins_Light.ttf"
                ROMAN -> return "Poppins_Roman.ttf"
                MEDIUM -> return "Poppins_Medium.ttf"
                BOLD -> return "Poppins_Bold.ttf"
                else -> return "Poppins_Light.ttf"
            }
        }
    }

}
