package cs.med.mtz.moises.musiclyrics.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.lyrics.domain.entity.Song
import cs.med.mtz.moises.musiclyrics.databinding.FragmentHomeBinding
import cs.med.mtz.moises.musiclyrics.presentation.home.adapter.SongAdapter

class HomeFragment : Fragment() {

    /* */
    lateinit var homeViewModel: HomeViewModel

    /* */
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    /* */
    private val value: String
        get() = binding.etNameSong.text.toString()


    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = HomeViewModel()
        loadCSongsList()
    }

    /** */
    private fun loadCSongsList() {
        binding.searchButton.setOnClickListener {
            homeViewModel.getSongsLiveData(value)
                .observe(viewLifecycleOwner) { songs ->
                    fillRecyclerView(songs)
                }
        }
    }

    /** */
    private fun fillRecyclerView(songs: List<Song>) {
        val songAdapter = SongAdapter(songs)
        binding.rvSongs.adapter = songAdapter
        binding.rvSongs.layoutManager = LinearLayoutManager(this.context)
    }

}