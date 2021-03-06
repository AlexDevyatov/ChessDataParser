package com.chesscomparser.alexdevyatov.chesscomparser.dao

import com.activeandroid.query.Delete
import com.activeandroid.query.Select
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country
import com.chesscomparser.alexdevyatov.chesscomparser.model.Player

object Dao {
    fun loadAllCountries() : List<Country> {
        return Select().from(Country::class.java).orderBy("name").execute()
    }

    fun loadPlayersByCountry(countryCode: String?) : List<Player> {
        return Select().from(Player::class.java).where("country = ?", countryCode).execute()
    }

    fun getPlayersCountByCountry(countryCode : String?) : Int {
        return Select().from(Player::class.java).where("country = ?", countryCode).count()
    }

    fun getPlayer(nickname: String?) : Player {
        return Select().from(Player::class.java).where("nickname = ?", nickname).executeSingle()
    }

    fun deletePlayer(nickname: String?) {
        Delete().from(Player::class.java).where("nickname = ?", nickname).execute<Player>()
    }
}