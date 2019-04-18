package com.chesscomparser.alexdevyatov.chesscomparser.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.chesscomparser.alexdevyatov.chesscomparser.R
import com.chesscomparser.alexdevyatov.chesscomparser.adapters.PlayersListAdapter
import com.chesscomparser.alexdevyatov.chesscomparser.dao.Dao
import com.chesscomparser.alexdevyatov.chesscomparser.listeners.ProfileListener
import com.chesscomparser.alexdevyatov.chesscomparser.model.Player
import com.chesscomparser.alexdevyatov.chesscomparser.repository.RepositoryProvider

class PlayersActivity : AppCompatActivity() {

    companion object {

        private val INTENT_COUNTRY_CODE = "country_code"

        fun newIntent(context: Context, countryCode: String?) : Intent {
            val intent = Intent(context, PlayersActivity::class.java)
            intent.putExtra(INTENT_COUNTRY_CODE, countryCode)
            return intent
        }
    }

    private var rvPlayers : RecyclerView? = null
    private var countryCode : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)
        countryCode = intent.getStringExtra(INTENT_COUNTRY_CODE)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val players = Dao.loadPlayersByCountry(countryCode)
        val layoutManager = LinearLayoutManager(this)
        rvPlayers = findViewById(R.id.rv_players_list)
        rvPlayers?.let {
            it.layoutManager = layoutManager
            val context = this
            it.adapter = PlayersListAdapter(players, object : PlayersListAdapter.OnItemClickListener {
                override fun onItemClick(item: Player) {
                    Toast.makeText(context, item.nickname, Toast.LENGTH_SHORT).show()
                    RepositoryProvider.providePlayersRepository().getPlayerProfile(item.nickname!!)
                            .enqueue(ProfileListener(item.nickname!!))
                }
            })
            it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
