package com.aiscalable.di

import com.aiscalable.scrapper.FileScrapper
import com.aiscalable.scrapper.Scrapper
import dagger.Module
import dagger.Provides


@Module
class ScrapperModule {
    @Provides
    fun provideScrapper(): Scrapper? {
        val impl = FileScrapper()
        println("Dagger is configured to provide " + impl.javaClass )
        return impl
    }
}