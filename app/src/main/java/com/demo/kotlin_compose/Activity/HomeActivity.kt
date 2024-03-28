package com.demo.kotlin_compose.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.kotlin_compose.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //修改存储的boolean
        val sp = getSharedPreferences("FirstLaunch", MODE_PRIVATE)
        sp.edit().putBoolean("FirstValue", false).commit()
    }
}