package com.heymate.reckon.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.heymate.reckon.R

class ServicesAdapter(var context: Context, private val servicesList: List<String>?) : BaseAdapter() {
    val mInflater: LayoutInflater = LayoutInflater.from(context)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.view_drop_down_menu, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }

        // setting adapter item height programatically.

        val params = view.layoutParams
        params.height = 60
        view.layoutParams = params
        if (servicesList != null && servicesList.isNotEmpty()) {
            vh.label.text = servicesList.get(position)
        }
        return view
    }

    override fun getItem(position: Int): String {

        return servicesList!!.get(position)

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {
        return servicesList!!.size
    }

    private class ItemRowHolder(row: View?) {

        val label: TextView = row?.findViewById(R.id.txtDropDownLabel) as TextView

    }

}