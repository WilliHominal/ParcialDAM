package com.warh.parcialdam.dao;

import android.content.Context;

import androidx.room.Room;

import com.warh.parcialdam.model.PersonaModel;

import java.util.ArrayList;
import java.util.Collections;

public class PersonaRepository {
    private static PersonaRepository _DB= null;
    private PersonaRoomDao personaDao;
    private PersonaRepository(Context ctx){
        RoomDB db = Room.databaseBuilder(ctx,RoomDB.class, "par-db").allowMainThreadQueries().build();
        personaDao = db.personaRoomDao();
    }
    public static PersonaRepository getInstance(Context ctx){
        if(_DB==null) _DB = new PersonaRepository(ctx);
        return _DB;
    }

    public void guardarPersona(PersonaModel p){
        personaDao.guardarPersona(p);
    }
    public ArrayList<PersonaModel> listarPersonas(){
        PersonaModel[] personas = personaDao.listarPersonas();
        ArrayList<PersonaModel> personasList = new ArrayList<>();
        Collections.addAll(personasList, personas);
        return personasList;
    }
}
