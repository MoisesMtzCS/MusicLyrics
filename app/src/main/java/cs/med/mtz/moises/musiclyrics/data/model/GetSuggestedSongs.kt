package cs.med.mtz.moises.musiclyrics.data.model

import cs.med.mtz.moises.musiclyrics.data.dto.SongDto



data class GetSuggestedSongs(
    val data:List <SongDto>,
    val total: Int
)