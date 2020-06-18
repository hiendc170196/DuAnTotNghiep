package com.dinhconghien.getitapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dinhconghien.getitapp.Models.BrandLapName
import com.dinhconghien.getitapp.R
import com.dinhconghien.getitapp.Screens.ListLaptop.ListLaptopActivity

class BrandLapName_Adapter(val context: Context , val listBrandLapName : ArrayList<BrandLapName>) : RecyclerView.Adapter<BrandLapName_Adapter.ViewHolder>() {
    lateinit var myContext: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflate: View = LayoutInflater.from(context).inflate(R.layout.item_brandlaptop, null)
        myContext = parent.context
        return ViewHolder(inflate)
    }


    override fun getItemCount(): Int {
        return listBrandLapName.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val brandLap = listBrandLapName.get(position)
         holder.tv_brandNameLap.text = brandLap.brandLapName
         Glide.with(holder.itemView)
             .load(brandLap.avatarBrandLapName)
             .fitCenter()
             .into(holder.imv_avatarBrandLap)

        holder.itemView.setOnClickListener {
            val intent = Intent(myContext,ListLaptopActivity::class.java)
            intent.putExtra("brandLapName", brandLap.brandLapName)
            myContext.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imv_avatarBrandLap : ImageView = itemView.findViewById(R.id.imv_avatarBrand)
        val tv_brandNameLap : TextView = itemView.findViewById(R.id.tv_brandLaptopName)
    }
}