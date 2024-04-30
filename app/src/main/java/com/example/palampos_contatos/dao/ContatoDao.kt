package com.example.palampos_contatos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.palampos_contatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun salvar(contato: Contato)

    @Update
    fun atualizar(contato: Contato)

    @Delete
    fun deletar(contato: Contato)

    @Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
    fun listarTodosOsContatos(): List<Contato>

    @Query("SELECT * FROM tbl_contatos WHERE nome = :nome ORDER BY nome ASC")
    fun buscarContatoPeloNome(nome: String): List<Contato>

    @Query("SELECT * FROM tbl_contatos WHERE is_amigo = 1")
    fun listarTodosOsAmigos(): List<Contato>

}