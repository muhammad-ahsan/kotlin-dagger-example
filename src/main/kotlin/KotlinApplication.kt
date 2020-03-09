import com.aiscalable.di.DaggerScrapperComponent

fun main() {
    val scrapperComponent = DaggerScrapperComponent.create()
    val scrapper = scrapperComponent.provideScrapper()
    scrapper.javaClass
    println("Dagger has initiate scrapper in main function with " + scrapper.javaClass)
}