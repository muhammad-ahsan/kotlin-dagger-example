import com.aiscalable.scrapper.Scrapper
import javax.inject.Inject

class ScrapperUser {

    @Inject
    lateinit var scrapper: Scrapper

    override fun toString(): String {
        return scrapper.javaClass.toString()
    }


}