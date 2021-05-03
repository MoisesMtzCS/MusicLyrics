package cs.med.mtz.moises.musiclyrics.di

import org.koin.core.module.Module

fun getApplicationModules(): List<Module> {
    val featureModules: List<Module> = listOf()
    val sharedModules: List<Module> = listOf()
    return featureModules + sharedModules
}