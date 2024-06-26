package com.demo.kotlin_compose.Application

import android.app.Application
import androidx.work.Configuration
import me.jessyan.autosize.AutoSizeConfig


open class BaseApplication : Application() , Configuration.Provider{

    companion object {
        //单例模式
        var instance: BaseApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this



        //配置自动适配屏幕
        AutoSizeConfig.getInstance().setCustomFragment(true)
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .build()
}
