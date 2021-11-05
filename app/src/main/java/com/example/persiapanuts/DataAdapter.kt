package com.example.persiapanuts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class DataAdapter(val data: List<DataModel>?, val itemClick: OnClickListener) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    //Override fun didapatkan dari implement member
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {

        //item_list merupakan layout yang kita tambahkan
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = data?.get(position)
        holder.setData(item)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(item: DataModel?) {
            //Pada list kita tidak menampilkan keterangan
            itemView.imageViewDetail.setImageResource(item?.gambar ?: R.drawable.icon)
            itemView.textViewJudul.text = item?.judul
            itemView.imageViewRumus.setImageResource(item?.rumus ?: R.drawable.icon)

            itemView.setOnClickListener {
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail (item: DataModel?)
    }
}