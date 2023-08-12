package cl.awakelabs.ejercicio4mod6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.ejercicio4mod6.R
import cl.awakelabs.ejercicio4mod6.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val terrenoVM: TerrenoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.btn.setOnClickListener {
            terrenoVM.getAllTerrenos()
        }

        return binding.root
    }

    private fun initAdapter() {
        //terrenoVM.getAllTerrenos()
        val adapter = AdapterTerreno()
        binding.recyclerView.adapter = adapter
        terrenoVM.terrenoLiveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

}