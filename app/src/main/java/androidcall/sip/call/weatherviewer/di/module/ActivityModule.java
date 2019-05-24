package androidcall.sip.call.weatherviewer.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidcall.sip.call.weatherviewer.di.qualifiers.ActivityContext;
import androidcall.sip.call.weatherviewer.di.qualifiers.AmsterdamPresenter;
import androidcall.sip.call.weatherviewer.di.qualifiers.BerlinPresenter;
import androidcall.sip.call.weatherviewer.di.qualifiers.DateTimeFormat;
import androidcall.sip.call.weatherviewer.di.qualifiers.LondonPresenter;
import androidcall.sip.call.weatherviewer.di.qualifiers.ParisPresenter;
import androidcall.sip.call.weatherviewer.di.qualifiers.TimeFormat;
import androidcall.sip.call.weatherviewer.di.scopes.PerActivity;
import androidcall.sip.call.weatherviewer.ui.weather_main.CustomPagerAdapter;
import androidcall.sip.call.weatherviewer.ui.weather_main.MainMvpPresenter;
import androidcall.sip.call.weatherviewer.ui.weather_main.MainMvpView;
import androidcall.sip.call.weatherviewer.ui.weather_main.MainPresenter;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherMvpPresenter;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherMvpView;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherPresenter;
import androidcall.sip.call.weatherviewer.util.AppConstants;
import androidcall.sip.call.weatherviewer.util.rx.AppSchedulerProvider;
import androidcall.sip.call.weatherviewer.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    CustomPagerAdapter provideCustomPagerAdapter(AppCompatActivity appCompatActivity){
        return new CustomPagerAdapter(appCompatActivity.getSupportFragmentManager());
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> proMainPresenter(MainPresenter<MainMvpView> presenter){
        return presenter;
    }

    @Provides
    @LondonPresenter
    WeatherMvpPresenter<WeatherMvpView> provideLondonWeatherMvpPresenter(WeatherPresenter<WeatherMvpView> presenter){
        presenter.setCity(AppConstants.LONDON);
        return presenter;
    }

    @Provides
    @AmsterdamPresenter
    WeatherMvpPresenter<WeatherMvpView> provideAmsterdamWeatherMvpPresenter(WeatherPresenter<WeatherMvpView> presenter){
        presenter.setCity(AppConstants.AMSTERDAM);
        return presenter;
    }

    @Provides
    @BerlinPresenter
    WeatherMvpPresenter<WeatherMvpView> provideBerlinWeatherMvpPresenter(WeatherPresenter<WeatherMvpView> presenter){
        presenter.setCity(AppConstants.BERLIN);
        return presenter;
    }

    @Provides
    @ParisPresenter
    WeatherMvpPresenter<WeatherMvpView> provideParisnWeatherMvpPresenter(WeatherPresenter<WeatherMvpView> presenter){
        presenter.setCity(AppConstants.PARIS);
        return presenter;
    }


    @Provides
    Handler provideHandler() {
        return new Handler();

    }

    @Provides
    @DateTimeFormat
    SimpleDateFormat provideDateTimeFormat(){
        return new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT);
    }

    @Provides
    @TimeFormat
    SimpleDateFormat provideTimeFormat(){
        return new SimpleDateFormat(AppConstants.TIME_FORMAT);
    }

    @Provides
    Date provideDate(){
       return new Date();
    }




}
