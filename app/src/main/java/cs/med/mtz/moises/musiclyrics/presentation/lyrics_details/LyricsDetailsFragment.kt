package cs.med.mtz.moises.musiclyrics.presentation.lyrics_details

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import cs.med.mtz.moises.musiclyrics.R
import cs.med.mtz.moises.musiclyrics.databinding.FragmentLyricsDetailsBinding

/** */
class LyricsDetailsFragment : Fragment() {

    /* */
    lateinit var lyricsDetailsViewModel: LyricsDetailsViewModel

    private lateinit var dialog: AlertDialog

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
        execute()
    }

    /** */
    private fun setupViews() {
        binding.tvTitle.text = args.title
        binding.tvArtist.text = args.artist

        Glide.with(this)
            .load(args.imageurl)
            .into(binding.ivAlbum)
    }

    /** */
    private fun execute() {
        showAlert()
        showLyrics()
    }

    /** */
    private fun showLyrics() {
        lyricsDetailsViewModel.getLyricsLiveData(args.artist, args.title)
            .observe(viewLifecycleOwner) {
                hideAlert()
                binding.tvLyrics.text = when (it) {
                    LyricsDetailsViewModel.LyricsDetailsFailure.NOT_LYRICS_FOUND.name ->
                        "No se encontro una letra para esta cancion"
                    LyricsDetailsViewModel.LyricsDetailsFailure.NOT_INTERNET_CONNECTION.name ->
                        "No tienes conexion a internet"
                    LyricsDetailsViewModel.LyricsDetailsFailure.UNKNOWN_FAILURE.name ->
                        "Ocurrio un error, ve a checarte"
                    else -> it
                }
            }
    }

    /** */
    private fun showAlert() {
        val builder = AlertDialog.Builder(this.context)
            .setView(R.layout.loading)
            .setCancelable(false)
        dialog = builder.create()
        dialog.show()
    }

    /** */
    private fun hideAlert() {
        dialog.dismiss()
    }

}