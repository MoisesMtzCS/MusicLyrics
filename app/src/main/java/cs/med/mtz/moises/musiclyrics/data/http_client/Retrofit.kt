package cs.med.mtz.moises.musiclyrics.data.http_client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* */
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.lyrics.ovh/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()