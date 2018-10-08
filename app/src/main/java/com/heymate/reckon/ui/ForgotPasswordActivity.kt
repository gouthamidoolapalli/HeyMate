package com.heymate.reckon.ui

import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_forgot_password
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string.reset),getString(R.string.password), false)
    }
    fun onClickSubmit(view: View){
        CommonUtils.startActivity(this, ConfirmPasswordActivity::class.java)
    }

}