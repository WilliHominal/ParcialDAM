package com.warh.parcialdam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.room.Room;

import com.warh.parcialdam.dao.BuilderDB;
import com.warh.parcialdam.dao.PersonaRoomDao;
import com.warh.parcialdam.dao.RoomDB;
import com.warh.parcialdam.model.PersonaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nombrePersonaET;
    RadioGroup generoRG;
    Button guardarPersonaBtn;
    Button listarPersonasBtn;
    ListView listadoPersonasLV;
    List<PersonaModel> listadoPersonas;
    ArrayAdapter<PersonaModel> adapter;

    BuilderDB personaRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombrePersonaET = (EditText) findViewById(R.id.nombre_persona_ET);
        generoRG = (RadioGroup) findViewById(R.id.genero_RG);
        guardarPersonaBtn = (Button) findViewById(R.id.guardar_persona_btn);
        listarPersonasBtn = (Button) findViewById(R.id.listar_personas_btn);
        listadoPersonasLV = (ListView) findViewById(R.id.listado_LV);
        listadoPersonas = new ArrayList<>();
        adapter = new ArrayAdapter<PersonaModel>(this, android.R.layout.simple_list_item_1, listadoPersonas);

        personaRepository = BuilderDB.getInstance(this);

        guardarPersonaBtn.setOnClickListener(view -> {
            String nombre = nombrePersonaET.getText().toString();
            int opcGenero = generoRG.getCheckedRadioButtonId();
            String genero = "";

            switch(opcGenero){
                case 0: genero = "Masculino"; break;
                case 1: genero = "Femenino"; break;
                default: genero = "Otro";
            }

            PersonaModel p = new PersonaModel(nombre, genero);
            personaRepository.guardarPersona(p);
        });

        listarPersonasBtn.setOnClickListener(view -> {
            listadoPersonas = Arrays.asList(personaRepository.listarPersonas());
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listadoPersonas);
        });
    }
}