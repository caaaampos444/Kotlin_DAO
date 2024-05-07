package com.example.palampos_contatos.repository

import android.content.Context
import com.example.palampos_contatos.dao.ContatoDb
import com.example.palampos_contatos.model.Contato

class ContatoRepository(context: Context) {

    private val db = ContatoDb.getBancoDeDados(context).contatoDao()

    fun salvar(contato: Contato): Long{
        return db.salvar(contato)
    }

    fun listarTodosOsContatos():List<Contato>{
        return db.listarTodosOsContatos()
    }

}
