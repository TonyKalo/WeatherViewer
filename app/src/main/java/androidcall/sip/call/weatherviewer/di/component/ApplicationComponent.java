package androidcall.sip.call.weatherviewer.di.component;


import android.content.Context;

import javax.inject.Singleton;

import androidcall.sip.call.weatherviewer.WeatherApp;
import androidcall.sip.call.weatherviewer.data.DataManager;
import androidcall.sip.call.weatherviewer.di.module.ApplicationModule;
import androidcall.sip.call.weatherviewer.di.qualifiers.ApplicationContext;
import dagger.Component;

@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WeatherApp app);


    DataManager getDataManager();
}
