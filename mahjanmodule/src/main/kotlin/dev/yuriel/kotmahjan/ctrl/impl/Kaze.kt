/*
 * Copyright (C) 2016. Yuriel - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package dev.yuriel.kotmahjan.ctrl.impl

/**
 * Created by yuriel on 7/31/16.
 */
enum class Kaze(val index: Int) {
    EAST(0), SOUTH(1), WEST(2), NORTH(3);

    fun text(): String {
        return when(this) {
            EAST -> "東"
            SOUTH -> "南"
            WEST -> "西"
            NORTH -> "北"
        }
    }
}