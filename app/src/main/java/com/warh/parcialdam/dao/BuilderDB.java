package com.warh.parcialdam.dao;

import android.content.Context;

import androidx.room.Room;

import com.warh.parcialdam.model.PersonaModel;

import java.util.List;

public class BuilderDB {
    private static BuilderDB _DB= null;
    private PersonaRoomDao personaDao;
    private BuilderDB(Context ctx){
        RoomDB db = Room.databaseBuilder(ctx,RoomDB.class, "parcial").fallbackToDestructiveMigration().build();
        personaDao = db.personaRoomDao();
    }
    public static BuilderDB getInstance(Context ctx){
        if(_DB==null) _DB = new BuilderDB(ctx);
        return _DB;
    }

    public void guardarPersona(PersonaModel p){
        personaDao.guardarPersona(p);
    }
    public PersonaModel[] listarPersonas(){
        return personaDao.listarPersonas();
    }
}
