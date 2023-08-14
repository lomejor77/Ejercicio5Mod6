package cl.awakelabs.ejercicio4mod6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Cliente RetroFit
 */
class TerrenoRetroFit {
    companion object{
        private const val URL_BASE = "https://android-kotlin-fun-mars-server.appspot.com/"
        fun getRetroFitClient() : APITerreno {
            val mRetroFit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetroFit.create(APITerreno::class.java)
        }
    }
}