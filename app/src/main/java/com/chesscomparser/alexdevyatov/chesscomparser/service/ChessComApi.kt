package com.chesscomparser.alexdevyatov.chesscomparser.service

import com.chesscomparser.alexdevyatov.chesscomparser.response.PlayersRequestResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ChessComApi {

    @GET("pub/country/{iso}/players")
    fun getPlayers(
            @Path("iso")countryCode: String
    ) : Call<PlayersRequestResult>

    companion object Factory {
        fun create(): ChessComApi {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.chess.com/")
                    .build()

            return retrofit.create(ChessComApi::class.java)
        }
    }
}