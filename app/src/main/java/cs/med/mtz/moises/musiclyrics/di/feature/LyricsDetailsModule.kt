package cs.med.mtz.moises.musiclyrics.di.feature

import cs.med.mtz.moises.musiclyrics.presentation.home.HomeViewModel
import cs.med.mtz.moises.musiclyrics.presentation.lyrics_details.LyricsDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val lyricsDetailsModule: Module = module {
    viewModel {
        LyricsDetailsViewModel()
    }
}