/*
 * Copyright (C) 2016. Yuriel - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package dev.yuriel.kotmahjan.models

/**
 * Created by yuriel on 7/20/16.
 */

open class RoundEvent(val action: Int = EVENT_INIT, val hai: Hai? = null, val extra: String = "",
                      var from: Player = GameMaster(), var to: Player = GameMaster()) {

    companion object {
        /* todo
        fun fromString(string: String): RoundEvent {

        }
        */
    }

    fun change(): RoundEvent {
        val temp = from
        from = to
        to = temp
        return this
    }

    override fun toString(): String {
        return "^A(${action.toString()}),P(${hai.toString()}),F(${from.toString()}),T(${to.toString()}),E(${extra})$"
    }
}

class RoundEventResponse: RoundEvent() {

}