package com.chesscomparser.alexdevyatov.chesscomparser.repository

import com.chesscomparser.alexdevyatov.chesscomparser.service.ChessComApi

object RepositoryProvider {

    fun providePlayersRepository(): PlayersRepository {
        return PlayersRepository(ChessComApi.create())
    }
}