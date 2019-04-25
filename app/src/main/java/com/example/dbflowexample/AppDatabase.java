package com.example.dbflowexample;

import com.dbflow5.annotation.Database;
import com.dbflow5.config.DBFlowDatabase;

/**
 * Database definition
 * IT HAS TO BE ABSTRACT AND EXTEND DBFlowDatabase
 */
@Database(version = AppDatabase.VERSION)
public abstract class AppDatabase extends DBFlowDatabase {
    public static final int VERSION = 1;
}
