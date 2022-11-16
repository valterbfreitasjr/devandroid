package com.empresalogistica.jogoprapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//Necessário inserir a notação @Database e passar qual entidade (Questoes) referente a esse banco.
@Database(entities = {Questoes.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase {

    //Através desse método é possível recuperar o objeto DAO
    private static BancoDeDados INSTANCE;

    //Instancia única para o BD
    public abstract MeuDAO meuDAO();

    // Modelo 'Singleton'
    public static BancoDeDados getBancoDeDados(final Context context){
        if(INSTANCE == null){
            synchronized (BancoDeDados.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BancoDeDados.class, "bd_questoes").allowMainThreadQueries()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
