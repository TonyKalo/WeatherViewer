package androidcall.sip.call.weatherviewer.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import androidcall.sip.call.weatherviewer.data.db.model.WeatherMainInfo;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather WHERE city = :city")
    WeatherMainInfo getWeatherByCityFromDb (String city);

    @Query("DELETE FROM weather WHERE city = :city")
    void deleteWeatherFromDbByCity (String city);

    @Insert(onConflict = REPLACE)
    void insertWeatherInDB(WeatherMainInfo weatherMainInfo);
}
