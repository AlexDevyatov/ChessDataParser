package com.chesscomparser.alexdevyatov.chesscomparser.listeners

import com.chesscomparser.alexdevyatov.chesscomparser.dao.Dao
import com.chesscomparser.alexdevyatov.chesscomparser.response.PlayerProfileRequestResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileListener(val nickname: String) : Callback<PlayerProfileRequestResult> {
    override fun onFailure(call: Call<PlayerProfileRequestResult>, t: Throwable) {

    }

    override fun onResponse(call: Call<PlayerProfileRequestResult>, response: Response<PlayerProfileRequestResult>) {
        val avatar = response.body()?.avatar
        val name = response.body()?.name
        val location = response.body()?.location

        val player = Dao.getPlayer(nickname)
        if (avatar != null) player.avatarUrl = avatar
        if (name != null) player.name = name
        if (location != null) player.location = location

        Dao.deletePlayer(nickname)
        player.save()
    }
}