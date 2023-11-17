package com.mataecheverry.exerciciguerrers.dades

import kotlin.random.Random

data class Planta(
    val id: String,
    val nom: String,
    val foto: String,
    val nivellHumitat: Int,
    val llum: String,
    val temperatura: String,
    val mida: String,
    val rec: String,
    val fertilitzant: String

)

class Plantes{
    companion object {
        private fun generaPlanta(id: Int): Planta {
            return Planta(
                id = id.toString(),
                nom = plantaRandom(),
                foto = "https://loremflickr.com/300/300/plants?lock=$id",
                nivellHumitat = Random.nextInt(100),
                llum = "Llum clara i indirecta",
                temperatura = "15-38ºC",
                mida = "Alta",
                rec = "Un cop per setmana",
                fertilitzant = "Fertilitzant líquid cada dos setmanes.",
            )
        }

        val dadesPlanta = (0..100).toList().map { generaPlanta(it) };
    }
}

fun plantaRandom(): String {

    val planta = listOf(
        "Snake Plant (Sansevieria trifasciata)",
        "Spider Plant (Chlorophytum comosum)",
        "Peace Lily (Spathiphyllum)",
        "Fiddle Leaf Fig (Ficus lyrata)",
        "ZZ Plant (Zamioculcas zamiifolia)",
        "Rubber Plant (Ficus elastica)",
        "Pothos (Epipremnum aureum)",
        "Monstera Deliciosa",
        "Aloe Vera (Aloe barbadensis miller)",
        "Succulents (Various species)",
        "Chinese Evergreen (Aglaonema)",
        "Philodendron (Various species)",
        "Boston Fern (Nephrolepis exaltata)",
        "Parlor Palm (Chamaedorea elegans)",
        "Calathea (Various species)",
        "Jade Plant (Crassula ovata)",
        "African Violet (Saintpaulia)",
        "Bamboo Palm (Chamaedorea seifrizii)",
        "Cast Iron Plant (Aspidistra elatior)",
        "Devil's Ivy (Epipremnum aureum)",
        "Areca Palm (Dypsis lutescens)",
        "String of Pearls (Senecio rowleyanus)",
        "Bird of Paradise (Strelitzia reginae)",
        "ZZ Raven Plant (Zamioculcas zamiifolia 'Raven')",
        "Swiss Cheese Plant (Monstera adansonii)",
        "Spiderette Plant (Chlorophytum comosum 'Bonnie')",
        "Nerve Plant (Fittonia)",
        "Lucky Bamboo (Dracaena sanderiana)",
        "Majesty Palm (Ravenea rivularis)",
        "String of Hearts (Ceropegia woodii)",
        "Golden Pothos (Epipremnum aureum 'Marble Queen')",
        "Yucca Plant (Yucca elephantipes)",
        "Cactus (Various species)",
        "Elephant Ear Plant (Alocasia)",
        "Lipstick Plant (Aeschynanthus radicans)",
        "Pilea Peperomioides",
        "Begonia (Various species)",
        "Fern Arum (Nephrolepis exaltata 'Bostoniensis')",
        "Dieffenbachia (Dieffenbachia seguine)"
    )
    var nom = planta.random()
    return nom
}
