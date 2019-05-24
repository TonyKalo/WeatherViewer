package androidcall.sip.call.weatherviewer.util;

public interface AppConstants {

    //Base URL RETROFIT
    public static final String BASE_URL = "https://api.openweathermap.org/";
    public static final String ICON_URL = "https://openweathermap.org/img/w/";


    //APPID OpenWeatherMap
    public static final String APPID = "3b3e6eb2f5e7200c5f5fa9f1814700af";
    public static final String MAIN_UNIT = "metric";


    //okHttp
    public static final int CONNECT_TIMEOUT_SECONDS = 20;
    public static final int READ_TIMEOUT_SECONDS = 20;
    public static final int WRITE_TIMEOUT_SECONDS = 20;

    //Delays(miliseconds)
    public static final int TWO_MINUTES=120000;

    //DateFormat(miliseconds)
    public static final String DATE_TIME_FORMAT ="dd/MM  HH:mm";
    public static final String TIME_FORMAT ="HH:mm";

    //WeatherPresenterCallStrings
    public static final String PARIS ="Paris";
    public static final String AMSTERDAM ="Amsterdam";
    public static final String BERLIN ="Berlin";
    public static final String LONDON ="London";


}
