package dev.klevente.portabledogdiy.mock

import dagger.Module
import dagger.Provides
import dev.klevente.portabledogdiy.data.network.PunkApi
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providePunkApi(): PunkApi = MockPunkApi()
}