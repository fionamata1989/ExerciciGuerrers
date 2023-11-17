package com.mataecheverry.exerciciguerrers.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mataecheverry.exerciciguerrers.R
import com.mataecheverry.exerciciguerrers.dades.Guerrer
import com.mataecheverry.exerciciguerrers.dades.Guerrers
import java.util.ArrayList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLlistaDeGuerrers(titol: String, onGuerrerClick: (String) -> Unit, onPopUpToClick: () -> Unit)  {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0XFFffdad3),
                    titleContentColor = Color(0XFF3e0400)
                ),
                title = {
                    Text("Llista de Guerrers")
                },
                navigationIcon = {
                    IconButton(onClick = onPopUpToClick)
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Llista de guerrers"
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .fillMaxSize())
        {
            item{
                Text(titol, fontSize = 25.sp)
            }
            items(Guerrers.dades){guerrer ->
                ItemGuerrer(guerrer = guerrer) { onGuerrerClick(guerrer.id) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemGuerrer(guerrer: Guerrer, onGuerrerClick: (String)-> Unit) {
    ElevatedCard(elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0XFFffdad3))
            .clickable { onGuerrerClick(guerrer.id)})
    {
        ListItem(
            leadingContent = {
                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.loremflickr.com/300/300/guerrer?lock=${guerrer.id}")
                .crossfade(true)
                .build(),
                placeholder=painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .padding(10.dp),
                )
            },
            headlineText = {Text("${guerrer.nom}, ${guerrer.edat}")},
            supportingText = {Text("ATK = ${guerrer.atac}, DEF = ${guerrer.defensa}")}
        )
    }
}
