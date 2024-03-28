package com.demo.kotlin_compose.Application

import android.app.Application
import me.jessyan.autosize.AutoSizeConfig

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        //配置自动适配屏幕
        AutoSizeConfig.getInstance().setCustomFragment(true)
    }

    companion object {
        //单例模式
        var instance: BaseApplication? = null
    }
}
