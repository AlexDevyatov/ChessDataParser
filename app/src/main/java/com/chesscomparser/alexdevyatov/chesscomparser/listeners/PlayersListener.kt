package com.chesscomparser.alexdevyatov.chesscomparser.listeners

import android.util.Log
import com.chesscomparser.alexdevyatov.chesscomparser.model.PlayersRequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayersListener : Callback<PlayersRequestResult> {

    override fun onFailure(call: Call<PlayersRequestResult>, t: Throwable) {

    }

    override fun onResponse(call: Call<PlayersRequestResult>, response: Response<PlayersRequestResult>) {
        val body = response.body()
    }
}