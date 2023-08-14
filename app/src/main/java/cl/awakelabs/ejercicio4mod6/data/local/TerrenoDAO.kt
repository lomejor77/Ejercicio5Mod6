package cl.awakelabs.ejercicio4mod6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao()
interface TerrenoDAO{

    @Insert
    suspend fun insertTerreno(terrenoEntity: TerrenoEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenos(terrenosEntity: List<TerrenoEntity>)

    @Query("SELECT * FROM tbl_terrenos ORDER BY id ASC")
    fun getAllTerrenos(): LiveData<List<TerrenoEntity>>

    //@Query("SELECT * FROM tbl_terrenos WHERE id = id")
    //fun getIdTerreno(id: String): LiveData<TerrenoEntity> //obtiene un elemento segun su id
}