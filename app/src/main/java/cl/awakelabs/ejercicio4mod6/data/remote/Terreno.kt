package cl.awakelabs.ejercicio4mod6.data.remote

data class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    val buy: String
)
/*
@SerializedName() setea el nombre que proviene de JSON
* */