package dev.klevente.portabledogdiy.mock

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDiskModule {

    /*@Provides
    @Singleton
    fun provideRoomDatabase(context: Context): BeerDatabase = Room
        .databaseBuilder(context, BeerDatabase::class.java, "beer.db")
        .build()*/

    @Provides
    @Singleton
    fun provideBeerDao() = MockBeerDao()
}