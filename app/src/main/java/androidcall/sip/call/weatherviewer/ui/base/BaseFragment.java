package androidcall.sip.call.weatherviewer.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;

import androidcall.sip.call.weatherviewer.di.component.ActivityComponent;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity activity;
    private Unbinder unBinder;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.activity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    protected abstract void setUp(View view);

    public void setUnBinder(Unbinder unBinder) {
        this.unBinder = unBinder;
    }


    public BaseActivity getBaseActivity() {
        return activity;
    }

    public ActivityComponent getActivityComponent() {
        if (activity != null) {
            return activity.getActivityComponent();
        }
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgressDialog(String msg) {
        if (activity != null) {
            activity.showProgressDialog(msg);
        }
    }

    @Override
    public void showProgressDialog(@StringRes int msg) {
        if (activity != null) {
            activity.showProgressDialog( msg);
        }
    }

    @Override
    public void closeProgressDialog() {
        if (activity != null) {
            activity.closeProgressDialog();
        }
    }

    @Override
    public void showToast(String msg) {
        if (activity != null) {
            activity.showToast(msg);
        }
    }

    @Override
    public void showToast(int resId) {
        if (activity != null) {
            activity.showToast(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (activity != null) {
            return activity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDestroy() {
        if (unBinder != null) {
            unBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
