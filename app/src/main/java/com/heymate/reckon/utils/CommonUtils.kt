package com.heymate.reckon.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.google.gson.Gson
import com.heymate.reckon.R

class CommonUtils {
    companion object {
        val DEFAULT = -1
        val LEFT_TO_RIGHT = 1
        val TOP_TO_BOTTOM = 2


        /**
         * @param object
         * @return
         */
        fun convertToJson(`object`: Any): String {
            val gson = Gson()
            return gson.toJson(`object`)
        }

        fun showLoadingDialog(context: Context): Dialog {
            val progressDialog = Dialog(context, R.style.AppTheme_ProgressDialog)
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            return progressDialog
        }

        fun startActivity(context: Activity, className: Class<*>) {
            startActivity(context, className, null, -1, DEFAULT)
        }

        fun startActivity(context: Activity, className: Class<*>, extras: Bundle) {
            startActivity(context, className, extras, -1, DEFAULT)
        }


        fun startActivityForResult(context: Activity, className: Class<*>, requestCode: Int) {
            startActivityForResult(context, className, null, -1, DEFAULT, requestCode)
        }

        fun startActivityForResult(context: Activity, className: Class<*>, extras: Bundle, requestCode: Int) {
            startActivityForResult(context, className, extras, -1, DEFAULT, requestCode)
        }

        fun startActivity(context: Activity, className: Class<*>, extras: Bundle?, flags: Int,
                          transitionType: Int) {
            val intent = Intent(context, className)
            if (extras != null)
                intent.putExtras(extras)
            if (flags != -1)
                intent.addFlags(flags)
            context.startActivity(intent)
            when (transitionType) {
                DEFAULT, LEFT_TO_RIGHT -> context.overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out)
            }
        }


        fun startActivityForResult(context: Activity, className: Class<*>, extras: Bundle?, flags: Int,
                                   transitionType: Int, requestCode: Int) {
            val intent = Intent(context, className)
            if (extras != null)
                intent.putExtras(extras)
            if (flags != -1)
                intent.addFlags(flags)
            context.startActivityForResult(intent, requestCode)
            when (transitionType) {
                DEFAULT, LEFT_TO_RIGHT -> context.overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out)
            }
        }

        fun isPhoneNumber(input: String): Boolean {
            return if (input.matches("\\d+(?:\\.\\d+)?".toRegex())) {
                true
            } else false
        }

        fun isIFSCCode(input: String): Boolean {
            return if (input.matches("^[A-Za-z]{4}[a-zA-Z0-9]{7}$".toRegex())) {
                true
            } else false
        }

        fun appInstalledOrNot(context: Context, uri: String): Boolean {
            val pm = context.packageManager
            try {
                pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
                return true
            } catch (e: PackageManager.NameNotFoundException) {
            }

            return false
        }
    }
}