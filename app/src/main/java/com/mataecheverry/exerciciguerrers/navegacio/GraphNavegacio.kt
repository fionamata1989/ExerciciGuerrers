package com.mataecheverry.exerciciguerrers.navegacio

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaArmaDetall
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaGuerrerDetall
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaLlistaDArmes
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaLlistaDeGuerrers
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaLlistaDePlantes
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaMinimMaxim
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaPlantaDetall
import com.mataecheverry.exerciciguerrers.ui.pantallas.PantallaPrincipal



@Composable
fun GrafDeNavegacio(){

    val controladorDeNavegacio = rememberNavController()
    NavHost(navController = controladorDeNavegacio , startDestination = Destinacio.Principal.rutaGenerica)
    {
        composable(
            route=Destinacio.Principal.rutaGenerica
        ){
            PantallaPrincipal(
                //Els botons que ajuden a navegar:
                onLlistaDePlantesClick = {
                    controladorDeNavegacio.navigate(Destinacio.LlistaDePlantes.rutaGenerica)
                },
                onLlistaDeGuerrersClick = {
                    controladorDeNavegacio.navigate(Destinacio.LlistaDeGuerrers.rutaGenerica)
                },
                onLlistaArmesClick = {
                    controladorDeNavegacio.navigate(Destinacio.LlistaDArmes.rutaGenerica)
                }
            )
        }

        //region guerrers
        composable(
            route=Destinacio.LlistaDeGuerrers.rutaGenerica,
            arguments = Destinacio.LlistaDeGuerrers.navArgs
        ){
            //Recuperem els paràmetres:
            val titol = it.arguments?.getString(ArgumentDeNavegacio.Titol.clau)
            requireNotNull(titol)

            PantallaLlistaDeGuerrers(titol,
                onGuerrerClick = {guerrerId: String -> controladorDeNavegacio.navigate(Destinacio.DetallGuerrer.creaRutaEspecifica(guerrerId))},
                onPopUpToClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.DetallGuerrer.rutaGenerica,
            arguments = Destinacio.DetallGuerrer.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.Detall.clau)
            requireNotNull(id)

            PantallaGuerrerDetall(id, onPopUpToClick = {controladorDeNavegacio.navigateUp()})
        }
        //endregion

        //region plantes
        composable (
            route=Destinacio.LlistaDePlantes.rutaGenerica,
            arguments = Destinacio.LlistaDePlantes.navArgs){
            val planta = it.arguments?.getString(ArgumentDeNavegacio.Planta.clau)
            requireNotNull(planta)

            PantallaLlistaDePlantes(planta,
                onPlantaClick={plantaId: String -> controladorDeNavegacio.navigate(Destinacio.DetallPlanta.creaRutaEspecifica(plantaId))},
                onPopUpToClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.DetallPlanta.rutaGenerica,
            arguments = Destinacio.DetallPlanta.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.DetallPlanta.clau)
            requireNotNull(id)

            PantallaPlantaDetall(id, onPopUpToClick = {controladorDeNavegacio.navigateUp()})
        }
        //endregion

        //region armes
        composable (
            route=Destinacio.LlistaDArmes.rutaGenerica,
            arguments = Destinacio.LlistaDArmes.navArgs){
            val arma = it.arguments?.getString(ArgumentDeNavegacio.Arma.clau)
            requireNotNull(arma)

            PantallaLlistaDArmes(arma,
                onArmaClick={ armaId: String -> controladorDeNavegacio.navigate(Destinacio.DetallArma.creaRutaEspecifica(armaId))},
                onPopUpToClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.DetallArma.rutaGenerica,
            arguments = Destinacio.DetallArma.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.DetallArma.clau)
            requireNotNull(id)

            PantallaArmaDetall(id, onPopUpToClick = {controladorDeNavegacio.navigateUp()})
        }

        //endregion

    }
}

