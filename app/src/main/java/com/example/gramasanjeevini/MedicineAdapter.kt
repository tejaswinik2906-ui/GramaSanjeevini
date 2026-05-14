package com.example.gramasanjeevini

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicineAdapter(private var list: List<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.tvMedicineName)
        val shop: TextView = v.findViewById(R.id.tvShopName)
        val dist: TextView = v.findViewById(R.id.tvDistance)
        val badge: TextView = v.findViewById(R.id.badgeLifeSaving)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(h: ViewHolder, p: Int) {
        val m = list[p]
        h.name.text = m.name
        h.shop.text = m.shopName
        h.dist.text = "${m.distanceKm} km away"
        // Logic for the Red Badge requirement
        h.badge.visibility = if (m.isLifeSaving) View.VISIBLE else View.GONE
    }

    override fun getItemCount() = list.size

    fun update(newList: List<Medicine>) {
        list = newList
        notifyDataSetChanged()
    }
}