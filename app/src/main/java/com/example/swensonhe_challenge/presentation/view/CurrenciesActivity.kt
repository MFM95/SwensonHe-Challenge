package com.example.swensonhe_challenge.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.swensonhe_challenge.R
import com.example.swensonhe_challenge.core.DaggerFragmentActivity
import com.example.swensonhe_challenge.core.ViewModelFactory
import com.example.swensonhe_challenge.presentation.viewmodel.CurrencyViewModel
import com.example.swensonhe_challenge.utils.addFragment
import dagger.android.AndroidInjection
import javax.inject.Inject

class CurrenciesActivity : DaggerFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_converter)
        showCurrenciesFragment()
    }

    private fun showCurrenciesFragment() {
        addFragment(CurrenciesFragment.newInstance(), R.id.flFragmentContainer)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, CurrenciesActivity::class.java)
            val extras: Bundle = Bundle().apply {}
            intent.apply { putExtras(extras) }
            return intent
        }
    }

}