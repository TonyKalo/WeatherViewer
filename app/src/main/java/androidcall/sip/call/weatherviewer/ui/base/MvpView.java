package androidcall.sip.call.weatherviewer.ui.base;

import android.support.annotation.StringRes;

public interface MvpView  {

    void showProgressDialog(String msg);

    void showProgressDialog(@StringRes int msg);

    void closeProgressDialog();

    void showToast(String msg);

    void showToast(@StringRes int resId);

    boolean isNetworkConnected();
}
