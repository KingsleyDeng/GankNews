package com.zte.ganknews.data;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lizhaotailang on 2017/6/17.
 *
 * Immutable model class for guokr handpick content image info. See the json string for more details.
 * Entity class for {@link com.google.gson.Gson} and {@link android.arch.persistence.room.Room}.
 */
public class GuokrHandpickContentImageInfo {

    @ColumnInfo(name = "image_info_url")
    @Expose
    @SerializedName("url")
    private String url;

    @ColumnInfo(name = "image_info_width")
    @Expose
    @SerializedName("width")
    private int width;

    @ColumnInfo(name = "image_info_height")
    @Expose
    @SerializedName("height")
    private int height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
