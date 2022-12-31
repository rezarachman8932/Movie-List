package com.app.movielistapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.movielistapp.R
import com.app.movielistapp.shared.constant.CommonConstant
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayer : AppCompatActivity() {

    private var trailer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        receiveParameter()

        lifecycle.addObserver(youtube_player_dialog)

        youtube_player_dialog.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                super.onReady(youTubePlayer)
                youTubePlayer.loadVideo(trailer, 0f)
            }
        })
        ll_media_player_back_icon.setOnClickListener { onBackPressed() }
    }

    private fun receiveParameter() {
        val trailer = intent.extras?.getString(CommonConstant.MEDIA_PLAYER)
        if (!trailer.isNullOrEmpty()) this.trailer = trailer
    }
}