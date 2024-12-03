package com.example.fitneighborapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fitneighborapp.messages.Messages;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert
    void insertMessage(Messages message);

    @Query("SELECT * FROM messages WHERE chatType = :chatType ORDER BY timestamp ASC")
    List<Messages> getMessagesForChat(String chatType);
}
