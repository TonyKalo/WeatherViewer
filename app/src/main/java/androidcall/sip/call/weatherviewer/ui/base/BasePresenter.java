package androidcall.sip.call.weatherviewer.ui.base;

import com.bumptech.glide.load.engine.GlideException;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import androidcall.sip.call.weatherviewer.R;
import androidcall.sip.call.weatherviewer.data.DataManager;
import androidcall.sip.call.weatherviewer.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public class BasePresenter <V extends MvpView> implements MvpPresenter<V> {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    private V view;

    @Inject
    public BasePresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    public boolean isViewAttached() {
        return view != null;
    }


    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public V getView() {
        return view;
    }

    @Override
    public void onAttach(V mvpView) {
        view=mvpView;
    }

    @Override
    public void onDetach() {
        view=null;
        compositeDisposable.dispose();
    }

    @Override
    public void handleErrors(Throwable e) {
        if(!view.isNetworkConnected()){
            view.showToast(R.string.err_no_net);

        } else if (e instanceof HttpException) {
            switch (((HttpException) e).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    view.showToast(R.string.err_unauthorised);
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    view.showToast(R.string.err_forbiden);
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    view.showToast(R.string.err_internal_server);
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    view.showToast(R.string.err_bad_request);
                    break;
                default:
                    view.showToast(e.getLocalizedMessage());

            }
        } else if (e instanceof GlideException) {
            view.showToast(R.string.err_glide);
        } else if (e instanceof JsonSyntaxException) {
            view.showToast(R.string.err_not_responding);
        } else {
            view.showToast(e.getMessage());
        }
    }
}
