package com.example.expensemanagement.Daos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.expensemanagement.Domain.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User where userName=:userName and password=:password  ORDER BY ROWID ASC LIMIT 1")
    LiveData<User> getUser(@NonNull String userName, @NonNull String password);

    @Query("SELECT Count(*) FROM User")
    int checkUserExist();
}
