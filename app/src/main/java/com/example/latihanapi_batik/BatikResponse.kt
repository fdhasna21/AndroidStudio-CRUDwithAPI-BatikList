package com.example.latihanapi_batik

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class BatikResponse(
    @SerializedName("hasil")
    val data: ArrayList<BatikModel>
) {
    @Parcelize
    data class BatikModel(
        @SerializedName("id")
        val id: Int,
        @SerializedName("nama_batik")
        val nama_batik: String,
        @SerializedName("daerah_batik")
        val daerah_batik: String,
        @SerializedName("makna_batik")
        val makna_batik: String,
        @SerializedName("harga_rendah")
        val harga_rendah: Int,
        @SerializedName("harga_tinggi")
        val harga_tinggi: Int,
        @SerializedName("hitung_view")
        val hitung_view: Int,
        @SerializedName("link_batik")
        val link_batik: String
    ) : Parcelable
}