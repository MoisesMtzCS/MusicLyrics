package cs.med.mtz.moises.musiclyrics.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cs.med.mtz.moises.musiclyrics.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    /* */

    private val binding by lazy {FragmentHomeBinding.inflate(layoutInflater) }

    /** */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

}