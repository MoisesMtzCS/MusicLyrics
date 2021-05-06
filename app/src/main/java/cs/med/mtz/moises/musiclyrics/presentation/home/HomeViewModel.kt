package cs.med.mtz.moises.musiclyrics.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import cs.med.mtz.moises.lyrics.domain.entity.Song
import cs.med.mtz.moises.musiclyrics.data.api.ApiService
import cs.med.mtz.moises.musiclyrics.data.dto.SongDto
import cs.med.mtz.moises.musiclyrics.data.http_client.retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class HomeViewModel(
    //private val service: ApiService
) : ViewModel() {


    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)


    fun getSongsLiveData(valueSong: String): LiveData<List<Song>> = flow {
        try {
            val response = service.getSuggestSongs(valueSong)
            val songsDto: List<SongDto> = response.data
            val songs: List<Song> = songsDto.map { it.toSong() }
            emit(songs)
        } catch (exception: Exception) {
        }
    }.asLiveData(Dispatchers.IO)
}
