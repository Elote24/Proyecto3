package com.elliot.breakingbadapp.views

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.elliot.breakingbadapp.R
import com.elliot.breakingbadapp.adapters.CharacterAdapter
import com.elliot.breakingbadapp.models.Character
import com.elliot.breakingbadapp.viewmodels.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}

@BindingAdapter("statusColor")
fun changeColorFromStatus(textView: TextView, status: String) {
    when (status) {
        "Alive" -> {
            textView.setTextColor(Color.GREEN)
        }
        "Dead" -> {
            textView.setTextColor(Color.RED)
        }
        else -> {
            textView.setTextColor(Color.GRAY)
        }
    }
}

class MainActivity : AppCompatActivity() {
    val mainActivityViewModel : MainActivityViewModel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabver = findViewById<FloatingActionButton>(R.id.fabActionQuote)

        fabver.setOnClickListener {
            val intent = Intent(this, QuotesActivity::class.java)
            startActivity(intent)
        }


        val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewData)
        val characterAdapter = CharacterAdapter()

        recyclerViewData.layoutManager = LinearLayoutManager(this)
        recyclerViewData.adapter = characterAdapter



        mainActivityViewModel.listCharacterLiveData.observe(this,
            Observer<List<Character>> {
                characterAdapter.addResults(it)
                characterAdapter.notifyDataSetChanged()
            })


                    mainActivityViewModel.getCharacters()
    }
}