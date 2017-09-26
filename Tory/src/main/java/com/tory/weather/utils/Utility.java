package com.tory.weather.utils;

import android.text.TextUtils;

import com.tory.weather.db.City;
import com.tory.weather.db.County;
import com.tory.weather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by soonyo on 2017/9/26.
 */

public class Utility {

    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray provinceAr = new JSONArray(response);
                for (int i =0;i < provinceAr.length();i++){
                    JSONObject provinceJson = provinceAr.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceJson.getString("name"));
                    province.setProvinceCode(provinceJson.getInt("id"));
                    province.save();
                }
                return true;
            } catch (Exception e) {
                LogManager.getInstance().LogCat(e.getMessage());
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray cityAr = new JSONArray(response);
                for (int i = 0;i < cityAr.length();i++){
                    JSONObject cityJson = cityAr.getJSONObject(i);
                    City city = new City();
                    city.setProvinceId(provinceId);
                    city.setCityCode(cityJson.getInt("id"));
                    city.setCityName(cityJson.getString("name"));
                    city.save();
                }
                return true;
            } catch (Exception e) {
                LogManager.getInstance().LogCat(e.getMessage());
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray countyAr = new JSONArray(response);
                for (int i = 0;i < countyAr.length();i++){
                    JSONObject countyJson = countyAr.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setWeatherId(countyJson.getString("weather_id"));
                    county.setCountyName(countyJson.getString("name"));
                    county.save();
                }
                return true;
            } catch (Exception e) {
                LogManager.getInstance().LogCat(e.getMessage());
            }
            return true;
        }
        return false;
    }
}
