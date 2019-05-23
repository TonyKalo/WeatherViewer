package androidcall.sip.call.weatherviewer.util;

import java.util.Calendar;
import java.util.Date;

import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;
import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;

public class WeatherHelper {


    public static WeatherMainInfo getWeatherNecessaryData(WeatherMain weatherMain){

        Date time = Calendar.getInstance().getTime();
        WeatherMainInfo weatherMainInfo = new WeatherMainInfo(
                weatherMain.getName(),
                weatherMain.getWeather().get(0).getDescription(),
                weatherMain.getMain().getTemp(),
                weatherMain.getMain().getTempMin(),
                weatherMain.getMain().getTempMax(),
                weatherMain.getMain().getHumidity(),
                weatherMain.getMain().getPressure(),
                time,
                weatherMain.getWind().getSpeed(),
                weatherMain.getSys().getSunrise(),
                weatherMain.getSys().getSunset(),
                weatherMain.getWeather().get(0).getIcon());

        return  weatherMainInfo;
    }
}
