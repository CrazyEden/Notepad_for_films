package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FrameFilmBinding
import com.google.android.material.internal.ParcelableSparseArray

class FilmAdapter:RecyclerView.Adapter<FilmAdapter.FilmHolder>() {
    val filmList = ArrayList<Film>()

    class FilmHolder(item: View):RecyclerView.ViewHolder(item){
        val bindC=FrameFilmBinding.bind(item)
        fun bind(film:Film){
            bindC.imageView.setImageURI(film.uri_string.toUri())
            bindC.textView.text=film.title
            bindC.rateView.text=film.rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.frame_film,parent,false)
        return FilmHolder(view)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(filmList[position])
    }

    override fun getItemCount(): Int {
        return filmList.size
    }
    fun addFilm(film:Film){
        filmList.add(film)
        notifyDataSetChanged()
    }
}