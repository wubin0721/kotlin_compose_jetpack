//package com.demo.kotlin_compose.Dialog;
//
//import static android.os.Build.VERSION_CODES.R;
//
//import android.content.Context;
//import android.view.View;
//import android.widget.Button;
//import androidx.annotation.NonNull;
//import com.lxj.xpopup.impl.FullScreenPopupView;
//
//未完成
//public class WithdrawalCompleteDialog extends FullScreenPopupView {
//
//
//
//    private Button with_drawald_completion;
//    private ICallBack parentClose;
//
//    public WithdrawalCompleteDialog(@NonNull Context context) {
//        super(context);
//    }
//
//    @Override
//    protected int getImplLayoutId() {
//        return R.layout.withdrawald_complete_dialog;
//    }
//
//    @Override
//    protected void onCreate() {
//        super.onCreate();
//        with_drawald_completion = findViewById(R.id.with_drawald_completion);
//        with_drawald_completion.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (DoubleClickUtils.isFastDoubleClick()) {
//                    dismiss();
//                    if (parentClose != null) {
//                        parentClose.callBack();
//                    }
//                }
//            }
//        });
//    }
//
//
//    public void setParentClose(ICallBack parentClose) {
//        this.parentClose = parentClose;
//    }
//
//
//}
