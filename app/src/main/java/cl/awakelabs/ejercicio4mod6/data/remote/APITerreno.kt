package cl.awakelabs.ejercicio4mod6.data.remote

/**
 * Esto seria la interfaz
 */
import okhttp3.Response
import retrofit2.http.GET

interface APITerreno {
    @GET("realestate")

   suspend fun getData(): retrofit2.Response<List<Terreno>>
}