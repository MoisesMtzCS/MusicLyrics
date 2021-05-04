package cs.med.mtz.moises.musiclyrics.data.dto

import cs.med.mtz.moises.musiclyrics.domiain.entity.Lyric

data class LyricDto(
    val lyrics: String
) {

    /**
     *
     */
    fun toLyric(): Lyric =
        Lyric(
            lyrics = lyrics
        )

}