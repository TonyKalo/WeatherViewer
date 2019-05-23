package androidcall.sip.call.weatherviewer.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import androidcall.sip.call.weatherviewer.data.db.dao.WeatherDao;
import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;

@Database(entities = WeatherMainInfo.class,version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "weather_database";
    private static AppDatabase instance;

    public synchronized static AppDatabase getDatabaseInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

    public abstract WeatherDao weatherDao();

}

