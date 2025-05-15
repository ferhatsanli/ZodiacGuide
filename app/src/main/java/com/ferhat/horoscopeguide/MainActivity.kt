package com.ferhat.horoscopeguide

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ferhat.horoscopeguide.MainActivity
import com.ferhat.horoscopeguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val zodiacNames = "Aries,Taurus,Gemini,Cancer,Leo,Virgo,Libra,Scorpio,Sagittarius,Capricorn,Aquarius,Pisces"
        .split(',')
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

        val zodiacAdapter = ArrayAdapter<String>(this,
                                                    android.R.layout.simple_list_item_1,
                                                    zodiacNames)
        binding.listHoroscopes.adapter = zodiacAdapter
        binding.listHoroscopes.setOnItemClickListener { parent, view, position, id ->
            var tv = view as TextView
            Toast.makeText(this@MainActivity, "Clicked on ${tv.text} at $position.position", Toast.LENGTH_LONG).show()

        }
    }
}