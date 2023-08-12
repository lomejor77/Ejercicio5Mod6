package cl.awakelabs.ejercicio4mod6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TerrenoEntity::class], version = 1)
abstract class TerrenoDB : RoomDatabase() {
    abstract fun getTerrenoDao(): TerrenoDAO
    companion object {
        @Volatile
        private var INSTANCE: TerrenoDB? = null

        fun getDatabase(context: Context): TerrenoDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TerrenoDB::class.java,
                    "race_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }


}