package com.empresalogistica.jogoprapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MeuDAO {

    @Insert
    long inserirQuestoes(Questoes questoes);

    @Query("SELECT * FROM Questoes")
    List<Questoes> pesquisarTodasQuestoes();

    @Query("DELETE FROM Questoes")
    void apagarTabela();

    /*
    @Query("SELECT * FROM Questoes WHERE id = :id")
    Questoes getItemById(int id);

    @Query("UPDATE Questoes SET resposta = 'teste' WHERE id = :id")
    void update(int id);
    */
}
