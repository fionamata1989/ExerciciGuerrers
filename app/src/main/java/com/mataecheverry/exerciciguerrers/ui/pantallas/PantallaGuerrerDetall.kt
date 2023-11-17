package com.mataecheverry.exerciciguerrers.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mataecheverry.exerciciguerrers.R
import com.mataecheverry.exerciciguerrers.dades.Guerrers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaGuerrerDetall(id: String, onPopUpToClick: () -> Unit){
    val num = id.toInt()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text("Detalls de ${Guerrers.dades[num].nom}")
                },
                navigationIcon = {
                    IconButton(onClick = onPopUpToClick)
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Vista detallada"
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.loremflickr.com/300/300/guerrer?lock=${Guerrers.dades[num].id}")
                .crossfade(true)
                .build(),
                placeholder=painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier

                    .weight(0.3F)
                    .clip(CircleShape)
                    .padding(10.dp)
            )
            Text(text = "Nom: ${Guerrers.dades[num].nom}, ${Guerrers.dades[num].edat}",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.3F),
                )

            Divider(thickness = 2.dp,
                color = MaterialTheme.colorScheme.onBackground)

            Text(text = "Força: ${Guerrers.dades[num].forsa}\n" +
                    "Resistencia: ${Guerrers.dades[num].resistencia}\nAtac: ${Guerrers.dades[num].atac}\nDefensa: ${Guerrers.dades[num].defensa}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                    .weight(0.3F))
        }
    }
}
