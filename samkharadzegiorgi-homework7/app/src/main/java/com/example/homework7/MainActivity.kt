package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.homework7.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ItemRecyclerViewAdapter
    private var information = ArrayList<ItemModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMain
        init()

    }

    class ActivityMain {

    }


    private fun init() {
        setInfo()
    }

    private fun setInfo() {
        DataLoader.getRequest(
            "5edb4d643200002a005d26f0", object : CustomCallback {
                override fun onSuccess(response: String) {
                    val data = Gson().fromJson(response, Array<ItemModel>::class.java).toList()

                    information.addAll(data)

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = ItemRecyclerViewAdapter(information)
                    recyclerView.adapter = adapter
                }

                override fun onFailed(errorMessage: String) {
                    Log.d("errorrr", errorMessage)
                }
            }

    }
}