package cs.med.mtz.moises.musiclyrics.presentation.lyrics_details

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.musiclyrics.data.api.ApiService
import cs.med.mtz.moises.musiclyrics.data.http_client.retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.net.UnknownHostException

class LyricsDetailsViewModel : ViewModel() {

    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)


    fun getLyricsLiveData(nameArtist: String, nameSong: String): LiveData<String> = flow {
        try {
            val response = service.getLyricSong(nameArtist, nameSong)
            val lyrics: String = response.lyrics
            emit(lyrics)
        } catch (exception: Exception) {
            when(exception) {
                is HttpException -> {
                    if (exception.code() == 404)
                        emit(LyricsDetailsFailure.NOT_LYRICS_FOUND.name)
                    else emit(LyricsDetailsFailure.UNKNOWN_FAILURE.name)
                }
                is UnknownHostException ->
                    emit(LyricsDetailsFailure.NOT_INTERNET_CONNECTION.name)
                else -> emit(LyricsDetailsFailure.UNKNOWN_FAILURE.name)
            }
        }
    }.asLiveData(Dispatchers.IO)

    /** */
    enum class LyricsDetailsFailure {

        NOT_INTERNET_CONNECTION,

        NOT_LYRICS_FOUND,

        UNKNOWN_FAILURE;

    }

}