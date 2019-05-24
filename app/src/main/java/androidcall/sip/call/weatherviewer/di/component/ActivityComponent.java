package androidcall.sip.call.weatherviewer.di.component;

import androidcall.sip.call.weatherviewer.di.module.ActivityModule;
import androidcall.sip.call.weatherviewer.di.scopes.PerActivity;
import androidcall.sip.call.weatherviewer.ui.weather_main.MainActivity;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(WeatherFragment fragment);
}
