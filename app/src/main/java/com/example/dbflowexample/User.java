package com.example.dbflowexample;

import androidx.annotation.NonNull;
import com.dbflow5.annotation.Column;
import com.dbflow5.annotation.ConflictAction;
import com.dbflow5.annotation.PrimaryKey;
import com.dbflow5.annotation.Table;
import com.dbflow5.annotation.Unique;
import com.dbflow5.config.FlowManager;
import com.dbflow5.query.SQLite;
import com.dbflow5.structure.BaseModel;

/**
 * User model class - references database class
 */
@Table(database = AppDatabase.class, name = "users")
public class User extends BaseModel {
    // PrimaryKey is unique and will fail on conflict (weeell, obviously)
    @PrimaryKey
    @Unique(onUniqueConflict = ConflictAction.FAIL)
    private String name;
    @Column()
    private String password;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("USER %s:%s", this.getName(), this.getPassword());
    }

    // public constructor without any parameters (required by DBFlow)
    public User() {}

    public User(String name, String password) {
        this.setName(name);
        this.setPassword(Utils.sha256(password));
    }

    public static User getByUsernameAndPassword(String username, String password) {
        return SQLite.select()
                .from(User.class)
                .where(User_Table.name.eq(username))
                .and(User_Table.password.eq(Utils.sha256(password)))
                .querySingle(FlowManager.getDatabase(AppDatabase.class));
    }
}
