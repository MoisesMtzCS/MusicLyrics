package cs.med.mtz.moises.musiclyrics.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cs.med.mtz.moises.lyrics.domain.entity.Song
import cs.med.mtz.moises.musiclyrics.databinding.ViewHolderSongBinding

/* */
class SongAdapter(
    private val songs: List<Song>,
    private val onSongActionClick: (Song) -> Unit,
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    /** */
    class SongViewHolder(
        val binding: ViewHolderSongBinding
    ) : RecyclerView.ViewHolder(binding.root)

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ViewHolderSongBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SongViewHolder(binding)
    }

    /** */
    override fun getItemCount(): Int {
        return songs.size
    }

    /** Setup the view info */
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song: Song = songs[position]
        holder.binding.tvTitle.text = song.title

        Glide.with(holder.itemView)
            .load(song.imageUrl)
            .into(holder.binding.ivCover)

        holder.itemView.setOnClickListener {
            onSongActionClick(song)
        }
    }

}
