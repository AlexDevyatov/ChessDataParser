package com.chesscomparser.alexdevyatov.chesscomparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.activeandroid.ActiveAndroid
import com.chesscomparser.alexdevyatov.chesscomparser.adapters.CountriesListAdapter
import com.chesscomparser.alexdevyatov.chesscomparser.dao.CountryDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = CountryDao.loadAllCountries()
        rv_countries_list.layoutManager = LinearLayoutManager(this)
        rv_countries_list.adapter = CountriesListAdapter(list)
    }
}
