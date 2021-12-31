package ar.com.example.alkemymovieapp.ui.watched

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.com.example.alkemymovieapp.R
import ar.com.example.alkemymovieapp.core.Resource
import ar.com.example.alkemymovieapp.data.models.MovieEntity
import ar.com.example.alkemymovieapp.databinding.FragmentWatchedBinding
import ar.com.example.alkemymovieapp.presentation.LocalViewModel
import ar.com.example.alkemymovieapp.ui.adapters.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchedFragment : Fragment(R.layout.fragment_watched), MovieAdapter.OnClick {

    private lateinit var binding: FragmentWatchedBinding
    private val viewModel by viewModels<LocalViewModel>()
    private val movieAdapter by lazy { MovieAdapter(this) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWatchedBinding.bind(view)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.fetchViewedMovies().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading ->{}
                is Resource.Success ->{
                    val movieList = it.data
                    setupRecyclerView(movieList)
                }
                is Resource.Failure ->{}
            }
        }
    }

    private fun setupRecyclerView(movieList: List<MovieEntity>) {
        binding.rvFavorites.adapter = movieAdapter
        movieAdapter.setMovieData(movieList)
        setupSizes()
    }

    private fun setupSizes() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // landscape
            binding.rvFavorites.layoutManager = object : GridLayoutManager(requireContext(), 6) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {

                    lp.height = ((height / 3) * 2)
                    lp.width = width / 6

                    return true
                }
            }
        } else {
            // portrait
            binding.rvFavorites.layoutManager = object : GridLayoutManager(requireContext(), 2) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                    lp.width = width / 2
                    lp.height = height / 2
                    return true
                }
            }
        }
    }

    override fun onMovieClick(movieEntity: MovieEntity) {
        val action = WatchedFragmentDirections.actionWatchedFragmentToDetailFragment(movieEntity.id)
        findNavController().navigate(action)
    }
}