package com.heymate.reckon.ui

import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_signin
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string.hey),getString(R.string.mate), false)
        tv_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        tv_password.transformationMethod = PasswordTransformationMethod.getInstance()
    }


    fun onClickForgotPassword(view: View){
        CommonUtils.startActivity(this, ForgotPasswordActivity::class.java)
    }
    fun onClickSubmit(view: View){
        CommonUtils.startActivity(this, DashboardActivity::class.java)
        finish()
    }
}