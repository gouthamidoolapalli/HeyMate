package com.heymate.reckon

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.MenuItem
import butterknife.ButterKnife
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.template_heading.*

abstract class BaseActivity : AppCompatActivity() {


    private var mProgressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentLayoutId())
        ButterKnife.bind(this)
        init()
    }

    fun setHeyMateActionBar(toolbar: Toolbar): Unit {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            supportActionBar!!.setTitle("")
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.left_arrow)
        }
    }

    /**
     * Set the layout assigned to this activity
     */
    protected abstract fun setContentLayoutId(): Int

    /**
     * Add the functionality here
     */
    protected abstract fun init()

    /**
     * load progress bar
     */
    fun showLoading() {
        hideLoading()
        if (mProgressDialog == null)
            mProgressDialog = CommonUtils.showLoadingDialog(this)
        mProgressDialog!!.show()
    }

    /**
     * hide progress bar
     */
    fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    fun setUpHeading(s1: String, s2: String, isCenter: Boolean) {
        if(isCenter){
            template_layout.gravity = Gravity.CENTER
        }else{
            template_layout.gravity = Gravity.CENTER_VERTICAL
        }
        tv_1.setText(s1);
        tv_2.setText(s2 + "...")
    }
}