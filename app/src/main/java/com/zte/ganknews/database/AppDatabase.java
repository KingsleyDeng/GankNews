
package com.zte.ganknews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.zte.ganknews.data.DoubanMomentContent;
import com.zte.ganknews.data.DoubanMomentNewsPosts;
import com.zte.ganknews.data.GuokrHandpickContentResult;
import com.zte.ganknews.data.GuokrHandpickNewsResult;
import com.zte.ganknews.data.ZhihuDailyContent;
import com.zte.ganknews.data.ZhihuDailyNewsQuestion;
import com.zte.ganknews.database.dao.DoubanMomentContentDao;
import com.zte.ganknews.database.dao.DoubanMomentNewsDao;
import com.zte.ganknews.database.dao.GuokrHandpickContentDao;
import com.zte.ganknews.database.dao.GuokrHandpickNewsDao;
import com.zte.ganknews.database.dao.ZhihuDailyContentDao;
import com.zte.ganknews.database.dao.ZhihuDailyNewsDao;


/**
 * Created by lizhaotailang on 2017/6/15.
 * <p>
 * Main database description.
 */

@Database(entities = {
        ZhihuDailyNewsQuestion.class,
        DoubanMomentNewsPosts.class,
        GuokrHandpickNewsResult.class,
        ZhihuDailyContent.class,
        DoubanMomentContent.class,
        GuokrHandpickContentResult.class},
        version = 1)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "paper-plane-db";

    public abstract ZhihuDailyNewsDao zhihuDailyNewsDao();

    public abstract DoubanMomentNewsDao doubanMomentNewsDao();

    public abstract GuokrHandpickNewsDao guokrHandpickNewsDao();

    public abstract ZhihuDailyContentDao zhihuDailyContentDao();

    public abstract DoubanMomentContentDao doubanMomentContentDao();

    public abstract GuokrHandpickContentDao guokrHandpickContentDao();

}
