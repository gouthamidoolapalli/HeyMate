package com.heymate.reckon.ui

import android.content.Context
import com.heymate.reckon.BaseActivity
import com.heymate.reckon.R
import com.heymate.reckon.ui.adapters.ServicesAdapter
import kotlinx.android.synthetic.main.activity_add_service.*
import java.util.*
import kotlin.collections.ArrayList


class AddServiceActivity : BaseActivity() {
    var context: Context = this
    var servicesArray: Array<String>? = null;
    var servicesList : List<String>? = null;

    override fun setContentLayoutId(): Int {
        return R.layout.activity_add_service
    }

    override fun init() {
        setHeyMateActionBar(toolbar)
        setUpHeading(getString(R.string.add), getString(R.string.service), true)
        servicesArray = resources.getStringArray(R.array.services_list)
        servicesList = ArrayList<String>()
        for (item in (servicesArray as Array<out String>?)!!){
            (servicesList as ArrayList<String>).add(item)
        }

        var adapter: ServicesAdapter = ServicesAdapter(
                context,
                servicesList as ArrayList<String>
        );
        serviceSpinner?.adapter = adapter;
    }


}
