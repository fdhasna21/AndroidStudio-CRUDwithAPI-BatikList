package com.example.latihanapi_batik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private fun showRecords(){
        batik_recycler.layoutManager = GridLayoutManager(this@MainActivity,2)
        val apiInterface : ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getData().enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>?, response: Response<BatikResponse>?) {
                val outputArray = response?.body()!!
                if(outputArray.data.size > 0){
                    txt_noRecords.visibility = View.GONE
                    batik_recycler.visibility = View.VISIBLE
                    batik_recycler.adapter = BatikAdapter(outputArray.data, this@MainActivity)
                }
                else{
                    txt_noRecords.visibility = View.VISIBLE
                    batik_recycler.visibility = View.GONE
                }
                Toast.makeText(this@MainActivity, "Refresh", Toast.LENGTH_SHORT).show()
                Log.d("showRecord onResponse", response.toString())
            }

            override fun onFailure(call: Call<BatikResponse>?, t: Throwable) {
                Toast.makeText(this@MainActivity, "Data downloading is failed.", Toast.LENGTH_SHORT).show()
                Log.d("showRecord onFailure", t.message.toString())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setTitle("Batik Indonesia")

        showRecords()
    }
}