package com.aiscalable.scrapper

import org.jetbrains.annotations.Nullable
import javax.inject.Inject

class FileScrapper @Inject constructor() : Scrapper {

    override fun scrape(): Boolean {
        println("This is file based scrapper")
        return false
    }
}