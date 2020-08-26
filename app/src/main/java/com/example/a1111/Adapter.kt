package com.example.a1111


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView


 class Adapter(var list: ArrayList<Osoba>): RecyclerView.Adapter<Adapter.OsobaViewHolder>() {
    inner class OsobaViewHolder(view: View): RecyclerView.ViewHolder(view) {
        inner class SwitchListener():CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                list.get(adapterPosition).switch = p1
            }

        }
        var deleteButton = view.findViewById<ImageButton>(R.id.delete)
        var image : ImageView? = null
        var switch: Switch = view.findViewById(R.id.switch1)
        lateinit var text: TextView
        init{
            deleteButton.setOnClickListener{_ ->delete()}
            switch.setOnCheckedChangeListener(SwitchListener())
//            versja1
//                switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener{_, b ->
//                         list.get(adapterPosition).switch = b
//                   })
//             versja2
//                switch.setOnCheckedChangeListener { compoundButton, b ->
//                    list.get(adapterPosition).switch = b
//                }
//             switch = view.findViewById(R.id.switch1)
            text = view.findViewById(R.id.textView4)
            image=view.findViewById(R.id.imageView)
        }
       private fun delete(){
           list.removeAt(adapterPosition)
           notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OsobaViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        v.layoutParams = RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
        return OsobaViewHolder(v)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: OsobaViewHolder, position: Int) {
    val osoba : Osoba = list.get(position)
        holder.text.text= osoba.imie
        holder.switch.isChecked = osoba.switch
    }
}