package com.demo.kotlin_compose.Application

import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk

class WebViewApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        // X5WebView初始化
        initX5WebView()
    }

    private fun initX5WebView() {
        // 搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb: QbSdk.PreInitCallback = object : QbSdk.PreInitCallback {
            override fun onViewInitFinished(arg0: Boolean) {

            }

            override fun onCoreInitFinished() {}
        }
        // x5内核初始化接口
        QbSdk.initX5Environment(this, cb)

        // 在调用TBS初始化、创建WebView之前进行如下配置
        val map: HashMap<String, Any?> = HashMap()
        true.also { map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = it }
        true.also { map[TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE] = it }
        QbSdk.initTbsSettings(map)
    }
}
