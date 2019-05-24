package androidcall.sip.call.weatherviewer.ui.weather_main;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;


import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherMvpPresenter;
import androidcall.sip.call.weatherviewer.ui.weather_main.fragments_ui.WeatherMvpView;


public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    static final int FRAGMENT_LONDON=0;
    static final int FRAGMENT_BERLIN=1;
    static final int FRAGMENT_PARIS=2;
    static final int FRAGMENT_AMSTERDAM=3;

    private final int FRAGMENT_COUNT = 4;

    private WeatherMvpPresenter<WeatherMvpView> londonPresenter;
    private WeatherMvpPresenter<WeatherMvpView> berlinPresenter;
    private WeatherMvpPresenter<WeatherMvpView> parisPresenter;
    private WeatherMvpPresenter<WeatherMvpView> amsterdamPresenter;

    public CustomPagerAdapter(FragmentManager fm, WeatherMvpPresenter<WeatherMvpView> londonPresenter,WeatherMvpPresenter<WeatherMvpView> berlinPresenter,WeatherMvpPresenter<WeatherMvpView> parisPresenter,WeatherMvpPresenter<WeatherMvpView> amsterdamPresenter) {
        super(fm);
        this.londonPresenter=londonPresenter;
        this.berlinPresenter=berlinPresenter;
        this.parisPresenter=parisPresenter;
        this.amsterdamPresenter=amsterdamPresenter;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                WeatherFragment londonFragment = WeatherFragment.newInstance();
                londonFragment.setPresenter(londonPresenter);
                return londonFragment;
            case 1:
                WeatherFragment berlinFragment= WeatherFragment.newInstance();
                berlinFragment.setPresenter(berlinPresenter);
                return berlinFragment;
            case 2:
                WeatherFragment parisFragment= WeatherFragment.newInstance();
                parisFragment.setPresenter(parisPresenter);
                return parisFragment;
            case 3:
                WeatherFragment amsterdamFragment= WeatherFragment.newInstance();
                amsterdamFragment.setPresenter(amsterdamPresenter);
                return amsterdamFragment;
        }
        return null;
    }


    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }


}
