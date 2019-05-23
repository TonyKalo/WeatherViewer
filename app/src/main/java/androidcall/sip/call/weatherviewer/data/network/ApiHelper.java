package androidcall.sip.call.weatherviewer.data.network;


import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import io.reactivex.Single;

public interface ApiHelper {

    Single<WeatherMain> getWeather(String city, String unit, String APPID);
}
