package cs.med.mtz.moises.musiclyrics.data.dto

import cs.med.mtz.moises.lyrics.domain.entity.Song

data class SongDto(
    val id: Long,
    val title: String,
    val album: AlbumDto,
    val artist: ArtistDto
) {

    /**
     *
     */
    fun toSong(): Song =
        Song(
            id = id,
            title = title,
            imageUrl = album.cover_medium,
            artist = artist.name

        )

}
