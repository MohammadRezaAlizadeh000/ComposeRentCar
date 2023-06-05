package com.mra.rentcarcompose.utils

import android.os.Parcelable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.google.gson.Gson
import com.mra.rentcar.model.CarModel
import com.mra.rentcarcompose.navigation.CAR_DATA_ARGUMENT_KEY

fun <T> NavController.navigate(route: String, vararg args:  T) {
    var finalRoute = route.substringBefore("/")
    args.forEach {
        val result = Gson().toJson(it).replace("/", "~")
        finalRoute = finalRoute.plus("/$result")
    }
    navigate(finalRoute)
}

inline fun <reified T : Parcelable> NavBackStackEntry.requiredArg(key: String): T
    = Gson().fromJson(arguments?.getString(key)?.replace("~", "/"), T::class.java)