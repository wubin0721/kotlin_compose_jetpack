//package com.demo.kotlin_compose.Activity;
//
//import android.app.Activity;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.webkit.WebChromeClient;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.ProgressBar;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.demo.kotlin_compose.R;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
////个人页面
//
//
//public class AboutActivity extends Activity implements OnClickListener {
//	private RelativeLayout btn_back;
//	private WebView webView;
//	private TextView tv_title;
//	private ProgressBar pb;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		//6.0以下的一律改成透明的
//		if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
//			StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.transparent));
//		}else{
//			StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.white));
//			StatusBarUtil.StatusBarLightMode(this);//设置状态栏白底黑子m
//		}
//		setContentView(R.layout.install_about);
//		init();
//		about();
//	}
//
//	private void init() {
//		btn_back = (RelativeLayout) findViewById(R.id.btn_back);
//		btn_back.setOnClickListener(this);
//		webView = (WebView) findViewById(R.id.my_web);
//		tv_title= (TextView) findViewById(R.id.tv_title);
//		pb= (ProgressBar) findViewById(R.id.progressBar1);
//
//		WebSettings settings = webView.getSettings();
//		//能使用JavaScript
//		settings.setJavaScriptEnabled(true);
////		webView.setWebChromeClient(webChromeClient);
//	}
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.btn_back:
//			if(webView.canGoBack()){
//				webView.goBack();
//			}else{
//				finish();
//			}
//
//			break;
//		}
//	}
//
//	private void about() {
//		Buffer_CircleDialog.show(this, "加载中..", false, null);
//		AsyncHttp.postNewTask(Config.ABOUT, null, new MICallBack() {
//			@Override
//			public void onResult(String result) {
//				Buffer_CircleDialog.dialogcancel();
//				try {
//					JSONObject response = new JSONObject(result);
//					String status = response.getString("status");
//					String msg = response.getString("msg");
//					String data = response.getString("data");
//					if (status.equals("0")) {
//						JSONArray jsonArray = new JSONArray(data);
//						JSONObject jsonObject = jsonArray
//								.getJSONObject(0);
//						String content = jsonObject
//								.getString("content");
//						String title=jsonObject.optString("title");
//						tv_title.setText(title);
//
//						webView.loadDataWithBaseURL(null,content, "text/html", "utf-8", null);
//					} else {
//						toast(msg);
//					}
//				} catch (Exception e) {
//					toast("获取数据失败！");
//				}
//			}
//
//			@Override
//			public void onError(String errString) {
//				Buffer_CircleDialog.dialogcancel();
//
//			}
//		});
//
//	}
//
//	private void toast(String info) {
//		ToastUtils.ToastShowShort(this, info);
//	}
//
//
//	WebChromeClient webChromeClient=new WebChromeClient(){
//		@Override
//		public void onReceivedTitle(WebView view, String title) {
//			super.onReceivedTitle(view, title);
//			if(!title.equals("")){
//				tv_title.setText(title);
//			}else{
//				tv_title.setText("活动详情");
//			}
//		}
//
//		//进度条
//		@Override
//		public void onProgressChanged(WebView view, int newProgress) {
//			super.onProgressChanged(view, newProgress);
//			if(newProgress==100){
//				pb.setVisibility(View.GONE);//加载完网页进度条消失
//			}
//			else{
//				pb.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
//				pb.setProgress(newProgress);//设置进度值
//			}
//		}
//	};
//
//
//
//	@Override
//	public void onBackPressed() {
//		if(webView.canGoBack()){
//			webView.goBack();
//		}else{
//			finish();
//		}
//		super.onBackPressed();
//	}
//}
