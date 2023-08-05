package cl.awakelabs.ejercicio4mod6
/**
 * response = respuesta
 * */
import cl.awakelabs.ejercicio4mod6.data.remote.APITerreno
import cl.awakelabs.ejercicio4mod6.data.remote.Terreno

class Repository(private val apiTerreno: APITerreno) {
    suspend fun cargarTerreno(): List<Terreno>{

        val respuesta = apiTerreno.getData()

        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}