package com.elliot.breakingbadapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.databinding.CardCharacterBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.views.CategoryCharacterActivity
import com.elliot.breakingbadapp.views.IndividualCharacter
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

            holder.itemView.imageViewProfile.setOnClickListener{
                var intent = Intent(it.context,IndividualCharacter::class.java)
                intent.putExtra("PersonajeN",characterView)
                it.context.startActivity(intent)
            }
            holder.itemView.textViewCategoryCharacter.setOnClickListener{
                var intent = Intent(it.context,CategoryCharacterActivity::class.java)
                intent.putExtra("category",characterView.category)
                it.context.startActivity(intent)
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
