package com.ferhat.horoscopeguide

import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var ivBanner = findViewById<ImageView>(R.id.ivDetailBanner)
        var tvSignName = findViewById<TextView>(R.id.tvDetailSignName)
        var tvDescription = findViewById<TextView>(R.id.tvDetailDescription)

        var position = intent.extras?.get("position") as Int
        var allSignData = intent.extras?.get("allSignData") as ArrayList<Sign>
        var choosenSign = allSignData[position]

        ivBanner.setImageResource(choosenSign.zodiacBanner)
        tvSignName.text = choosenSign.zodiacName
        tvDescription.text = Html.fromHtml(choosenSign.zodiacDescription)
    }
}