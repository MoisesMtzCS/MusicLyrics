package cs.med.mtz.moises.musiclyrics.data.api

import cs.med.mtz.moises.musiclyrics.data.model.GetLyricSong
import cs.med.mtz.moises.musiclyrics.data.model.GetSuggestedSongs
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("suggest/{value}")
    suspend fun getSuggestSongs(
        @Path("value") value: String
    ): GetSuggestedSongs


    /**
     *
     */
    @GET("v1/{artist}/{song}")
    suspend fun getLyricSong(
        @Path("artist") artist: String,
        @Path("song") song: String
    ): GetLyricSong

}