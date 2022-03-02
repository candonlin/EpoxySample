package com.denny.epoxy_sample.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.denny.epoxy_sample.adapter.MovieLandscapeController
import com.denny.epoxy_sample.databinding.ActivityMainBinding
import com.denny.epoxy_sample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        viewModel =
            ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        var controller = MovieLandscapeController()
        binding.recyclerView.adapter = controller.adapter
        binding.recyclerView.invalidateItemDecorations()
        viewModel.popularList
            .observe(this, Observer {
                controller.setData(it)
            })

//        binding.recyclerView.addGlidePreloader(
//            Glide.with(this),
//            preloader = glidePreloader { requestManager, epoxyModel: MovieLandHolderBindingModel_, viewData ->
//            }
//        )

//        viewModel.popularList.subsc

    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData() {
        viewModel.getData()
    }
}