package androidcall.sip.call.weatherviewer.ui.weather_main;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import androidcall.sip.call.weatherviewer.R;
import androidcall.sip.call.weatherviewer.ui.base.BaseActivity;
import androidcall.sip.call.weatherviewer.ui.base.MvpView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> presenter;

    @Inject
    CustomPagerAdapter pagerAdapter;

    @BindView(R.id.viewpager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        presenter.onAttach(this);
        setUp();

    }

    @Override
    protected void setUp() {
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
    }



    @OnClick (R.id.london) public void onLondonClick(){
        presenter.onLondonClick();
    }
    @OnClick (R.id.berlin) public void onBerlinClick(){
        presenter.onBerlinClick();
    }
    @OnClick (R.id.amsterdam) public void onAmsterdamClick(){
        presenter.onAmsterdamClick();
    }
    @OnClick (R.id.paris) public void onParisClick(){
        presenter.onParisClick();
    }

    @Override
    public void changeFragment(int fragmentItemNumber) {
        viewPager.setCurrentItem(fragmentItemNumber, true);
    }
}
