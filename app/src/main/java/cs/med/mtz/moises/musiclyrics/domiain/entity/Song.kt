package cs.med.mtz.moises.lyrics.domain.entity

data class Song(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val artist: String
)