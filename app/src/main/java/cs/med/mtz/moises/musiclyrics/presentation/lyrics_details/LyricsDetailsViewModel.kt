package cs.med.mtz.moises.musiclyrics.presentation.lyrics_details

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.musiclyrics.data.api.ApiService
import cs.med.mtz.moises.musiclyrics.data.http_client.retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class LyricsDetailsViewModel : ViewModel() {

    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)


    fun getLyricsLiveData(nameArtist: String, nameSong: String): LiveData<String> = flow {
        try {
            val response = service.getLyricSong(nameArtist, nameSong)
            val lyrics: String = response.lyrics
            emit(lyrics)
        } catch (exception: Exception) {
        }
    }.asLiveData(Dispatchers.IO)
}