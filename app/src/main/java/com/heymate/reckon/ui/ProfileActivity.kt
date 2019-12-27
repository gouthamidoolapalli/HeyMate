package com.heymate.reckon.ui

import android.os.Bundle
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import kotlinx.android.synthetic.main.activity_signin.*

class ProfileActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_profile
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
    }

}
