package com.heymate.reckon.ui

import android.content.Intent
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_confirm_password.*

class ConfirmPasswordActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_confirm_password
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string.give), getString(R.string.best), false)
        tv_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        tv_password.transformationMethod = PasswordTransformationMethod.getInstance()
        tv_confirm_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        tv_confirm_password.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    fun onClickSubmit(view: View) {
        CommonUtils.startActivity(this, SignInActivity::class.java,null, Intent.FLAG_ACTIVITY_CLEAR_TOP, CommonUtils.DEFAULT)
        finish()
    }

}
