package androidcall.sip.call.weatherviewer.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidcall.sip.call.weatherviewer.data.db.AppDatabase;
import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;
import androidcall.sip.call.weatherviewer.data.network.ApiHelper;

import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import androidcall.sip.call.weatherviewer.di.qualifiers.ApplicationContext;
import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private final Context context;
    private final ApiHelper apiHelper;
    private final AppDatabase appDatabase;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ApiHelper mApiHelper, AppDatabase appDatabase) {
        this.context = context;
        this.apiHelper = mApiHelper;
        this.appDatabase=appDatabase;
    }

    @Override
    public Single<WeatherMain> getWeather(String city, String unit, String APPID) {
        return apiHelper.getWeather(city,unit,APPID);
    }

    @Override
    public WeatherMainInfo getWeatherByCityFromDb(String city) {
        return appDatabase.weatherDao().getWeatherByCityFromDb(city);
    }

    @Override
    public void deleteWeatherFromDbByCity(String city) {
        appDatabase.weatherDao().deleteWeatherFromDbByCity(city);
    }

    @Override
    public void insertWeatherInDB(WeatherMainInfo weatherMainInfo) {
        appDatabase.weatherDao().insertWeatherInDB(weatherMainInfo);
    }
}
