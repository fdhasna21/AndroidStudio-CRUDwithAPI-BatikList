package com.example.latihanapi_batik

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.InputStream

class BatikAdapter(val arrayList: ArrayList<BatikModel>, val context: Context)
    : RecyclerView.Adapter<BatikAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val layoutAdapt     = itemView.findViewById<CardView>(R.id.summarylayout_container)
        val imageAdapter    = itemView.findViewById<ImageView>(R.id.summarylayout_image)
        val nameAdapter     = itemView.findViewById<TextView>(R.id.summarylayout_name)
        val regionAdaper    = itemView.findViewById<TextView>(R.id.summarylayout_region)
        val priceAdapter    = itemView.findViewById<TextView>(R.id.summarylayout_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.summary_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = arrayList[position]
        Glide.with(holder.imageAdapter.context)
            .load(item.link_batik)
            .into(holder.imageAdapter)
        holder.nameAdapter.text  = item.nama_batik
        holder.regionAdaper.text = item.daerah_batik
        holder.priceAdapter.text = getCurrency((item.harga_tinggi + item.harga_rendah)/2)

        //TODO : holder.itemView.setOnClickListener{}
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}