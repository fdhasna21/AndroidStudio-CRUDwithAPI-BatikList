package com.example.latihanapi_batik

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_show_batik.*

class ShowBatik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_batik)

        val intent = intent
        val batikName = intent.getStringExtra("nama_batik")
        detaillayout_name.text = batikName
        detaillayout_region.text = intent.getStringExtra("daerah_batik")
        detaillayout_desc.text = intent.getStringExtra("makna_batik")
        detaillayout_maxprice.text = getCurrency(intent.getIntExtra("harga_tinggi", 0))
        detaillayout_minprice.text = getCurrency(intent.getIntExtra("harga_rendah", 0))

        Glide.with(detaillayout_image.context)
            .load(intent.getStringExtra("link_batik"))
            .into(detaillayout_image)

        supportActionBar!!.setTitle("Batik "+batikName)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}