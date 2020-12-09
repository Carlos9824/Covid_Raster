package com.example.covid_raster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.paisitem.view.*


class PaisesAdapter(paises:ArrayList<Pais>,contexto:Context):RecyclerView.Adapter<PaisesAdapter.ViewHolder>() {

    var listaPaises:ArrayList<Pais>?=null
    var contexto:Context?=null

    init {
        this.listaPaises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var vistaPais:View = LayoutInflater.from(contexto).inflate(R.layout.paisitem,parent,false)
        var paisViewHolder = ViewHolder(vistaPais)
        vistaPais.tag = paisViewHolder
        return paisViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.nombrePais!!.text = listaPaises!![position].nombre
        holder.numeroConfirmados!!.text = "${listaPaises!![position].confirmados}"
        holder.numerosMuertos!!.text = "${listaPaises!![position].muertos}"
        holder.numerosRecuperados!!.text = "${listaPaises!![position].recuperados}"
        Picasso.get().load("https://www.countryflags.io/${listaPaises!![position].codigoPais}/flat/64.png").into(holder.bandera)
    }

    override fun getItemCount(): Int {
        return listaPaises!!.count()
    }

    class ViewHolder(vista:View):RecyclerView.ViewHolder(vista){
        var nombrePais:TextView?=null
        var numeroConfirmados:TextView?=null
        var numerosMuertos:TextView?=null
        var numerosRecuperados:TextView?=null
        var bandera:ImageView?=null

        init {
            nombrePais = vista.tvNombrePais
            numeroConfirmados = vista.tvConfirmados
            numerosMuertos = vista.tvMuertos
            numerosRecuperados = vista.tvRecuperados
            bandera = vista.idBandera
        }

    }
}