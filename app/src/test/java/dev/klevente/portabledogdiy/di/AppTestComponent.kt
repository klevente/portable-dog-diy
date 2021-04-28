package dev.klevente.portabledogdiy.di

import dagger.Component
import dev.klevente.portabledogdiy.data.disk.DiskDataSource
import dev.klevente.portabledogdiy.data.network.NetworkDataSource
import dev.klevente.portabledogdiy.mock.MockDiskModule
import dev.klevente.portabledogdiy.mock.MockNetworkModule
import dev.klevente.portabledogdiy.ui.detail.DetailPresenter
import dev.klevente.portabledogdiy.ui.edit.EditPresenter
import dev.klevente.portabledogdiy.ui.list.ListPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        MockNetworkModule::class,
        MockDiskModule::class,
    ]
)
interface AppTestComponent {

    fun listPresenter(): ListPresenter

    fun detailPresenter(): DetailPresenter

    fun editPresenter(): EditPresenter

    fun networkDataSource(): NetworkDataSource

    fun diskDataSource(): DiskDataSource
}