package androidcall.sip.call.weatherviewer;

import android.app.Application;

import androidcall.sip.call.weatherviewer.di.component.ApplicationComponent;
import androidcall.sip.call.weatherviewer.di.component.DaggerApplicationComponent;
import androidcall.sip.call.weatherviewer.di.module.ApplicationModule;

public class WeatherApp extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();


        applicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
