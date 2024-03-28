package com.demo.kotlin_compose.Common.base;

import androidx.fragment.app.FragmentActivity;
import me.jessyan.autosize.internal.CustomAdapt;

public class BaseActivity extends FragmentActivity implements CustomAdapt {

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 667;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}



