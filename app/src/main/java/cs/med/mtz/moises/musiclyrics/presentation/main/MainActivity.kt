package cs.med.mtz.moises.musiclyrics.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cs.med.mtz.moises.musiclyrics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /* */
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}