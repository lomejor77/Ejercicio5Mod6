package cl.awakelabs.ejercicio4mod6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao()
interface TerrenoDAO{

    @Insert
    suspend fun insertTerreno(terrenoEntity: TerrenoEntity)

    @Query("select * from tbl_terrenos order by id desc")
    fun getTerreno(): LiveData<List<TerrenoEntity>>
}