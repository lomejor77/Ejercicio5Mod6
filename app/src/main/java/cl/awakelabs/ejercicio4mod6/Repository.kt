package cl.awakelabs.ejercicio4mod6
/**
 * response = respuesta
 * */
import androidx.lifecycle.LiveData
import cl.awakelabs.ejercicio4mod6.data.local.TerrenoDAO
import cl.awakelabs.ejercicio4mod6.data.local.TerrenoEntity
import cl.awakelabs.ejercicio4mod6.data.remote.APITerreno
import cl.awakelabs.ejercicio4mod6.data.remote.Terreno

class Repository(private val apiTerreno: APITerreno, private val terrenoDAO: TerrenoDAO) {

    fun obtainTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDAO.getAllTerrenos()//getTerrenos= nombre que viene de la funciondel query en DAO
    suspend fun getTerrenos() {

        val respuesta = apiTerreno.getData()

        if (respuesta.isSuccessful){
            val resp = respuesta.body()
            resp?.let {terrenos ->
                val terrenosEntity = terrenos.map { it.transform() }
                terrenoDAO.insertTerrenos(terrenosEntity)
            }
        }
    }
    fun obtainIdTerreno(id: String): LiveData<TerrenoEntity> = terrenoDAO.getIdTerreno(id)
    fun Terreno.transform(): TerrenoEntity = TerrenoEntity(this.id, this.price, this.type, this.img_src)
}

/**
 * toma un terreno y lo transforma en entidad
 * */


