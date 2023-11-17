package com.mataecheverry.exerciciguerrers.navegacio

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinacio (
    val rutaBase: String,                                                                                               //3  //98
    val argumentsDeNaveacio: List<ArgumentDeNavegacio> = emptyList())//Primera pantalla = "principal"; Segona = MinMax/{min}/{max}; tercera: llistaDeGuerres/{titol}
{
    //ruta amb paràmetres:
    val rutaGenerica = run{
        //Tenim un allista d'arguments, cada argument té una clau i un tipus. Ens referim a argumentDeNavegacio.clau
        val claus = argumentsDeNaveacio.map { "{${it.clau}}" }
        listOf(rutaBase)
            .plus(claus)
            .joinToString("/")
    }

    //map: per cada element de la llista, aplica el que es demana.
    val navArgs = argumentsDeNaveacio.map{it.toNavArgument()}


    //Definim les destinacions, és a dir, les pantalles:
    object Principal: Destinacio("Principal")

    object LlistaDeGuerrers: Destinacio("LlistaDeGerrers",
        listOf(ArgumentDeNavegacio.Titol)
    )
    { fun creaRutaEspecifica(titol: String)=
        "$rutaBase/$titol"
    }

    object DetallGuerrer : Destinacio("DetallGuerrer",
        listOf(ArgumentDeNavegacio.Detall))
    {
        fun creaRutaEspecifica(id: String) = "$rutaBase/$id"
    }

    object LlistaDePlantes: Destinacio("LlistaDePlantes",
        listOf(ArgumentDeNavegacio.Planta))
    {
        fun creaRutaEspecifica(planta: String) =
            "$rutaBase/$planta"
    }

    object DetallPlanta: Destinacio("DetallPlanta",
        listOf(ArgumentDeNavegacio.DetallPlanta))
    {
        fun creaRutaEspecifica(id: String)=
            "$rutaBase/$id"
    }

    object LlistaDArmes: Destinacio ("LlistaDArmes",
        listOf(ArgumentDeNavegacio.Arma))
    {
        fun creaRutaEspecifica(arma: String) =
            "$rutaBase/$arma"
    }

    object DetallArma: Destinacio("DetallArma",
        listOf(ArgumentDeNavegacio.DetallArma))
    {
        fun creaRutaEspecifica(id: String)=
            "$rutaBase/$id"
    }
}

//Definim tots els arguments que hi ha. Hem de poder dir quins arguments i tipus té.
enum class ArgumentDeNavegacio (
    val clau: String,
    val tipus: NavType<*>
) {
    Titol("Titol", NavType.StringType),
    Planta("PlantaTitol", NavType.StringType),
    Arma("ArmaTitol", NavType.StringType),
    Detall("Detall", NavType.StringType),
    DetallPlanta("DetallPlanta", NavType.StringType),
    DetallArma("DetallArma", NavType.StringType);


    //Format navArgs o argument de navegació per fer conversions:
    fun toNavArgument(): NamedNavArgument{
        return navArgument(clau){tipus}
    }
}