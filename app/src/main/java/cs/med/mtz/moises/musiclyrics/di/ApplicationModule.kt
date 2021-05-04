package cs.med.mtz.moises.musiclyrics.di

import cs.med.mtz.moises.musiclyrics.di.feature.homeModule
import org.koin.core.module.Module

fun getApplicationModules(): List<Module> {
    val featureModules: List<Module> = listOf(homeModule)
    val sharedModules: List<Module> = listOf()
    return featureModules + sharedModules
}