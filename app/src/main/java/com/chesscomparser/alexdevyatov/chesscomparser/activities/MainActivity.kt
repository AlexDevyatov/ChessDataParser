package com.chesscomparser.alexdevyatov.chesscomparser.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.chesscomparser.alexdevyatov.chesscomparser.R
import com.chesscomparser.alexdevyatov.chesscomparser.adapters.CountriesListAdapter
import com.chesscomparser.alexdevyatov.chesscomparser.dao.Dao
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import com.chesscomparser.alexdevyatov.chesscomparser.listeners.PlayersListener
import com.chesscomparser.alexdevyatov.chesscomparser.repository.RepositoryProvider

class MainActivity : AppCompatActivity() {

    var rvCountries: RecyclerView? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        progressBar = findViewById(R.id.pb_main)
    }

    private fun initRecyclerView() {
        val list = Dao.loadAllCountries()
        rvCountries = findViewById(R.id.rv_countries_list)
        val layoutManager = LinearLayoutManager(this)
        rvCountries?.let {
            it.layoutManager = layoutManager
            val context = this
            it.adapter = CountriesListAdapter(list, object : CountriesListAdapter.OnItemClickListener {
                override fun onItemClick(country: Country) {
                    if (Dao.getPlayersCountByCountry(country.code) == 0) {
                        progressBar!!.visibility = View.VISIBLE
                        RepositoryProvider.providePlayersRepository().getPlayers(country.code!!)
                                .enqueue(PlayersListener(context, country.code!!))
                    } else {
                        val intent = PlayersActivity.newIntent(context, country.code)
                        startActivity(intent)
                    }
                }
            })
            it.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
    }
}
