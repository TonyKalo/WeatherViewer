package androidcall.sip.call.weatherviewer.di.module;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import androidcall.sip.call.weatherviewer.data.AppDataManager;
import androidcall.sip.call.weatherviewer.data.DataManager;
import androidcall.sip.call.weatherviewer.data.db.AppDatabase;
import androidcall.sip.call.weatherviewer.data.network.ApiHelper;
import androidcall.sip.call.weatherviewer.data.network.ApiService;
import androidcall.sip.call.weatherviewer.data.network.AppApiHelper;
import androidcall.sip.call.weatherviewer.di.qualifiers.ApplicationContext;
import androidcall.sip.call.weatherviewer.util.AppConstants;
import androidcall.sip.call.weatherviewer.util.rx.AppSchedulerProvider;
import androidcall.sip.call.weatherviewer.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase() {
        return AppDatabase.getDatabaseInstance(application);
    }




    @Provides
    public OkHttpClient provideClient() {


        return new  OkHttpClient.Builder().
                        connectTimeout(AppConstants.CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS).
                        readTimeout(AppConstants.READ_TIMEOUT_SECONDS,TimeUnit.SECONDS).
                        writeTimeout(AppConstants.WRITE_TIMEOUT_SECONDS,TimeUnit.SECONDS).
                        build();
    }



    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    @Provides
    public ApiService provideApiService() {
        return provideRetrofit(AppConstants.BASE_URL, provideClient()).create(ApiService.class);
    }
}
