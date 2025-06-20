package com.ferhat.horoscopeguide

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ferhat.horoscopeguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var allSigns: ArrayList<Sign>
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


        loadZodiacData()

        var zodiacAdapter = ZodiacBaseAdapter(this, allSigns)
        binding.listHoroscopes.adapter = zodiacAdapter

    }

    private fun loadZodiacData() {
        allSigns = ArrayList<Sign>(12)

        var signNames = resources.getStringArray(R.array.zodiac_sign_names)
        var signDates = resources.getStringArray(R.array.zodiac_birth_dates)
        var signGroup = resources.getStringArray(R.array.zodiac_sign_groups)
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
        var signBanners = arrayOf(
            R.drawable.banner_aries,
            R.drawable.banner_taurus,
            R.drawable.banner_gemini,
            R.drawable.banner_cancer,
            R.drawable.banner_leo,
            R.drawable.banner_virgo,
            R.drawable.banner_libra,
            R.drawable.banner_scorpio,
            R.drawable.banner_sagittarius,
            R.drawable.banner_capricorn,
            R.drawable.banner_aquarius,
            R.drawable.banner_pisces
        )
        var signDescription = resources.getStringArray(R.array.zodiac_characteristics)

        for (i in 0..11)
            allSigns.add(
                Sign(
                    signIcons[i],
                    signNames[i],
                    signDates[i],
                    signGroup[i],
                    signBanners[i],
                    signDescription[i]
                )
            )
    }
}