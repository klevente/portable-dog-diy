package dev.klevente.portabledogdiy.data.disk

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): BeerDatabase = Room
        .databaseBuilder(context, BeerDatabase::class.java, "beer.db")
        .build()

    @Provides
    @Singleton
    fun provideBeerDao(beerDatabase: BeerDatabase) = beerDatabase.beerDao()
}