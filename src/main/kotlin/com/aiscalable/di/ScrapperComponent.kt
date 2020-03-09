package com.aiscalable.di

import com.aiscalable.scrapper.Scrapper
import dagger.Component
import org.jetbrains.annotations.Nullable
import javax.inject.Singleton

@Component(modules = [ScrapperModule::class])
@Singleton
interface ScrapperComponent {
    @Nullable
    fun provideScrapper(): Scrapper
}