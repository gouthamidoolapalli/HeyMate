package com.heymate.reckon.ui

import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils

class LaunchLoginActivity : BaseActivity() {
    override fun init() {

    }

    override fun setContentLayoutId(): Int {

        return R.layout.activity_launch_login
    }

    fun OnClickSignUp(view: View) {
        CommonUtils.startActivity(this, SignUpActivity::class.java)
    }

    fun OnClickSignIn(view: View) {
        CommonUtils.startActivity(this, SignInActivity::class.java)
    }
}
