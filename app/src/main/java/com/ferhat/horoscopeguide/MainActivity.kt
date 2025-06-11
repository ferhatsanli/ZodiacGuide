package com.ferhat.horoscopeguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ferhat.horoscopeguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val TAG = "FERHAT"
    companion object {
        var counter = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val zodiacNames = resources.getStringArray(R.array.zodiac_sign_names)
        val zodiacDates = resources.getStringArray(R.array.zodiac_birth_dates)
        val zodiacSignDrawables = arrayOf(
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


//      var zodiacAdapter = ZodiacAdapter(this, R.layout.single_line, R.id.tvZodiacName, zodiacNames, zodiacDates, zodiacSignDrawables)
//        binding.listHoroscopes.adapter = zodiacAdapter
//        binding.listHoroscopes.setOnItemClickListener { parent, view, position, id ->
////            var tv = view as TextView
////            Toast.makeText(this@MainActivity, "Clicked on ${tv.text} at $position.position", Toast.LENGTH_LONG).show()
//
//        }

        var zodiacAdapter = ZodiacBaseAdapter(this)
        binding.listHoroscopes.adapter = zodiacAdapter

    }
}