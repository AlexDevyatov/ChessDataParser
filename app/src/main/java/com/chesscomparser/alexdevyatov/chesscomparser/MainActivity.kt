package com.chesscomparser.alexdevyatov.chesscomparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.chesscomparser.alexdevyatov.chesscomparser.adapters.CountriesListAdapter
import com.chesscomparser.alexdevyatov.chesscomparser.dao.CountryDao
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import com.chesscomparser.alexdevyatov.chesscomparser.listeners.PlayersListener
import com.chesscomparser.alexdevyatov.chesscomparser.repository.RepositoryProvider

class MainActivity : AppCompatActivity(){

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list = CountryDao.loadAllCountries()
        recyclerView = findViewById(R.id.rv_countries_list)
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.let {
            it.layoutManager = layoutManager
            it.adapter = CountriesListAdapter(list, object :  CountriesListAdapter.OnItemClickListener {
                override fun onItemClick(country: Country) {
                    RepositoryProvider.providePlayersRepository().getPlayers(country.code!!)
                            .enqueue(PlayersListener())
                }
            })
            it.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
    }

}
