package androidcall.sip.call.weatherviewer.ui.weather_main;

import javax.inject.Inject;

import androidcall.sip.call.weatherviewer.data.DataManager;
import androidcall.sip.call.weatherviewer.ui.base.BaseActivity;
import androidcall.sip.call.weatherviewer.ui.base.BasePresenter;
import androidcall.sip.call.weatherviewer.ui.base.MvpPresenter;
import androidcall.sip.call.weatherviewer.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLondonClick() {
        getView().changeFragment(CustomPagerAdapter.FRAGMENT_LONDON);
    }

    @Override
    public void onBerlinClick() {
        getView().changeFragment(CustomPagerAdapter.FRAGMENT_BERLIN);
    }

    @Override
    public void onAmsterdamClick() {
        getView().changeFragment(CustomPagerAdapter.FRAGMENT_AMSTERDAM);
    }

    @Override
    public void onParisClick() {
        getView().changeFragment(CustomPagerAdapter.FRAGMENT_PARIS);
    }
}
