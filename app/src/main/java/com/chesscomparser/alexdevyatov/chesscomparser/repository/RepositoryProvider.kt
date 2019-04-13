package com.chesscomparser.alexdevyatov.chesscomparser.repository

import com.chesscomparser.alexdevyatov.chesscomparser.service.ChessComApi

object RepositoryProvider {

    fun providePlayersRepository(): SiteRepository {
        return SiteRepository(ChessComApi.create())
    }
}