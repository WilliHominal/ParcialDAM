package com.warh.parcialdam.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.warh.parcialdam.model.PersonaModel;

@Dao
public interface PersonaRoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void guardarPersona(PersonaModel persona);

    @Query("SELECT * FROM PERSONA")
    public PersonaModel[] listarPersonas();
}
