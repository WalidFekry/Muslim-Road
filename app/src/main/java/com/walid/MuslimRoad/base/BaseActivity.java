package com.walid.MuslimRoad.base;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.walid.MuslimRoad.R;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {


    private static final String TAG = "BaseActivity";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private CompositeDisposable p1;
    private Dialog loadingDialog;

    public Handler xoi() {
        return handler;
    }


    public CompositeDisposable cxs() {
        return p1;
    }


    public Handler getHandler() {
        return handler;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p1 = new CompositeDisposable();
    }

    @Override
    public void showLoading() {
        if (loadingDialog != null) {
            hideLoading();
        }
        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading_dialog);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
    }


    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        cxs().dispose();
        super.onDestroy();
    }
}
