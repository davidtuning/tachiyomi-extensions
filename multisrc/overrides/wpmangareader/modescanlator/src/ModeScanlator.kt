package eu.kanade.tachiyomi.extension.pt.modescanlator

import eu.kanade.tachiyomi.multisrc.wpmangareader.WPMangaReader
import eu.kanade.tachiyomi.network.interceptor.rateLimit
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class ModeScanlator : WPMangaReader(
    "Mode Scanlator",
    "https://modescanlator.com",
    "pt-BR",
    dateFormat = SimpleDateFormat("MMMMM dd, yyyy", Locale("pt", "BR"))
) {

    // Site changed from Madara to WpMangaReader.
    override val versionId: Int = 2

    override val client: OkHttpClient = network.cloudflareClient.newBuilder()
        .rateLimit(1, 2, TimeUnit.SECONDS)
        .build()

    override val altName = "Nome alternativo: "
}
