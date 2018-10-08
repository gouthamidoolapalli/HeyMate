package com.heymate.reckon.ui

import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.app_bar_main.*

class DashboardActivity : BaseActivity() {
    override fun setContentLayoutId(): Int {
        return R.layout.activity_dashboard
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.toolbarNavigationClickListener = View.OnClickListener { drawer.openDrawer(GravityCompat.START) }
        toggle.isDrawerIndicatorEnabled = true
        toggle.setHomeAsUpIndicator(R.drawable.menulines) //set your own
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    fun onMenuClick(view: View) {
        drawer.closeDrawer(GravityCompat.START)
        when (view.id) {
            R.id.profile_click -> {
                CommonUtils.startActivity(
                        this,
                        ProfileActivity::class.java
                )
            }
            R.id.tv_join_apt -> {
                CommonUtils.startActivity(this, AddApartmentActivity::class.java)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_dashboard, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.getItemId()) {
            R.id.id_notification -> {
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}