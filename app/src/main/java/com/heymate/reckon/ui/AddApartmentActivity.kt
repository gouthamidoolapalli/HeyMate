package com.heymate.reckon.ui

import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import kotlinx.android.synthetic.main.activity_confirm_password.*

class AddApartmentActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_add_apartment
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string.add), getString(R.string.apartment), true)
    }


}
