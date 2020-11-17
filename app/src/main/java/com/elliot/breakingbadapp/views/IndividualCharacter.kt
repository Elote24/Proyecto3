package com.elliot.breakingbadapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        //Inflar la actividad
        val binding:ActivityIndividualCharacterBinding= DataBindingUtil.setContentView(this,R.layout.activity_individual_character)

        val Name= intent.extras?.getString("name")
        Log.d("Name",Name!!)


        IndividualCharacterViewModel.characterLiveData.observe(this,
            Observer<Character> { character ->
                binding.character = character
                binding.executePendingBindings()
            }
        )

        IndividualCharacterViewModel.getCharacter(Name)


    }
}