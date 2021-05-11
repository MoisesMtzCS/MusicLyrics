package cs.med.mtz.moises.musiclyrics.data.http_client

import cs.med.mtz.moises.musiclyrics.data.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* */


private val interceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

/* */
private val client: OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

/* */
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.lyrics.ovh/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()



