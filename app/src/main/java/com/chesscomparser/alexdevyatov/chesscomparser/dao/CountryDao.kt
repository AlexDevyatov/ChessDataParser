package com.chesscomparser.alexdevyatov.chesscomparser.dao

import com.activeandroid.query.Select
import com.chesscomparser.alexdevyatov.chesscomparser.model.Country

object CountryDao {
    fun loadAllCountries() : List<Country> {
        return Select().from(Country::class.java).orderBy("name").execute()
    }
}