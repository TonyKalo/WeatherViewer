package androidcall.sip.call.weatherviewer.ui.weather_main;

import androidcall.sip.call.weatherviewer.ui.base.MvpPresenter;
import androidcall.sip.call.weatherviewer.ui.base.MvpView;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onLondonClick();

    void onBerlinClick();

    void onAmsterdamClick();

    void onParisClick();


}
