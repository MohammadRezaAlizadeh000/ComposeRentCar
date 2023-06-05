package com.mra.rentcar.utils

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment

@Composable
fun Toast(@StringRes message: Int) {
    LocalContext.current.let {
        Toast.makeText(it, stringResource(message), Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun Toast(message: String) {
    LocalContext.current.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}