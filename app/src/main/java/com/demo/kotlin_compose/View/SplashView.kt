package com.demo.kotlin_compose.View

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.demo.kotlin_compose.Activity.SplashActivity
import com.demo.kotlin_compose.R


/**
 * Created by chc on 2024/3/26.
 * 用于启动页倒计时
 */
class SplashView : FrameLayout {
    //获取imgview控件
    var imageView: ImageView? = null
    private var tv_finish: TextView? = null
    //获取倒计时文本
    var textView: TextView? = null
    //获取线性布局
    var linearLayout: LinearLayout? = null
    private var mContext: Context
    private var activity: SplashActivity? = null

    constructor(context: Context) : super(context) {
        mContext = context
        activity = context as SplashActivity
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        mContext = context
        initView()
    }

    private fun initView() {
        val view = inflate(context, R.layout.view_splash, this)
        imageView = view.findViewById<View>(R.id.img_view) as ImageView
        tv_finish = view.findViewById<View>(R.id.tv_finish) as TextView
        textView = view.findViewById<View>(R.id.tv_count_time) as TextView
        linearLayout = view.findViewById<View>(R.id.ll_finish) as LinearLayout
    }
}
