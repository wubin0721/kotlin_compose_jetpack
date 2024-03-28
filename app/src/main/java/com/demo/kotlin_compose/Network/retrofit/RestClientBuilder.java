//package com.demo.kotlin_compose.Network.retrofit;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.smcc.bnpl.module.common.ICallBack;
//import com.smcc.bnpl.module.net.callback.IError;
//import com.smcc.bnpl.module.net.callback.IFailure;
//import com.smcc.bnpl.module.net.callback.IRequest;
//import com.smcc.bnpl.module.net.callback.ISuccess;
//import com.smcc.bnpl.module.net.callback.ITokenTimeout;
//import com.smcc.bnpl.module.net.request.RequestConstants;
//import com.smcc.bnpl.module.util.CacheUtils;
//
//import java.io.File;
//import java.util.Map;
//import java.util.WeakHashMap;
//
//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//未完成
//public class RestClientBuilder {
//    private static final Map<String, Object> PARAMS = RestCreator.getParams();//1
//    private String mUrl = null;//2
//    private IRequest mIRequest = null;//3
//    private ISuccess mISuccess = null;//4
//    private IFailure mIFailure = null;//5
//    private IError mIError = null;//6
//    private RequestBody mRequestBody = null;//7
//    private Context mContext = null;//8
//    private File mFile = null;//9
//    private String mDownloadDir = null;//10
//    private String mExtension = null;//11
//    private String mName = null;//12
//    private ICallBack reTry = null;//14
//    private Boolean doInBackground = false;//15
//    private ICallBack netErrorCancelCallback = null;//16
//    private ICallBack requestFailureDialogCloseCallback = null;//17
//    private ITokenTimeout mITokenTimeout = null;//18
//    private boolean needCloseLoadingDialog = true;//19
//    private boolean needInitLoadingDialog = true;//20
//
//    public RestClientBuilder() {
//
//    }
//
//    /*********************** 1 params ******************************/
//    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
//        PARAMS.putAll(params);
//        return this;
//    }
//
//    public final RestClientBuilder paramsWithAuth(Context context, WeakHashMap<String, Object> params) {
//
//        WeakHashMap authInfo = new WeakHashMap();
//        authInfo.put(RequestConstants.CONNECT_AUTH_ID, RequestConstants.CONNECT_AUTH_ID_VALUE);
//        authInfo.put(RequestConstants.BNPL_TOKEN, CacheUtils.getString(context, RequestConstants.BNPL_TOKEN));
//        authInfo.put(RequestConstants.AUTH_CODE, CacheUtils.getString(context, RequestConstants.AUTH_CODE));
//        authInfo.put(RequestConstants.MOBILE, CacheUtils.getString(context, RequestConstants.MOBILE));
//        authInfo.put(RequestConstants.EMAIL, CacheUtils.getString(context, RequestConstants.EMAIL));
//        authInfo.put(RequestConstants.PASSWORD, CacheUtils.getString(context, RequestConstants.PASSWORD));
//
//
//        params.put(RequestConstants.AUTH_INFO, authInfo);
//
//        PARAMS.putAll(params);
//        return this;
//    }
//
//    public final RestClientBuilder params(String key, Object value) {
//        PARAMS.put(key, value);
//        return this;
//    }
//
//    /*********************** 2 mUrl ******************************/
//    public final RestClientBuilder url(String url) {
//        Log.i("API_RESULT", "URL : " + url);
//        this.mUrl = url;
//        return this;
//    }
//
//    /*********************** 3 mIRequest ******************************/
//    public final RestClientBuilder onRequest(IRequest request) {
//        this.mIRequest = request;
//        return this;
//    }
//
//    /*********************** 4 mISuccess ******************************/
//    public final RestClientBuilder success(ISuccess success) {
//        this.mISuccess = success;
//        return this;
//    }
//
//    /*********************** 5 IFailure ******************************/
//    public final RestClientBuilder failure(IFailure failure) {
//        this.mIFailure = failure;
//        return this;
//    }
//
//    /*********************** 6 mIError ******************************/
//    public final RestClientBuilder error(IError error) {
//        this.mIError = error;
//        return this;
//    }
//
//    /*********************** 7 RequestBody ******************************/
//    public final RestClientBuilder body(String raw) {
//        Log.e("API_RESULT", "request params : " + raw);
//        this.mRequestBody = RequestBody.create(raw, MediaType.parse("application/json;charset=UTF-8"));
//        return this;
//    }
//
//    public final RestClientBuilder body(Map<String, Object> body) {
//        Gson gson = new Gson();
//        Log.e("API_RESULT", "request params : " + gson.toJson(body));
//        this.mRequestBody = RequestBody.create(gson.toJson(body), MediaType.parse("application/json;charset=UTF-8"));
//        return this;
//    }
//
//    /*********************** 8 mContext ******************************/
//    public final RestClientBuilder onContext(Context context) {
//        this.mContext = context;
//        return this;
//    }
//
//    /*********************** 9 mFile ******************************/
//    public final RestClientBuilder onFile(File file) {
//        this.mFile = file;
//        return this;
//    }
//
//    public final RestClientBuilder onFile(String file) {
//        this.mFile = new File(file);
//        return this;
//    }
//
//    /*********************** 10 mDownloadDir ******************************/
//    public final RestClientBuilder downloadDir(String downloadDir) {
//        this.mDownloadDir = downloadDir;
//        return this;
//    }
//
//    /*********************** 11 mExtension ******************************/
//    public final RestClientBuilder extension(String extension) {
//        this.mExtension = extension;
//        return this;
//    }
//
//    /*********************** 12 mName ******************************/
//    public final RestClientBuilder fileName(String name) {
//        this.mName = name;
//        return this;
//    }
//
//    /*********************** 13 mLoaderStyle ******************************/
//
//
//    /*********************** 14 retry ******************************/
//    public final RestClientBuilder reTry(ICallBack reTry) {
//        this.reTry = reTry;
//        return this;
//    }
//
//    /*********************** 15 retry ******************************/
//    public final RestClientBuilder doInBackground(boolean doInBackground) {
//        this.doInBackground = doInBackground;
//        return this;
//    }
//
//    /*********************** 16 netErrorCancelCallback ******************************/
//
//    public RestClientBuilder netErrorCancelCallback(ICallBack netErrorCancelCallback) {
//        this.netErrorCancelCallback = netErrorCancelCallback;
//        return this;
//    }
//
//    /*********************** 17 requestFailureDialogCloseCallback ******************************/
//    public RestClientBuilder requestFailureDialogCloseCallback(ICallBack requestFailureDialogCloseCallback) {
//        this.requestFailureDialogCloseCallback = requestFailureDialogCloseCallback;
//        return this;
//    }
//
//    /*********************** 18 ITokenTimeout ******************************/
//    public RestClientBuilder tokenTimeout(ITokenTimeout iTokenTimeout) {
//        this.mITokenTimeout = iTokenTimeout;
//        return this;
//    }
//
//    /*********************** 19 needCloseLoadingDialog ******************************/
//    public RestClientBuilder needCloseLoadingDialog(boolean needCloseLoadingDialog) {
//        this.needCloseLoadingDialog = needCloseLoadingDialog;
//        return this;
//    }
//
//    /*********************** 20 needInitLoadingDialog ******************************/
//    public RestClientBuilder needInitLoadingDialog(boolean needInitLoadingDialog) {
//        this.needInitLoadingDialog = needInitLoadingDialog;
//        return this;
//    }
//
//
//    public final RestClient build() {
//        return new RestClient(PARAMS,
//                mUrl,
//                mIRequest,
//                mISuccess,
//                mIFailure,
//                mIError,
//                mRequestBody,
//                mContext,
//                mFile,
//                mDownloadDir,
//                mExtension,
//                mName,
//                reTry,
//                doInBackground,
//                netErrorCancelCallback,
//                requestFailureDialogCloseCallback,
//                mITokenTimeout,
//                needCloseLoadingDialog,
//                needInitLoadingDialog);
//    }
//
//}
