package com.demo.kotlin_compose.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.demo.kotlin_compose.Activity.HomeActivity
import com.demo.kotlin_compose.R


class GuideFragment : Fragment() {
    private var context: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        context = getContext()
        val arguments = arguments
        val count = arguments!!.getInt("count", 0)
        val position = arguments.getInt("position", 0)
        val imageId = arguments.getInt("imageId", 0)
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_lanunch, container, false)
        val iv_launch = view.findViewById<ImageView>(R.id.iv_lanuch)
        val rg_indicate = view.findViewById<RadioGroup>(R.id.rg_incate)
        val btn_start = view.findViewById<Button>(R.id.brn_start)
        iv_launch.setImageResource(imageId)

        //每个页面都分配一组对应的单选按钮
        for (j in 0 until count) {
            val radioButton = RadioButton(context)
            radioButton.setLayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            radioButton.setPadding(10, 10, 10, 10)
            rg_indicate.addView(radioButton)
        }

        //当前位置的单选按钮要高亮显示
        (rg_indicate.getChildAt(position) as RadioButton).setChecked(true)

        //如果是最后一个引导页则显示入口按钮
        if (position == count - 1) {
            btn_start.visibility = View.VISIBLE
            btn_start.setOnClickListener { v: View? ->
                //进入主界面
                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        fun newInstance(count: Int, position: Int, imageId: Int): GuideFragment {
            val fragment = GuideFragment()
            val args = Bundle()
            args.putInt("count", count)
            args.putInt("position", position)
            args.putInt("imageId", imageId)
            fragment.setArguments(args)
            return fragment
        }
    }
}