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

        var viewLine = convertView
        var viewHolder: ViewHolder
        if (viewLine == null){
            viewLine = inflater.inflate(R.layout.single_line, parent, false)
            viewHolder = ViewHolder(viewLine)
            viewLine.tag = viewHolder
        }
        else {
            viewHolder = viewLine.getTag() as ViewHolder
        }

        viewHolder.zodiacImg.setImageResource(zodiacPics.get(position))
        viewHolder.zodiacTvName.text = zodiacNames.get(position)
        viewHolder.zodiacTvDate.text = zodiacDates.get(position)

        return viewLine
//        return super.getView(position, convertView, parent)
    }

    class ViewHolder(viewOfLine: View){
        var zodiacImg: ImageView
        var zodiacTvName: TextView
        var zodiacTvDate: TextView
        init {
            this.zodiacImg = viewOfLine.findViewById<ImageView>(R.id.imgZodiacIcon)
            this.zodiacTvName = viewOfLine.findViewById<TextView>(R.id.tvZodiacName)
            this.zodiacTvDate = viewOfLine.findViewById<TextView>(R.id.tvZodiacDescription)
        }
    }
}