package com.mataecheverry.exerciciguerrers.ui.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun PantallaMinimMaxim(minim: Int, maxim: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().weight(1F)){
            Text(text = minim.toString(), fontSize = 88.sp,
                modifier = Modifier
                    .align(Alignment.Center))
        }

        Box(modifier = Modifier.fillMaxWidth().weight(1F)){
            Text(text = maxim.toString(), fontSize = 88.sp,
                modifier = Modifier
                    .align(Alignment.Center))
        }
    }
}