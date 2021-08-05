package com.example.swensonhe_challenge.presentation.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.swensonhe_challenge.R
import com.example.swensonhe_challenge.presentation.uimodel.CurrencyUIModel
import com.example.swensonhe_challenge.utils.custom.keyboard.KeyboardButton
import com.example.swensonhe_challenge.utils.custom.keyboard.KeyboardListener
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_calculator.*


class CalculatorFragment : Fragment(), KeyboardListener {


    private var baseCurrency: String? = ""
    private var selectedCurrency: CurrencyUIModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun getData() {
        arguments?.let {
            baseCurrency = it.getString(ARG_BASE_CUR) ?: ""
            selectedCurrency = it.getParcelable(ARG_SELECTED_CUR)
        }
    }

    private fun init() {
        lyCustomKeyboard.setListener(this)
        tvBaseCurrency.text = baseCurrency
        tvSelectedCurrency.text = selectedCurrency?.currency
        tvSelectedRate.text = String.format("%.2f", selectedCurrency?.rate)
        etBaseRate.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                calculate(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

    }


    private fun calculate(baseRate: String) {
        try {
            if (baseRate.isEmpty()) {
                tvSelectedRate.text = "0.0"
                return
            }
            baseRate.toDouble().let {
                selectedCurrency?.rate?.let { rate ->
                    val value = it * rate
                    tvSelectedRate.text = String.format("%.2f", value)
                }
            }
        } catch (e: Exception) {
        }
    }

    override fun onKeyboardClickListener(item: KeyboardButton) {
        val text = StringBuilder(etBaseRate.text.toString())
        if (item.icon != null) {
            when(item.action) {
                KeyboardButton.KeyboardAction.DELETE -> {
                    if (text.isNotEmpty())
                        text.deleteAt(text.length - 1)
                }
                else -> {}
            }
        } else {
            if (text.length <= 12) {
                when (item.text) {
                    "." -> if (!text.contains(".")) text.append(item.text)
                    else -> text.append(item.text)
                }
            }
        }
        etBaseRate.text = text
    }


    companion object {
        private const val ARG_BASE_CUR = "arg_base_currency"
        private const val ARG_SELECTED_CUR = "arg_selected`_currency"

        @JvmStatic
        fun newInstance(selectedCurrency: CurrencyUIModel, baseCurrency: String) =
            CalculatorFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_SELECTED_CUR, selectedCurrency)
                    putString(ARG_BASE_CUR, baseCurrency)
                }
            }
    }


}