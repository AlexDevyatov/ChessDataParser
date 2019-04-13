package com.chesscomparser.alexdevyatov.chesscomparser.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table

@Table(name = "players", id = "_id")
class Player : Model {

    @Column(name = "country")
    var countryCode: String? = null
    @Column(name = "nickname")
    var nickname: String? = null

    constructor()
}