package com.example.unittestingsample

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SecondaryActivity : AppCompatActivity() {
    private lateinit var chooseText: TextView
    private lateinit var english: Button
    private lateinit var hindi: Button
    private lateinit var french: Button
    private lateinit var german: Button
    private lateinit var russian: Button
    private var myLocale: Locale? = null


    //Shared Preferences Variables
    private val localPreferences = "Locale Preference"
    private val localKeyValue = "Saved Locale"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)
        initView();

        english = findViewById(R.id.english)
        hindi = findViewById(R.id.hindi)
        french = findViewById(R.id.french)
        german = findViewById(R.id.german)
        russian = findViewById(R.id.russian)
        chooseText = findViewById(R.id.choose_text)

        english.setOnClickListener {
            val lang = "en"
            changeLocale(lang)
        }

        hindi.setOnClickListener {
            var lang = "hi"
            changeLocale(lang)
        }
        french.setOnClickListener {
            var lang = "fr"
            changeLocale(lang)
        }
        german.setOnClickListener {
            var lang = "de"
            changeLocale(lang)
        }
        russian.setOnClickListener {
            var lang = "ru"
            changeLocale(lang)
        }

    }

    private fun changeLocale(lang: String) {
        if (lang == "") return
        myLocale = Locale(lang)
        saveLocale(lang)
        Locale.setDefault(myLocale)
        val config = Configuration()
        config.locale = myLocale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        updateTexts()
    }

    private fun updateTexts() {
        english.text = resources.getString(R.string.btn_en)
        hindi.text = resources.getString(R.string.btn_hi)
        french.text = resources.getString(R.string.btn_fr)
        german.text = resources.getString(R.string.btn_de)
        russian.text = resources.getString(R.string.btn_ru)
        chooseText.text = resources.getString(R.string.tap_text)
    }


    private fun saveLocale(lang: String?) {
        editor.putString(localKeyValue, lang)
        editor.commit()
    }


    private fun initView() {
        sharedPreferences = getSharedPreferences(localPreferences, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }


}
