package cl.awakelabs.ejercicio4mod6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.ejercicio4mod6.data.remote.Terreno
import cl.awakelabs.ejercicio4mod6.databinding.ItemTerrenoBinding
import coil.load
import kotlinx.coroutines.Job

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {
   lateinit var binding: ItemTerrenoBinding
   private val  listItemTerrenos = mutableListOf<Terreno>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listItemTerrenos.size

    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<Terreno>){
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }


    class ItemTerrenoViewHolder(private val v: ItemTerrenoBinding): RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: Terreno){
            v.imgTerreno.load(terreno.img_src)

        }
    }

}