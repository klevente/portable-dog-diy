package dev.klevente.portabledogdiy.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import dev.klevente.portabledogdiy.data.disk.DiskModule
import dev.klevente.portabledogdiy.data.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        DiskModule::class,
    ]
)
interface AppComponent : RainbowCakeComponent