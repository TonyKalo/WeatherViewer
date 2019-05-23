package androidcall.sip.call.weatherviewer.util.rx;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidcall.sip.call.weatherviewer.di.qualifiers.ApplicationContext;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class AppSchedulerProvider implements SchedulerProvider{


    @Inject
    public AppSchedulerProvider() {
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

}


