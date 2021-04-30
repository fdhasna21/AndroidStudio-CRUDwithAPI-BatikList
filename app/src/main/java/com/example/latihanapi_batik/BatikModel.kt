package com.example.latihanapi_batik

data class BatikModel(
    val id : Int,
    val nama_batik : String,
    val daerah_batik : String,
    val makna_batik : String,
    val harga_rendah : Int,
    val harga_tinggi : Int,
    val link_batik : String
)