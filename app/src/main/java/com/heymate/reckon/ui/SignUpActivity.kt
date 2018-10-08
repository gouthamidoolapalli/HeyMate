package com.heymate.reckon.ui

import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity :  BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_sign_up
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string._try),getString(R.string.everyfield), false)
    }

    fun onClickSubmit(view: View){
        CommonUtils.startActivity(this, SignInActivity::class.java)
        finish()
    }
}