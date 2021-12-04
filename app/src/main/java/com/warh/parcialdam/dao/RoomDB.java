package com.warh.parcialdam.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.warh.parcialdam.model.PersonaModel;

@Database(entities = {PersonaModel.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    public abstract PersonaRoomDao personaRoomDao();
}
