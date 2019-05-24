package androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui;

import android.os.Handler;

import javax.inject.Inject;

import androidcall.sip.call.weatherviewer.data.DataManager;
import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;
import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import androidcall.sip.call.weatherviewer.ui.base.BasePresenter;
import androidcall.sip.call.weatherviewer.util.AppConstants;
import androidcall.sip.call.weatherviewer.util.WeatherHelper;
import androidcall.sip.call.weatherviewer.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class WeatherPresenter<V extends WeatherMvpView> extends BasePresenter<V> implements WeatherMvpPresenter<V>,Runnable {

    private Handler handler;
    private String city;


    @Inject
    public WeatherPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, Handler handler) {
        super(dataManager, schedulerProvider, compositeDisposable);
        this.handler=handler;

    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void onFragmentVisible() {
        handler.removeCallbacks(this);
        handler.post(this);

    }

    @Override
    public void onFragmentInvisible() {
        handler.removeCallbacks(this);
    }

    @Override
    public void onViewCreated() {
        WeatherMainInfo weatherMainInfo = getDataManager().getWeatherByCityFromDb(city);
        if(weatherMainInfo!=null){
            getView().updateValues(weatherMainInfo);
        }
    }

    private void getWeatherCityData(){
        getView().showSwipeLoading();

        getCompositeDisposable().add(getDataManager().getWeather(city,AppConstants.MAIN_UNIT, AppConstants.APPID).
                subscribeOn(getSchedulerProvider().io()).
                observeOn(getSchedulerProvider().ui()).
                subscribe(new Consumer<WeatherMain>() {
                    @Override
                    public void accept(WeatherMain weatherMain) throws Exception {

                        if(!isViewAttached()){
                            return;
                        }

                        WeatherMainInfo weatherMainInfo=WeatherHelper.getWeatherNecessaryData(weatherMain);
                        getView().updateValues(weatherMainInfo);
                        getDataManager().deleteWeatherFromDbByCity(weatherMain.getName());
                        getDataManager().insertWeatherInDB(weatherMainInfo);
                        getView().hideSwipeLoading();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(!isViewAttached()){
                            return;
                        }
                        handleErrors(throwable);
                        getView().hideSwipeLoading();


                    }
                }));

    }

    @Override
    public void run() {
        getWeatherCityData();

        handler.postDelayed(this,AppConstants.TWO_MINUTES);
    }
}
