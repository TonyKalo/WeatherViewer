package androidcall.sip.call.weatherviewer.di.component;

import androidcall.sip.call.weatherviewer.di.module.ActivityModule;
import androidcall.sip.call.weatherviewer.di.scopes.PerActivity;
import androidcall.sip.call.weatherviewer.ui.weather_main.MainActivity;
import androidcall.sip.call.weatherviewer.ui.weather_main.amsterdam.AmsterdamWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.berlin.BerlinWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.london.LondonWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.paris.ParisWeatherFragment;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(AmsterdamWeatherFragment fragment);
    void inject(BerlinWeatherFragment fragment);
    void inject(LondonWeatherFragment fragment);
    void inject(ParisWeatherFragment fragment);
}
