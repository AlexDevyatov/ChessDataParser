package com.chesscomparser.alexdevyatov.chesscomparser.listeners

import android.content.Context
import android.view.View
import android.widget.Toast
import com.activeandroid.ActiveAndroid
import com.chesscomparser.alexdevyatov.chesscomparser.activities.MainActivity
import com.chesscomparser.alexdevyatov.chesscomparser.activities.PlayersActivity
import com.chesscomparser.alexdevyatov.chesscomparser.model.Player
import com.chesscomparser.alexdevyatov.chesscomparser.response.PlayersRequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersListener(val context: Context, val countryCode: String) : Callback<PlayersRequestResult> {

    override fun onFailure(call: Call<PlayersRequestResult>, t: Throwable) {

    }

    override fun onResponse(call: Call<PlayersRequestResult>, response: Response<PlayersRequestResult>) {
        var players = listOf<String>()
        if (response.body() != null) {
            players = response.body()!!.players
        }
        ActiveAndroid.beginTransaction()
        try {
            for (name in players) {
                val player = Player()
                player.countryCode = countryCode
                player.nickname = name
                player.save()
            }
            ActiveAndroid.setTransactionSuccessful()
        } finally {
            ActiveAndroid.endTransaction()
        }
        val intent = PlayersActivity.newIntent(context, countryCode)
        context.startActivity(intent)
        if (context is MainActivity) {
            context.progressBar!!.visibility = View.GONE
        }
    }
}