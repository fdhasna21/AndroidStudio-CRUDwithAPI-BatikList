package com.example.latihanapi_batik

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
//    @GET("/index.php/batik/all")
//    fun getData():Call<ArrayList<BatikModel>>

    @GET("/index.php/batik/all")
    fun getData():Call<ArrayList<BatikModel>>
}