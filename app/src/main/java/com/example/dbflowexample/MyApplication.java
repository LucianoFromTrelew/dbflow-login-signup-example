package com.example.dbflowexample;

import android.app.Application;
import android.util.Log;

import com.dbflow5.config.DBFlowDatabase;
import com.dbflow5.config.FlowManager;
import com.dbflow5.query.SQLite;
import com.dbflow5.transaction.FastStoreModelTransaction;

import java.util.ArrayList;
import java.util.List;


/**
 * Application class - referenced in AndroidManifest.xml
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        DBFlowDatabase db = FlowManager.getDatabase(AppDatabase.class);
//        db.destroy();
        List<User> users = SQLite.select().from(User.class).queryList(db);
        if (users.size() <= 0) {
            this.loadData();
        }
    }

    private void loadData() {
        DBFlowDatabase db = FlowManager.getDatabase(AppDatabase.class);
        Log.i("FlowManager", "CARGANDO DATOSSS");
        String usernames[] = {
                "joaquinleguizamon",
                "lauraleguizamon",
                "mariamontenegro",
                "martinromero",
                "jazminblanco",
                "juanpablogodoy",
                "martinatorres",
                "mariahernandez",
                "bautistagimenez",
                "santiagoojeda"
        };

        List<User> users = new ArrayList<User>();
        for(String s : usernames) {
            users.add(new User(s, s));
        }

        // Insert several users asynchronously
        FastStoreModelTransaction.insertBuilder(FlowManager.getModelAdapter(User.class))
                .addAll(users)
                .build().execute(db);
    }
}
