package cs.med.mtz.moises.musiclyrics

import android.app.Application
import cs.med.mtz.moises.musiclyrics.di.getApplicationModules
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MusicLyricsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(getApplicationModules())
        }
    }

}