package androidcall.sip.call.weatherviewer.data.db.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import javax.inject.Inject;

import androidcall.sip.call.weatherviewer.util.DateConverter;

@Entity(tableName = "weather")
@TypeConverters({DateConverter.class})
public class WeatherMainInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "city")
    private String city;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "temp_now")
    private Double tempNow;
    @ColumnInfo(name = "min_temp")
    private Double minTemp;
    @ColumnInfo(name = "max_temp")
    private Double maxTemp;
    @ColumnInfo(name = "humidity")
    private int humidity;
    @ColumnInfo(name = "pressure")
    private int pressure;
    @ColumnInfo(name = "update")
    private Date update;
    @ColumnInfo(name = "wind_speed")
    private Double windSpeed;
    @ColumnInfo(name = "sunrise")
    private int sunrise;
    @ColumnInfo(name = "sunset")
    private int sunset;
    @ColumnInfo(name = "icon")
    private String icon;


    public WeatherMainInfo(String city, String description, Double tempNow, Double minTemp, Double maxTemp, int humidity, int pressure, Date update, Double windSpeed, int sunrise, int sunset,String icon) {
        this.city = city;
        this.description = description;
        this.tempNow = tempNow;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.update = update;
        this.windSpeed = windSpeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.icon=icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTempNow() {
        return tempNow;
    }

    public void setTempNow(Double tempNow) {
        this.tempNow = tempNow;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}
