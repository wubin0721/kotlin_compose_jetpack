package com.demo.kotlin_compose.Compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.kotlin_compose.R




@Composable
public fun LoginScreen(
    onLoginClick: () -> Unit
) {
    Scaffold(
//            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
//                HomeTopAppBar(
//                    pagerState = pagerState,
//                    onFilterClick = { viewModel.updateData() },
//                    scrollBehavior = scrollBehavior
//                )
        }
    ) { innerPadding->
        SumView(onLoginClick)
        Modifier.padding(innerPadding)
    }
}


@Composable
private fun SumView(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally   //布局内子控件水平居中
    ) {                              //从上到下排列布局
        ImageArea(R.drawable.col, "")
        InputArea("", "",onLoginClick)
    }
}


/*
图片区域
 */
@Composable
fun ImageArea(@DrawableRes ImageId:Int,         //图片资源
              title:String,
) {
    Row(
        modifier = Modifier
            .padding(vertical = 60.dp),                     //对于父布局向下偏移
        horizontalArrangement = Arrangement.Center          //布局内控件对齐方式为居中
//     ,verticalAlignment = Alignment.CenterVertically  // 垂直居中
    ){
        Modifier.fillMaxWidth()                             //宽度父布局
        Image(
            painterResource(ImageId) , title,
            modifier = Modifier
                .wrapContentSize()     //根据自身内容调整大小
                .weight(1f)
//                    .border(5.dp, Color.Magenta, CircleShape)//边框
//                    .clip(CircleShape)                       //圆角
        )
    }
}


/*
输入区域
 */
@Composable
fun InputArea(
    psw:String="",
    phone:String="",
    onLoginClick: () -> Unit,
){
    Column(
        modifier = Modifier
            .width(294.dp)
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                placeholder = {
                     Text(text = "请输入电话")
                },
                value = "",
                onValueChange = {

                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            TextField(
                placeholder = {
                    Text(text = "请输入密码")
                },
                value = "",
                onValueChange = {

                },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //引用原来的 R.color的资源文件
            val txt_orange = colorResource(id = R.color.txt_orange)
            //获取当前context
            val context = LocalContext.current
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .wrapContentSize(),
                shape = RoundedCornerShape(0.dp),       //设置按钮圆角
                colors = ButtonDefaults.buttonColors(txt_orange),
                onClick = onLoginClick,
                enabled = true,

                ) {
                Text(text = stringResource(         //引用字体资源，设置字体大小
                    id = R.string.login),fontSize =18.sp)
            }
        }
    }
}

