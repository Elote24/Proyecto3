package com.elliot.breakingbadapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.databinding.CardCharacterBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.CharacterView
import com.elliot.breakingbadapp.views.IndividualCharacter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.card_character.view.*


class CharacterAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val listCharacters = mutableListOf<Character>()


    fun addResults(data: List<Character>) {
        listCharacters.addAll(data);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardBinding = CardCharacterBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CharacterViewHolder){
            val characterView = listCharacters[position]
            holder.onBind(characterView)


            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, IndividualCharacter::class.java)
                intent.putExtra("name",characterView.name)
                holder.itemView.context.startActivity(intent)
            }
        }

    }
    override fun getItemCount(): Int {
        return listCharacters.size
    }

    inner class CharacterViewHolder(private val cardCharacterBinding: CardCharacterBinding) : RecyclerView.ViewHolder(cardCharacterBinding.root) {

        fun onBind(characterView: Character) {
            cardCharacterBinding.character = characterView
            cardCharacterBinding.executePendingBindings()
        }

    }
}