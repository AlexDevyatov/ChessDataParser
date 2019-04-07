package com.chesscomparser.alexdevyatov.chesscomparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.activeandroid.ActiveAndroid
import com.chesscomparser.alexdevyatov.chesscomparser.adapters.CountriesListAdapter
import com.chesscomparser.alexdevyatov.chesscomparser.dao.CountryDao
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import com.chesscomparser.alexdevyatov.chesscomparser.model.PlayersRequestResult
import com.chesscomparser.alexdevyatov.chesscomparser.repository.RepositoryProvider
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

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
                    val call = RepositoryProvider.providePlayersRepository().getPlayers(country.code!!)
                    call.enqueue(object : retrofit2.Callback<PlayersRequestResult> {
                        override fun onFailure(call: Call<PlayersRequestResult>, t: Throwable) {

                        }

                        override fun onResponse(call: Call<PlayersRequestResult>, response: Response<PlayersRequestResult>) {
                            val body = response.body()

                        }
                    })
                }
            })
            it.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        }
    }

}
