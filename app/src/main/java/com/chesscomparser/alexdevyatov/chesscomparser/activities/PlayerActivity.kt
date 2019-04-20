package com.chesscomparser.alexdevyatov.chesscomparser.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.chesscomparser.alexdevyatov.chesscomparser.R
import com.chesscomparser.alexdevyatov.chesscomparser.dao.Dao
import com.facebook.drawee.view.SimpleDraweeView
import java.lang.Exception

class PlayerActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context, nickname: String?) : Intent {
            val intent = Intent(context, PlayerActivity::class.java)
            intent.putExtra("nickname", nickname)
            return intent
        }
    }

    var ivAvatar: SimpleDraweeView? = null
    var tvPlayerName: TextView? = null
    var tvPlayerLocation: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        ivAvatar = findViewById(R.id.iv_avatar)
        tvPlayerName = findViewById(R.id.tv_player_name)
        tvPlayerLocation = findViewById(R.id.tv_player_location)

        try {
            val nickname = intent.getStringExtra("nickname")
            title = nickname
            val player = Dao.getPlayer(nickname)
            tvPlayerName?.let {
                it.text = player.name
            }
            tvPlayerLocation?.let {
                it.text = player.location
            }

            if (!player.avatarUrl.isNullOrEmpty()) {
                ivAvatar?.let {
                    it.setImageURI(player.avatarUrl)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
