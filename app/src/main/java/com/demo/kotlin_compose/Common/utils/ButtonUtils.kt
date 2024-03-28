package com.demo.kotlin_compose.Common.utils

/*
 * 解决按钮连续点击问题
 */
object ButtonUtils {
    private var lastClickTime: Long = 0
    val isFastDoubleClick: Boolean
        get() {
            val time = System.currentTimeMillis()
            if (time - lastClickTime < 2000) {
                return true
            }
            lastClickTime = time
            return false
        }

}
