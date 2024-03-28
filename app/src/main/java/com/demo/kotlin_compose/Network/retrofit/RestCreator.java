package com.demo.kotlin_compose.Network.retrofit;

import android.text.TextUtils;

import com.demo.kotlin_compose.Common.Constans;
import com.demo.kotlin_compose.Interface.RestService;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestCreator {

    // パラメーター
    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    // サービス
    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }


    // Retrofit
    public static Retrofit getRetrofit() {
        return RetrofitHolder.RETROFIT_CLIENT;
    }

    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    /**
     * Retrofit作成
     */
    private static final class RetrofitHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * OkHttpClient作成
     */
    private static final class OKHttpHolder {
        private static final int TIME_OUT = 15;
        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();

        private static final OkHttpClient OK_HTTP_CLIENT = BUILDER.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .sslSocketFactory(SSLManager.getSSLSocketFactory(), SSLManager.getX509TrustManagerWithNoCheck())
                .hostnameVerifier(new HostnameVerifier() {
                    final String[] passSSLList = {};

                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        if (TextUtils.isEmpty(hostname)) {
                            return false;
                        }
                        return !Arrays.asList(passSSLList).contains(hostname);
                    }
                })
                .addInterceptor(new HeaderInterceptor())
                //.addNetworkInterceptor(new ErrorInterceptor())
                //.certificatePinner(new CertificatePinner.Builder()
                //        .add("member-api.dev.atokara.jp", "sha256/S8Ff3JCaO4V...")
                //        .build())
                .build();


    }

    /**
     * OkHttpClient作成
     */
    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

}
