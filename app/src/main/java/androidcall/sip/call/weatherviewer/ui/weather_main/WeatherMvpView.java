package androidcall.sip.call.weatherviewer.ui.weather_main;

import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;
import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import androidcall.sip.call.weatherviewer.ui.base.MvpView;

public interface WeatherMvpView extends MvpView {

    void updateValues (WeatherMainInfo weatherMainInfo);
    void showSwipeLoading();
    void hideSwipeLoading();
}
