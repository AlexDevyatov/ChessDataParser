package com.chesscomparser.alexdevyatov.chesscomparser.repository

import com.chesscomparser.alexdevyatov.chesscomparser.model.PlayersRequestResult
import com.chesscomparser.alexdevyatov.chesscomparser.service.ChessComApi
import retrofit2.Call
import java.util.*

class SiteRepository(val apiService: ChessComApi) {
    fun getPlayers(countryCode : String) : Call<PlayersRequestResult> {
        return apiService.getPlayers(countryCode)
    }
}