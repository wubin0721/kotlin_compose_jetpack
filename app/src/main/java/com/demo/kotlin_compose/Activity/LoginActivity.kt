package com.demo.kotlin_compose.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Surface
import android.view.View
import android.widget.EditText
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.demo.kotlin_compose.Common.base.BaseActivity
import com.demo.kotlin_compose.R
import com.demo.kotlin_compose.ui.theme.Kotlin_composeTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.kotlin_compose.Compose.ComposeDemoApp
import com.demo.kotlin_compose.Compose.ImageArea
import com.demo.kotlin_compose.Compose.InputArea

/*
compose与view混合开发，布局可选
View:activity_login.xml
Compose:LoginScreen
 */
class LoginActivity : BaseActivity() {
    private var mEditPwd: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)        //xml布局
//        mEditPwd = findViewById(R.id.edit_pwd)

        setContent {
            Kotlin_composeTheme {                //默认主题
                ComposeDemoApp()                //路由切换不同页面
            }
        }
    }



//    fun goToHome(value: View) {
//        val pwd = mEditPwd!!.getText().toString()
//        if (pwd == "123") {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//        val intent = Intent(this, HomeActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}


