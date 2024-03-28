package com.demo.kotlin_compose.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.demo.kotlin_compose.Adapter.GuideAdapter
import com.demo.kotlin_compose.R


class GuideActivity : AppCompatActivity() {
    private var viewPager: ViewPager2? = null

    //声明引导页面的图片数组
    private val lanuchArray = intArrayOf(
        R.drawable.guide_a,
        R.drawable.guide_b,
        R.drawable.guide_c,
        R.drawable.guide_d
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        viewPager = findViewById(R.id.view_pager)
        val guideAdapter = GuideAdapter(
            supportFragmentManager,
            lifecycle,
            lanuchArray
        )
        viewPager?.run {
            setAdapter(guideAdapter)
        }


    }
}