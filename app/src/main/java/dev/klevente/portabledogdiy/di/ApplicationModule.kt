package dev.klevente.portabledogdiy.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(@get:Provides val context: Context)