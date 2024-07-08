package org.example.sharedemo

import App
import MainViewModel
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(viewModel)
            LaunchedEffect(Unit) {
                intent.extras?.let {
                    it.getParcelable<Uri>(Intent.EXTRA_STREAM)?.let { url ->
                        viewModel.setImage(url.toString())
                    }
                }
            }
        }
    }
}