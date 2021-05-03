package cs.med.mtz.moises.musiclyrics.presentation

import android.app.Application
import cs.med.mtz.moises.musiclyrics.di.getApplicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MusicLyricsApplication: Application() {

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(getApplicationModules())
        }
    }

}