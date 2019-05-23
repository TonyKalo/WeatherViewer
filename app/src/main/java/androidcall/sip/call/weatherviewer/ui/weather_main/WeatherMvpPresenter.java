package androidcall.sip.call.weatherviewer.ui.weather_main;

import androidcall.sip.call.weatherviewer.ui.base.MvpPresenter;

public interface WeatherMvpPresenter<V extends WeatherMvpView> extends MvpPresenter<V> {

    void onFragmentVisible();
    void onFragmentInvisible();
    void onViewCreated();
}
