package com.elliot.breakingbadapp.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.adapters.CategoryAdapter
import com.elliot.breakingbadapp.adapters.CharacterAdapter
import com.elliot.breakingbadapp.databinding.ActivityCategoryCharacterBinding
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.viewmodels.CategoryCharacterViewModel

class CategoryCharacterActivity : AppCompatActivity() {
    val CategoryCharacterViewModel : CategoryCharacterViewModel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityCategoryCharacterBinding=DataBindingUtil.setContentView(this,R.layout.activity_category_character)

        val category= intent.extras?.getString("category")


        val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewDcategory)
        val categoryAdapter = CategoryAdapter()

        recyclerViewData.layoutManager = LinearLayoutManager(this)
        recyclerViewData.adapter = categoryAdapter


        CategoryCharacterViewModel.listCharacterLiveData.observe(this,
            Observer<List<Character>> {
                categoryAdapter.addResults(it)
                binding.textView.text = category
                binding.executePendingBindings()
                categoryAdapter.notifyDataSetChanged()
            })

        CategoryCharacterViewModel.getCharactersByCategory(category!!)
    }
}
