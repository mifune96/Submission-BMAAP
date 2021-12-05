package com.tomuchcoffee.submissionbmaap

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tomuchcoffee.submissionbmaap.databinding.ItemCharactresBinding

class CharactersAdapter(val listChacter: ArrayList<Characters>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolde>() {
    inner class ViewHolde(val binding: ItemCharactresBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolde {
        return ViewHolde(
            ItemCharactresBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolde, position: Int) {
        with(holder) {
            with(listChacter[position]) {
                val contex = itemView.context
                binding.tvName.text = this.name
                binding.tvCharacterinfo.text = this.info
                Glide.with(contex)
                    .load(this.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(binding.ivCharackters)


                itemView.setOnClickListener {
                    val intentDetail = Intent(contex, DetailActivity::class.java)
                    intentDetail.putExtra(DetailActivity.CHAR_NAME, this.name)
                    intentDetail.putExtra(DetailActivity.CHAR_DETAIL, this.info)
                    intentDetail.putExtra(DetailActivity.CHAR_SWORDSMANSHIP, this.Swordsmanship)
                    intentDetail.putExtra(DetailActivity.CHAR_PHOTO, this.photo.toString())
                    contex.startActivities(arrayOf(intentDetail))
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listChacter.size
    }

}