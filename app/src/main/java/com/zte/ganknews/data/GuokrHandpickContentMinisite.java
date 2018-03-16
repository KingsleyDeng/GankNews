package com.zte.ganknews.data;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lizhaotailang on 2017/6/17.
 *
 * Immutable model class for guokr handpick content minisite. See the json string for more details.
 * Entity class for {@link com.google.gson.Gson} and {@link android.arch.persistence.room.Room}.
 */
public class GuokrHandpickContentMinisite {

    @ColumnInfo(name = "minisite_name")
    @Expose
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "minisite_url")
    @Expose
    @SerializedName("url")
    private String url;

    @ColumnInfo(name = "minisite_introduction")
    @Expose
    @SerializedName("introduction")
    private String introduction;

    @ColumnInfo(name = "minisite__key")
    @Expose
    @SerializedName("key")
    private String key;

    @ColumnInfo(name = "minisite_date_created")
    @Expose
    @SerializedName("date_created")
    private String dateCreated;

    @ColumnInfo(name = "minisite_icon")
    @Expose
    @SerializedName("icon")
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
