package cs.med.mtz.moises.musiclyrics.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cs.med.mtz.moises.musiclyrics.R
import cs.med.mtz.moises.musiclyrics.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    /* */
    private val binding by lazy { FragmentSplashBinding.inflate(layoutInflater) }

    /** */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startFragmentSplash()
    }

    fun setupViews() {

    }

    private fun startFragmentSplash() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1200)
            findNavController().navigate(R.id.action_splash_to_home)

        }
    }
}