package dev.klevente.portabledogdiy.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import dev.klevente.portabledogdiy.mock.MockDiskModule
import dev.klevente.portabledogdiy.mock.MockNetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        MockNetworkModule::class,
        MockDiskModule::class,
    ]
)
interface AppTestComponent : RainbowCakeComponent