package com.mataecheverry.exerciciguerrers.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.titleContentColor
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mataecheverry.exerciciguerrers.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(onLlistaDeGuerrersClick: () -> Unit, onLlistaDePlantesClick: () -> Unit, onLlistaArmesClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text("Menú de llistes")
                },
                navigationIcon = {
                    IconButton(onClick = {})
                    {
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = "Vista detallada"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ) {
                Image(
                    painter = painterResource(id= R.drawable.calendario),
                    contentDescription = "Imatge",
                )
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Button(modifier = Modifier
                    .align(Alignment.Center),
                    onClick = { onLlistaArmesClick()})
                {
                    Text("Llista d'Armes", fontSize = 25.sp,)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Button(modifier = Modifier
                    .align(Alignment.Center),
                    onClick = { onLlistaDePlantesClick()})
                {
                    Text("Llista de Plantes", fontSize = 25.sp,)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F)
            ) {
                Button(modifier = Modifier
                    .align(Alignment.Center),
                    onClick = { onLlistaDeGuerrersClick() })
                {
                    Text("Llista de Guerrers", fontSize = 25.sp,)
                }
            }
        }
    }
}