package com.elliot.breakingbadapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.databinding.ActivityIndividualCharacterBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.viewmodels.IndividualCharacterActivityViewModel




class IndividualCharacter : AppCompatActivity() {
    val IndividualCharacterViewModel : IndividualCharacterActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityIndividualCharacterBinding= DataBindingUtil.setContentView(this,R.layout.activity_individual_character)

        val name= intent.extras?.getString("name")

        IndividualCharacterViewModel.characterLiveData.observe(this,
            Observer<List<Character>> { character ->
                binding.character = character[0]
                binding.executePendingBindings()
            }
        )

        IndividualCharacterViewModel.getCharacterByName(name!!)

    }
}