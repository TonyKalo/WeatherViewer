package androidcall.sip.call.weatherviewer.data.network;


import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("data/2.5/weather")
    Single<WeatherMain>getWeather(
            @Query("q") String city,
            @Query("units") String unit,
            @Query("APPID") String appID);
}
