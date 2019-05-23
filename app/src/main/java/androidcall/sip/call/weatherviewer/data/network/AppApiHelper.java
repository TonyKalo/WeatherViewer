package androidcall.sip.call.weatherviewer.data.network;


import javax.inject.Inject;
import javax.inject.Singleton;

import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper{

    private ApiService service;

    @Inject
    public AppApiHelper(ApiService service) {
        this.service = service;
    }

    @Override
    public Single<WeatherMain> getWeather(String city, String unit, String APPID) {
        return service.getWeather(city, unit,APPID);
    }
}
