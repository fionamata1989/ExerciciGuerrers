package com.mataecheverry.exerciciguerrers.dades

import kotlin.random.Random

data class Arma(
    val id: String,
    val nom: String,
    val foto: String,
    val cadencia: Int,
    val projectil: Int,
    val historia: String,

)

class Armes{
    companion object {
        private fun generaArma(id: Int): Arma {
            return Arma(
                id = id.toString(),
                nom = armaRandom(),
                foto = "https://loremflickr.com/300/300/plants?lock=$id",
                cadencia = Random.nextInt(100),
                projectil = Random.nextInt(100),
                historia= "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        }

        val dadesArmes = (0..100).toList().map { generaArma(it) };
    }
}

fun armaRandom(): String {

    val arma = listOf(
        "Glock-18",
        "USP-S",
        "P2000",
        "Dual Berettas",
        "P250",
        "Five-SeveN",
        "CZ75-Auto",
        "Tec-9",
        "Desert Eagle",
        "Nova",
        "XM1014",
        "Sawed-Off",
        "Mag-7",
        "MP9",
        "MP7",
        "UMP-45",
        "P90",
        "MAC-10",
        "AK-47",
        "M4A4",
        "M4A1-S",
        "SG 553",
        "AUG",
        "AWP",
        "SSG 08",
        "G3SG1",
        "SCAR-20",
        "M249",
        "Negev"
    )
    var nom = arma.random()
    return nom
}
