package com.ferhat.horoscopeguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class ZodiacAdapter(var transferredContext: Context, res: Int, tvResId: Int, var zodiacNames: Array<String>, var zodiacDates: Array<String>, var zodiacPics: Array<Int>)
    : ArrayAdapter<String>(transferredContext, res, tvResId, zodiacNames) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater = LayoutInflater.from(transferredContext)
        var viewLine = inflater.inflate(R.layout.single_line, parent, false)

        var zodiacImg = viewLine.findViewById<ImageView>(R.id.imgZodiacIcon)
        var zodiacTvName = viewLine.findViewById<TextView>(R.id.tvZodiacName)
        var zodiacTvDate = viewLine.findViewById<TextView>(R.id.tvZodiacDescription)

        zodiacImg.setImageResource(zodiacPics.get(position))

        zodiacTvName.text = zodiacNames.get(position)
        zodiacTvDate.text = zodiacDates.get(position)

        return viewLine
//        return super.getView(position, convertView, parent)
    }
}