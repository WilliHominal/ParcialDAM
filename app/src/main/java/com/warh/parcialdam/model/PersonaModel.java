package com.warh.parcialdam.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PERSONA")
public class PersonaModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="ID")
    private int id;

    @ColumnInfo(name="NOMBRE")
    private String nombre;

    @ColumnInfo(name="GENERO")
    private String genero;

    public PersonaModel(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "" + id + " - " + nombre + " (" + genero + ")";
    }
}
