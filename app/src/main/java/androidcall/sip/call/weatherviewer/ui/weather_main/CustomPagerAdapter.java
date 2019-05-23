package androidcall.sip.call.weatherviewer.ui.weather_main;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import androidcall.sip.call.weatherviewer.ui.weather_main.amsterdam.AmsterdamWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.berlin.BerlinWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.london.LondonWeatherFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.paris.ParisWeatherFragment;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public static final int FRAGMENT_LONDON=0;
    public static final int FRAGMENT_BERLIN=1;
    public static final int FRAGMENT_PARIS=2;
    public static final int FRAGMENT_AMSTERDAM=3;

    private final int FRAGMENT_COUNT = 4;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return LondonWeatherFragment.newInstance();
            case 1:
                return BerlinWeatherFragment.newInstance();
            case 2:
                return ParisWeatherFragment.newInstance();
            case 3:
                return AmsterdamWeatherFragment.newInstance();
        }
        return null;
    }


    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }


}
