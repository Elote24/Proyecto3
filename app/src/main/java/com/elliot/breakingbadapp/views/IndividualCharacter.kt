package com.elliot.breakingbadapp.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.databinding.ActivityIndividualCharacterBinding
import com.elliot.breakingbadapp.databinding.CardCharacterBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.CharacterView
import com.elliot.breakingbadapp.viewmodels.IndividualCharacterActivityViewModel

class IndividualCharacter : AppCompatActivity() {
    val IndividualCharacterViewModel : IndividualCharacterActivityViewModel by viewModels()

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflar la actividad
        val binding:ActivityIndividualCharacterBinding= DataBindingUtil.setContentView(this,R.layout.activity_individual_character)


        val character= intent.getParcelableExtra<Character>("Personaje")


                binding.character = character
                binding.executePendingBindings()



    }
}