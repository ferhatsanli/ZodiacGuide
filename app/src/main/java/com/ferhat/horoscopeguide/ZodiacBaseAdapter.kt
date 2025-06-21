package com.ferhat.horoscopeguide

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ZodiacBaseAdapter(context: Context, zodiacData: ArrayList<Sign>) : BaseAdapter() {
    var allSigns: ArrayList<Sign>
    var context: Context
    private val TAG = "FERHAT.${this::class.java.simpleName}"
    init {
        allSigns = zodiacData
        this.context = context

    }
    override fun getCount(): Int = allSigns.size

    override fun getItem(position: Int): Any? = allSigns[position]

    // itemId related with databases which I do not use it at this moment
    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var theView = convertView
        var theViewHolder: ViewHolderBase
        if (theView == null){
            var inflater = LayoutInflater.from(this.context)
            theView = inflater.inflate(R.layout.single_line, parent, false)
            theViewHolder = ViewHolderBase(theView)
            theView.tag = theViewHolder
            MainActivity.counter++
            Log.i(TAG, "getView: ${MainActivity.counter}")
        }
        else {
            theViewHolder = theView.getTag() as ViewHolderBase
        }

        theViewHolder.imgZodiacSign.setImageResource(allSigns[position].zodiacIcon)
        theViewHolder.tvZodiacName.setText(allSigns[position].zodiacName)
        theViewHolder.tvZodiacDate.setText(allSigns[position].zodiacDate)
        theViewHolder.tvZodiacGroup.setText(allSigns[position].zodiacGroup)
        return theView
    }
}

class ViewHolderBase(viewZodiacLine: View) {
    var imgZodiacSign: ImageView
    var tvZodiacName: TextView
    var tvZodiacDate: TextView
    var tvZodiacGroup: TextView

    init {
        this.imgZodiacSign = viewZodiacLine.findViewById<ImageView>(R.id.imgZodiacIcon)
        this.tvZodiacName = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacName)
        this.tvZodiacDate = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacDate)
        this.tvZodiacGroup = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacGroup)
    }
}