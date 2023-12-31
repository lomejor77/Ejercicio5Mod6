package cl.awakelabs.ejercicio4mod6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.ejercicio4mod6.databinding.FragmentDetailBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"
//private const val ARG_PARAM2 = "param2"

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val terrenoVM: TerrenoVM by activityViewModels()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    /*private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
            //param3 = it.getString(ARG_PARAM1)
            //param4 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        terrenoVM.idTerrenoLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.itemId.text = it.id
            binding.itemTitle.text = it.type
            binding.itemPrice.text = it.price.toString()
            binding.itemImage.load(it.img_src)
        }

        return binding.root
    }

}