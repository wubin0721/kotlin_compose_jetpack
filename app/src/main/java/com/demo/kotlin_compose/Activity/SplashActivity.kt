package com.demo.kotlin_compose.Activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.demo.kotlin_compose.R
import com.demo.kotlin_compose.View.SplashView
import java.util.Random


class SplashActivity : Activity(), View.OnClickListener {

    companion object {
        private const val SPLASH_AD_TIME = 4000 //广告展示时间
        private const val GO_LOGIN = 1000        //
        private const val GO_GUIDE = 1001       //引导页
    }

    //是否第一次进入
    var isFirstIn = false
    //自定义控件SplashView
    private var adimg: SplashView? = null
    //计数器
    private var timeCount: TimeCount? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        adimg = findViewById<View>(R.id.img_guide) as SplashView
        adimg!!.setOnClickListener(this)
        adimg!!.linearLayout?.setOnClickListener(this)

        //全屏显示
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        init()
    }

    private fun init() {
        val sp = getSharedPreferences("FirstLaunch", MODE_PRIVATE)
        //第一次获取不到值，取默认值true
        isFirstIn = sp.getBoolean("FirstValue", true)
        if (isFirstIn) {
            mHandler!!.sendEmptyMessage(GO_GUIDE)
        } else {
            mHandler!!.sendEmptyMessage(GO_LOGIN)
        }
    }


    private fun goLogin() {
            //初始化定时器
        timeCount = TimeCount(SPLASH_AD_TIME.toLong(), 1000)
        adimg!!.visibility = View.VISIBLE
        //图片加载
        adimg!!.imageView?.let {
            Glide.with(this)
                .load(R.drawable.guide_a)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(it)
        }
            //5000后去登录
            timeCount!!.start()
    }

    //计数器
    internal inner class TimeCount(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        // 计时完毕时触发,进行自动登录
        override fun onFinish() {
            adimg!!.linearLayout?.visibility = View.GONE

            val intent = Intent(this@SplashActivity,
                HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        //计时过程显示
        override fun onTick(millisUntilFinished: Long) {
            adimg!!.textView?.text = (millisUntilFinished / 1000).toString() + ""
        }
    }

    override fun onClick(v: View) {
        var intent = Intent()
        when (v.id) {
            //关掉定时器
            R.id.img_guide -> {
                timeCount!!.cancel()

                intent.setClass(this@SplashActivity,
                    HomeActivity::class.java)
                startActivity(intent)
            }

            //关掉定时器
            R.id.ll_finish -> {
                if (timeCount != null) {
                    timeCount!!.cancel()
                }

                val intent = Intent(this@SplashActivity,
                    HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun goGuide() {
        //跳转到GuideActivity
        val intent = Intent(this@SplashActivity, GuideActivity::class.java)
        this@SplashActivity.startActivity(intent)
        finish()
    }

    private var mHandler: Handler? = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                GO_LOGIN ->                     //显示广告图片，加载广告数据
                    goLogin()
                GO_GUIDE ->                     //引导页
                    goGuide()
            }
            super.handleMessage(msg)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mHandler != null) {
            mHandler!!.removeCallbacksAndMessages(null)
            mHandler = null
        }
    }
}
