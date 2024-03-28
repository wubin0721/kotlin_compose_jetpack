package com.demo.kotlin_compose.Network.request;

import android.content.Context;

import com.demo.kotlin_compose.Bean.BaseHttpBean;

import java.util.WeakHashMap;

//未完成
public class SetMemberInitRequest extends BaseHttpBean {
    WeakHashMap<String, String> authInfo = new WeakHashMap<>();

    WeakHashMap<String, String> memberRegisterInfo = new WeakHashMap<>();

    WeakHashMap<String, String> deviceTokenInfo = new WeakHashMap<>();

    WeakHashMap<String, Object> params = new WeakHashMap<>();

    public SetMemberInitRequest(Context context, String registerUap) {
        authInfo.put("", "");
        authInfo.put("", "");

        this.memberRegisterInfo.put("", registerUap);
    }

    public WeakHashMap<String, Object> getAllParams() {

        params.put("", authInfo);
        params.put("", memberRegisterInfo);
//        params.put(RequestConstants.DEVICE_TOKEN_INFO, deviceTokenInfo);

        return params;
    }
}
