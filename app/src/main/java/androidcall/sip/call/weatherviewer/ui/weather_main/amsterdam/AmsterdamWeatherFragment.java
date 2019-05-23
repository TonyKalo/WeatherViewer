package androidcall.sip.call.weatherviewer.ui.weather_main.amsterdam;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import androidcall.sip.call.weatherviewer.R;
import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;
import androidcall.sip.call.weatherviewer.data.network.pojo.weather.WeatherMain;
import androidcall.sip.call.weatherviewer.di.component.ActivityComponent;
import androidcall.sip.call.weatherviewer.di.qualifiers.AmsterdamPresenter;
import androidcall.sip.call.weatherviewer.di.qualifiers.DateTimeFormat;
import androidcall.sip.call.weatherviewer.di.qualifiers.TimeFormat;
import androidcall.sip.call.weatherviewer.ui.base.BaseFragment;
import androidcall.sip.call.weatherviewer.ui.weather_main.WeatherMvpPresenter;
import androidcall.sip.call.weatherviewer.ui.weather_main.WeatherMvpView;
import androidcall.sip.call.weatherviewer.util.AppConstants;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AmsterdamWeatherFragment extends BaseFragment implements WeatherMvpView, SwipeRefreshLayout.OnRefreshListener, RequestListener<Drawable> {

    @Inject
    @AmsterdamPresenter
    WeatherMvpPresenter<WeatherMvpView> presenter;
    @Inject
    @DateTimeFormat
    SimpleDateFormat dateFormat;
    @Inject
    @TimeFormat
    SimpleDateFormat timeFormat;
    @Inject
    Date date;
    @BindView(R.id.weather)
    TextView tvWeather;
    @BindView(R.id.temp_range)
    TextView tvTempRange;
    @BindView(R.id.min_max_temp)
    TextView tvMinMax;
    @BindView(R.id.humidity)
    TextView tvHumidity;
    @BindView(R.id.pressure)
    TextView tvPressure;
    @BindView(R.id.wind_speed)
    TextView tvWindSpeed;
    @BindView(R.id.sunrise)
    TextView tvSunrise;
    @BindView(R.id.sunset)
    TextView tvSunset;
    @BindView(R.id.time)
    TextView tvTime;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipeLoading;
    @BindView(R.id.weather_image)
    ImageView ivIcon;

    public static AmsterdamWeatherFragment newInstance() {
        AmsterdamWeatherFragment fragment = new AmsterdamWeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_amsterdam_weather, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, v));
            presenter.onAttach(this);

        }

        return v;
    }


    @Override
    protected void setUp(View view) {
        swipeLoading.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        swipeLoading.setOnRefreshListener(this);
        presenter.onViewCreated();
        presenter.onFragmentVisible();
    }


    @Override
    public void updateValues(WeatherMainInfo weatherMainInfo) {
        if(isAdded()) {
            String c = getActivity().getResources().getString(R.string.C);
            tvWeather.setText(weatherMainInfo.getDescription());
            String tempRange = String.valueOf(Math.round(weatherMainInfo.getTempNow())) + c;
            tvTempRange.setText(tempRange);
            String minMax = String.valueOf(Math.round(weatherMainInfo.getMinTemp())) + c + "/" + String.valueOf(Math.round(weatherMainInfo.getMaxTemp()) + c);
            tvMinMax.setText(minMax);
            String hum = weatherMainInfo.getHumidity() + " " + getResources().getString(R.string.percent);
            tvHumidity.setText(hum);
            String pre = weatherMainInfo.getPressure() + " " + getResources().getString(R.string.hpa);
            tvPressure.setText(pre);
            String lastUpdate = getResources().getString(R.string.time) + " " + dateFormat.format(weatherMainInfo.getUpdate());
            tvTime.setText(lastUpdate);
            String wind = weatherMainInfo.getWindSpeed() + " " + getResources().getString(R.string.wind_unit);
            tvWindSpeed.setText(wind);
            date.setTime((long) weatherMainInfo.getSunrise() * 1000);
            String sunrise = timeFormat.format(date);
            tvSunrise.setText(sunrise);
            date.setTime((long) weatherMainInfo.getSunset() * 1000);
            String sunset = timeFormat.format(date);
            tvSunset.setText(sunset);
            String iconUrl = AppConstants.ICON_URL + weatherMainInfo.getIcon() + ".png";
            Glide.with(this).load(iconUrl).listener(this).into(ivIcon);
        }
    }

    @Override
    public void showSwipeLoading() {
        if(swipeLoading!=null) {
            swipeLoading.setRefreshing(true);
        }
    }

    @Override
    public void hideSwipeLoading() {
        if(swipeLoading!=null&&swipeLoading.isShown()) {
            swipeLoading.setRefreshing(false);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (presenter != null) {
            if (isVisibleToUser) {
                presenter.onFragmentVisible();
            } else {
                presenter.onFragmentInvisible();
            }
        }
    }

    @Override
    public void onRefresh() {
        presenter.onFragmentVisible();
    }

    @Override
    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
        presenter.handleErrors(e);
        return false;
    }

    @Override
    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
        return false;
    }
}
