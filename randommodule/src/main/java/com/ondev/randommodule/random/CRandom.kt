package com.ondev.randommodule.random

import javax.inject.Inject
import kotlin.random.Random

class CRandom @Inject constructor(private val rand: Random) {
    fun getRandomIn(start: Int, end: Int): Int {
        return rand.nextInt(start, end)
    }
}