import com.aiscalable.di.DaggerScrapperComponent

fun main() {
    val scrapper = DaggerScrapperComponent.create().getScrapper()
    println("Dagger has initiate scrapper in main function with ${scrapper.javaClass}")
    println(ScrapperUser())
}