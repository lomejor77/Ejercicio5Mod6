package cl.awakelabs.ejercicio4mod6.data.remote

/**
 * POJO guarda la informacion
 */
data class Terreno(
    val id: String,
    val price: Int,
    val type: String,
    val img_src: String
)
/*
@SerializedName() setea el nombre que proviene de JSON
* */