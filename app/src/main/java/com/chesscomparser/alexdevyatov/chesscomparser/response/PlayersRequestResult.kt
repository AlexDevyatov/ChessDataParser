package com.chesscomparser.alexdevyatov.chesscomparser.response

data class PlayersRequestResult(
        val countryCode: String,
        val players: List<String>
)