//package com.demo.kotlin_compose.Network.retrofit;
//
//import android.content.Context;
//
//import com.demo.kotlin_compose.Interface.RestService;
//import com.smcc.bnpl.module.common.ICallBack;
//import com.smcc.bnpl.module.net.callback.IError;
//import com.smcc.bnpl.module.net.callback.IFailure;
//import com.smcc.bnpl.module.net.callback.IRequest;
//import com.smcc.bnpl.module.net.callback.ISuccess;
//import com.smcc.bnpl.module.net.callback.ITokenTimeout;
//import com.smcc.bnpl.module.net.callback.RequestCallBack;
//import com.smcc.bnpl.module.net.callback.SkipDoFakerUrl;
//import com.smcc.bnpl.module.net.loader.APIDialog;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okio.Timeout;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//未完成
//public class RestClient {
//    private static final Map<String, Object> PARAMS = RestCreator.getParams();//1
//    private final String URL;//2
//    private final IRequest REQUEST;//3
//    private final ISuccess SUCCESS;//4
//    private final IFailure FAILURE;//5
//    private final IError ERROR;//6
//    private final RequestBody BODY;//7
//    private final Context CONTEXT;//8
//    private final File FILE;//9
//    private final String DOWNLOAD_DIR;//10
//    private final String EXTENSION;//11
//    private final String NAME;//12
//    //private LoaderStyle LOADER_STYLE;//13
//    //private LoadingDialog loadingPopup;
//    private final ICallBack RETRY;//14
//    private final Boolean DO_IN_BACKGROUND;//15
//    private final ICallBack NET_ERROR_CANCEL_CALLBACK;//16
//    private final ICallBack REQUEST_FAILURE_DIALOG_CLOSE_CALLBACK;//17
//    private ITokenTimeout TOKEN_TIMEOUT;//18
//    private boolean NEED_CLOSE_LOADING_DIALOG;//19
//    private boolean needInitLoadingDialog;//20
//    private Call<String> call = null;
//
//
//    public RestClient(
//            Map<String, Object> params,
//            String mUrl,
//            IRequest mIRequest,
//            ISuccess mISuccess,
//            IFailure mIFailure,
//            IError mIError,
//            RequestBody mRequestBody,
//            Context mContext,
//            File mFile,
//            String mDownloadDir,
//            String mExtension,
//            String mName,
//            ICallBack retry,
//            boolean doInBackground,
//            ICallBack netErrorCancelCallback,
//            ICallBack requestFailureDialogCloseCallback,
//            ITokenTimeout mITokenTimeout,
//            boolean needCloseLoadingDialog,
//            boolean needInitLoadingDialog
//
//    ) {
//        this.PARAMS.putAll(params);
//        this.URL = mUrl;
//        this.REQUEST = mIRequest;
//        this.SUCCESS = mISuccess;
//        this.FAILURE = mIFailure;
//        this.ERROR = mIError;
//        this.BODY = mRequestBody;
//        this.CONTEXT = mContext;
//        this.FILE = mFile;
//        this.DOWNLOAD_DIR = mDownloadDir;
//        this.EXTENSION = mExtension;
//        this.NAME = mName;
//        //this.loadingPopup = loadingPopup;
//        this.RETRY = retry;
//        this.DO_IN_BACKGROUND = doInBackground;
//        this.NET_ERROR_CANCEL_CALLBACK = netErrorCancelCallback;
//        this.REQUEST_FAILURE_DIALOG_CLOSE_CALLBACK = requestFailureDialogCloseCallback;
//        this.TOKEN_TIMEOUT = mITokenTimeout;
//        this.NEED_CLOSE_LOADING_DIALOG = needCloseLoadingDialog;
//
//        if (!doInBackground && this.CONTEXT != null) {
//            APIDialog.getInstance().initLoadingDialog(CONTEXT, needInitLoadingDialog);
//        }
//    }
//
//    public static RestClientBuilder builder() {
//        return new RestClientBuilder();
//    }
//
//    private void request(HttpMethod method) {
//        if (!API_V1.DO_REAL_REQUEST) {
//            // テスト用
//            if (!SkipDoFakerUrl.isSkipDoFakerUrl(URL)) {
//                doFakeRequest();
//                return;
//            }
//        }
//        if (!DO_IN_BACKGROUND && CONTEXT != null && !netUtils.checkNet(CONTEXT)) {
//            APIDialog.getInstance().initNetErrorDialog(CONTEXT,
//                    new ICallBack() {
//                        @Override
//                        public void callBack() {
//                            request(method);
//                        }
//                    },
//                    new ICallBack() {
//                        @Override
//                        public void callBack() {
//                            if (NET_ERROR_CANCEL_CALLBACK != null) {
//                                NET_ERROR_CANCEL_CALLBACK.callBack();
//                            }
//                        }
//                    });
//            APIDialog.getInstance().showNetErrorDialog();
//
//            return;
//        }
//
//        // 証明書取得
//        getLocalCertificate();
//
//        final RestService service = RestCreator.getRestService();
//        if (REQUEST != null) {
//            REQUEST.onRequestStart();
//        }
//
//        // show loading
//        APIDialog.getInstance().showLoadingDialog();
//
//        switch (method) {
//            case GET:
//                call = service.get(URL, PARAMS);
//                break;
//            case POST:
//                call = service.post(URL, PARAMS);
//                break;
//            case POST_RAW:
//                call = service.postRaw(URL, BODY);
//                break;
//            case PUT:
//                call = service.put(URL, PARAMS);
//                break;
//            case PUT_RAW:
//                call = service.putRaw(URL, BODY);
//                break;
//            case DELETE:
//                call = service.delete(URL, PARAMS);
//                break;
//            case UPLOAD:
//                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
//                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
//                call = RestCreator.getRestService().upload(URL, body);
//                break;
//            default:
//                break;
//        }
//        if (call != null) {
//            call.enqueue(getRequestCallback());
//        } else {
//            APIDialog.getInstance().closeLoadingDialog();
//        }
//    }
//
//    private void doFakeRequest() {
//        try {
//            StringBuilder sb = new StringBuilder();
//            String fileName = "json/" + JsonMap.getValueByKey(this.URL);
//            InputStream is = this.CONTEXT.getAssets().open(fileName);
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
//            String str;
//            while ((str = br.readLine()) != null) {
//                sb.append(str);
//            }
//            br.close();
//
//            Response<String> response = Response.success(sb.toString());
//            Call<String> fakeCall =new Call(){
//                @Override
//                public Response execute() throws IOException {
//                    return response;
//                }
//
//                @Override
//                public void enqueue(Callback callback) {
//
//                }
//
//                @Override
//                public boolean isExecuted() {
//                    return true;
//                }
//
//                @Override
//                public void cancel() {
//
//                }
//
//                @Override
//                public boolean isCanceled() {
//                    return false;
//                }
//
//                @Override
//                public Call clone() {
//                    return this;
//                }
//
//                @Override
//                public Request request() {
//                    return null;
//                }
//
//                @Override
//                public Timeout timeout() {
//                    return null;
//                }
//            };
//            getRequestCallback().onResponse(fakeCall,response);
////            if (this.SUCCESS != null) {
////                this.SUCCESS.onSuccess(sb.toString());
////            }
//        } catch (Exception e) {
//            if (this.ERROR != null) {
//                this.ERROR.onError(500, e.getMessage());
//            }
//        }
//
//    }
//
//    private Callback<String> getRequestCallback() {
//        return new RequestCallBack(CONTEXT,
//                URL,
//                REQUEST,
//                SUCCESS,
//                FAILURE,
//                ERROR,
//                RETRY,
//                DO_IN_BACKGROUND,
//                REQUEST_FAILURE_DIALOG_CLOSE_CALLBACK,
//                TOKEN_TIMEOUT,
//                NEED_CLOSE_LOADING_DIALOG);
//    }
//
//    /**
//     * 証明書取得
//     *
//     * @return
//     */
//    private void getLocalCertificate() {
//        try {
//            LocalCertificate.mTrustCertificate = CONTEXT.getAssets().open("mycer.cer");
//        } catch (IOException e) {
//            //throw new AssertionError(e);
//        }
//    }
//
//    public final void get() {
//        request(HttpMethod.GET);
//    }
//
//    public final void post() {
//        if (BODY == null) {
//            request(HttpMethod.POST);
//        } else {
//            if (!PARAMS.isEmpty()) {
//                throw new RuntimeException("params must be null");
//            }
//            request(HttpMethod.POST_RAW);
//        }
//    }
//
//    public final void put() {
//        if (BODY == null) {
//            request(HttpMethod.PUT);
//        } else {
//            if (!PARAMS.isEmpty()) {
//                throw new RuntimeException("params must be null");
//            }
//            request(HttpMethod.PUT_RAW);
//        }
//    }
//
//    public final void delete() {
//        request(HttpMethod.DELETE);
//    }
//
//    public final void download() {
//        // todo
//    }
//
//    public final void upload() {
//        request(HttpMethod.UPLOAD);
//    }
//
//    public final void cancelHttp() {
//        if (call != null) {
//            call.cancel();
//        }
//    }
//}
