package com.chesscomparser.alexdevyatov.chesscomparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.activeandroid.ActiveAndroid
import com.chesscomparser.alexdevyatov.chesscomparser.dao.CountryDao
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = CountryDao.loadAllCountries()
        tv_hello_world.text = list.size.toString()
    }
}
