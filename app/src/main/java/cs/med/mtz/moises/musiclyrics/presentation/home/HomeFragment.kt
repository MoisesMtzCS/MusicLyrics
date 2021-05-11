package cs.med.mtz.moises.musiclyrics.presentation.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.lyrics.domain.entity.Song
import cs.med.mtz.moises.musiclyrics.R
import cs.med.mtz.moises.musiclyrics.databinding.FragmentHomeBinding
import cs.med.mtz.moises.musiclyrics.presentation.home.adapter.SongAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    /* */
    private lateinit var loaderDialog: Dialog

    /* */
    private val homeViewModel: HomeViewModel by viewModel()

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
        execute()
    }

    /** */
    private fun execute() {
        loadCSongsList()
    }

    /** */
    private fun loadCSongsList() {
        binding.searchButton.setOnClickListener {
            if (value.isNotBlank()) {
                showLoader()
                homeViewModel.getSongsLiveData(value)
                    .observe(viewLifecycleOwner) { songs ->
                        hideLoader()
                        fillRecyclerView(songs)
                    }
            } else alert()
        }
    }

    /** */
    private fun fillRecyclerView(songs: List<Song>) {
        val songAdapter = SongAdapter(songs, ::onSongClickListener)
        binding.rvSongs.adapter = songAdapter
        binding.rvSongs.layoutManager = LinearLayoutManager(this.context)
    }

    /** */
    private fun onSongClickListener(song: Song) {
        val title = song.title
        val artist = song.artist
        val image = song.imageUrl
        val direction = HomeFragmentDirections
            .actionHomeToLyricsDetailsFragment(title, artist, image)
        findNavController().navigate(direction)
    }

    /** */
    private fun showLoader() {
        loaderDialog = AlertDialog.Builder(this.context, R.style.MyDialog)
            .setView(R.layout.loading)
            .setCancelable(false)
            .create()
        loaderDialog.show()
    }

    /** */
    private fun hideLoader() {
        loaderDialog.dismiss()
    }

    /** */
    private fun alert() {
        AlertDialog.Builder(this.context)
            .setTitle(getString(R.string.empty))
            .setPositiveButton("aceptar", null)
            .create()
            .show()
    }

}