package com.ferhat.horoscopeguide

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class ZodiacBaseAdapter(context: Context) : BaseAdapter() {
    var allSigns: ArrayList<Sign>
    var context: Context
    private val TAG = "FERHAT.${this::class.java.simpleName}"
    init {
        allSigns = ArrayList<Sign>(12)
        this.context = context

        var signNames = this.context.resources.getStringArray(R.array.zodiac_sign_names)
        var signDates = this.context.resources.getStringArray(R.array.zodiac_birth_dates)
        var signIcons = arrayOf(
            R.drawable.aries,
            R.drawable.taurus,
            R.drawable.gemini,
            R.drawable.cancer,
            R.drawable.leo,
            R.drawable.virgo,
            R.drawable.libra,
            R.drawable.scorpio,
            R.drawable.sagittarius,
            R.drawable.capricorn,
            R.drawable.aquarius,
            R.drawable.pisces
        )

        // init arraylist
        for (i in 0..11){
            var tempSign = Sign(signIcons[i], signNames[i], signDates[i])
            allSigns.add(tempSign)
        }
    }
    override fun getCount(): Int {
        return allSigns.size
    }

    override fun getItem(position: Int): Any? {
        return allSigns[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var theView = convertView
        if (theView == null){
            var inflater = LayoutInflater.from(this.context)
            theView = inflater.inflate(R.layout.single_line, parent, false)
            MainActivity.counter++
            Log.i(TAG, "getView: ${MainActivity.counter}")
        }
        theView.findViewById<ImageView>(R.id.imgZodiacIcon).setImageResource(allSigns[position].zodiacIcon)
        theView.findViewById<TextView>(R.id.tvZodiacName).setText(allSigns[position].zodiacName)
        theView.findViewById<TextView>(R.id.tvZodiacDescription).setText(allSigns[position].zodiacDesc)
        return theView
    }
}

data class Sign(var zodiacIcon: Int, var zodiacName: String, var zodiacDesc: String){

}

