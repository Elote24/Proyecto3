package com.elliot.breakingbadapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.viewModelScope
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.models.CharacterView
import com.elliot.breakingbadapp.repositories.BreakingBadRepository
import kotlinx.coroutines.launch


class MainActivityViewModel (application: Application) : AndroidViewModel(application) {
    private val breakingBadRepository = BreakingBadRepository();
    val listCharacterLiveData =MutableLiveData<List<Character>>()

    fun getCharacters() {
        viewModelScope.launch {
            listCharacterLiveData.postValue(breakingBadRepository.getCharacters())
        }
    }

}