package com.aiscalable.scrapper

import javax.inject.Inject

class WebScrapper @Inject constructor() : Scrapper {

    override fun scrape(): Boolean {
        println("This is Web based scrapper")
        return true
    }
}