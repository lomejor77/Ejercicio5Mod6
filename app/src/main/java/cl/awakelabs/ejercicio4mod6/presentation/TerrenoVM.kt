package cl.awakelabs.ejercicio4mod6.presentation
/**
 * Esto es el repositorio: se relaciona con el repositorio a traves de una instancia
 * */
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.ejercicio4mod6.Repository
import cl.awakelabs.ejercicio4mod6.data.remote.Terreno
import cl.awakelabs.ejercicio4mod6.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {

  private val repository: Repository
  val terrenoLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetroFitClient()
        repository = Repository(api)
    }
    /**
     * viewModelScope.launch lanza corutina
     * crear livedata
     */
    fun getAllTerrenos() = viewModelScope.launch {
        terrenoLiveData.value = repository.cargarTerreno()

    }

}