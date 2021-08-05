package com.example.swensonhe_challenge.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.swensonhe_challenge.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btnHomeFixerConverter.setOnClickListener { startActivity(
            CurrenciesActivity.getIntent(this)
        ) }
    }


}