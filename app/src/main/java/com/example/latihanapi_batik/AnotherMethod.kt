package com.example.latihanapi_batik

import java.text.NumberFormat
import java.util.*

fun getCurrency(price:Int):String{
    return NumberFormat.getCurrencyInstance(Locale("in", "id")).format(price)
}