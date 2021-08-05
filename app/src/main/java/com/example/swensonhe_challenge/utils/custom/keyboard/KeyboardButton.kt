package com.example.swensonhe_challenge.utils.custom.keyboard

import android.graphics.drawable.Drawable

data class KeyboardButton(
    val text: String? = "",
    val icon: Drawable? = null,
    val action: KeyboardAction? = null
) {
    enum class KeyboardAction {
        DELETE,
        ANYTHING_ELSE  // to add any other actions
    }
}