package com.ferhat.horoscopeguide

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ZodiacBaseAdapter(context: Context) : BaseAdapter() {
    var allSigns: ArrayList<Sign>
    var context: Context
    private val TAG = "FERHAT.${this::class.java.simpleName}"
    init {
        allSigns = ArrayList<Sign>(12)
        this.context = context

        var signNames = this.context.resources.getStringArray(R.array.zodiac_sign_names)
        var signDates = this.context.resources.getStringArray(R.array.zodiac_birth_dates)
        var signGroup = this.context.resources.getStringArray(R.array.zodiac_sign_groups)
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
            var tempSign = Sign(signIcons[i], signNames[i], signDates[i], signGroup[i])
            allSigns.add(tempSign)
        }
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
        theViewHolder.tvZodiacDesc.setText(allSigns[position].zodiacDesc)
        theViewHolder.tvZodiacGroup.setText(allSigns[position].zodiacGroup)
        return theView
    }
}

data class Sign(
    var zodiacIcon: Int,
    var zodiacName: String,
    var zodiacDesc: String,
    var zodiacGroup: String
)

class ViewHolderBase(viewZodiacLine: View) {
    var imgZodiacSign: ImageView
    var tvZodiacName: TextView
    var tvZodiacDesc: TextView
    var tvZodiacGroup: TextView

    init {
        this.imgZodiacSign = viewZodiacLine.findViewById<ImageView>(R.id.imgZodiacIcon)
        this.tvZodiacName = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacName)
        this.tvZodiacDesc = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacDescription)
        this.tvZodiacGroup = viewZodiacLine.findViewById<TextView>(R.id.tvZodiacGroup)
    }
}