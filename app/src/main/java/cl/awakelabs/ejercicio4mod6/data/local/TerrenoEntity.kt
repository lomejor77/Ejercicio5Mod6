package cl.awakelabs.ejercicio4mod6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tbl_terrenos")
class TerrenoEntity(
    @PrimaryKey val id: String,
    val price: Int,
    val type: String,
    val img_src: String
)



