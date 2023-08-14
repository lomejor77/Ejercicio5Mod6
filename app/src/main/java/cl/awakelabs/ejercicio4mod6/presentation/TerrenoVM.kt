package cl.awakelabs.ejercicio4mod6.presentation
/**
 * Esto es el repositorio: se relaciona con el repositorio a traves de una instancia
 * */
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.ejercicio4mod6.Repository
import cl.awakelabs.ejercicio4mod6.data.local.TerrenoDAO
import cl.awakelabs.ejercicio4mod6.data.local.TerrenoDB
import cl.awakelabs.ejercicio4mod6.data.local.TerrenoEntity
import cl.awakelabs.ejercicio4mod6.data.remote.Terreno
import cl.awakelabs.ejercicio4mod6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {

  private val repository: Repository

  //val terrenosLiveData = MutableLiveData<List<TerrenoEntity>>()

    init {
        val api = TerrenoRetroFit.getRetroFitClient()
        val terrenoDataBase: TerrenoDAO = TerrenoDB.getDatabase(application).getTerrenoDao()
        repository = Repository(api, terrenoDataBase)
    }
    /**
     * viewModelScope.launch lanza corutina
     * crear livedata
     */
    fun getAllTerrenos() = viewModelScope.launch {repository.getTerrenos()  }
    fun terrenosLiveData() = repository.obtainTerrenos()



}