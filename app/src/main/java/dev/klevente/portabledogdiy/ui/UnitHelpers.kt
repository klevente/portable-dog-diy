package dev.klevente.portabledogdiy.ui

import dev.klevente.portabledogdiy.domain.Mass
import dev.klevente.portabledogdiy.domain.Temperature
import dev.klevente.portabledogdiy.domain.Volume

fun Mass.format() = "$value ${unit.abbreviation}"

fun Temperature.format() = "$value ${unit.abbreviation}"

fun Volume.format() = "$value ${unit.abbreviation}"