package com.example.litain23.weather;

/**
 * Created by litain23 on 17. 7. 12.
 */

class Weather {
    private int lati;
    private int longti;
    private int temperature;
    private int humidity;
    private String city;
    private String weat;

    //public Weather(){}
    public Weather(int lati, int longti){
        this.lati = lati;
        this.longti = longti;
    }

    public void setLati(int lat) {this.lati = lat;}
    public void setLongti(int longti) {this.longti = longti;}
    public void setTemperature(int temp) {this.temperature= temp;}
    public void setHumidity(int humidity) {this.humidity = humidity;}
    public void setCity(String city) {this.city= city;}
    public void setWeat(String weat) {this.weat= weat;}

    public int getLati() {return lati;}
    public int getLongti() {return longti;}
    public int getTemperature() {return temperature;}
    public int getHumidity() {return humidity;}
    public String getCity() {return city;}
    public String getWeat() {return weat;}
}
