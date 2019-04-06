package com.chesscomparser.alexdevyatov.chesscomparser.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import com.activeandroid.annotation.Table

@Table(name = "countries", id = "_id")
class Country : Model {

    @Column(name = "code")
    var code: String? = null
    @Column(name = "name")
    var name: String? = null

    constructor()

    constructor(name: String?) {
        this.name = name
    }
}