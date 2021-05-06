package cs.med.mtz.moises.musiclyrics.presentation.lyrics_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import cs.med.mtz.moises.musiclyrics.databinding.FragmentLyricsDetailsBinding

/** */
class LyricsDetailsFragment : Fragment() {

    /* */
    lateinit var lyricsDetailsViewModel: LyricsDetailsViewModel


    /* */
    private val binding by lazy { FragmentLyricsDetailsBinding.inflate(layoutInflater) }

    /* */
    private val args: LyricsDetailsFragmentArgs by navArgs()

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    /** */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lyricsDetailsViewModel = LyricsDetailsViewModel()
        setupViews()

    }

    /** */
    private fun setupViews() {
        showLyrics()
        binding.tvTitle.text = args.title
        binding.tvArtist.text = args.artist

        Glide.with(this)
            .load(args.imageurl)
            .into(binding.ivAlbum)
    }

    private fun showLyrics() {
        lyricsDetailsViewModel.getLyricsLiveData(args.artist, args.title)
            .observe(viewLifecycleOwner) {
                binding.tvLyrics.text = it

            }

    }
}