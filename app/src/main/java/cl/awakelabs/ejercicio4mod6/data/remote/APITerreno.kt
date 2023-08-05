package cl.awakelabs.ejercicio4mod6.data.remote

import okhttp3.Response
import retrofit2.http.GET

interface APITerreno {
    @GET("realestate")

   suspend fun getData(): retrofit2.Response<List<Terreno>>
}