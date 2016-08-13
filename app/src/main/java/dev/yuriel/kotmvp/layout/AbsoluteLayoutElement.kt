/*
 * Copyright (C) 2016. Yuriel - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package dev.yuriel.kotmvp.layout

/**
 * Created by yuriel on 8/11/16.
 */
class AbsoluteLayoutElement(override val id: String): LayoutElement() {

    fun rect(top: Number, right: Number, bottom: Number, left: Number) {
        attr.size.width = right.toFloat() - left.toFloat()
        attr.size.height = top.toFloat() - bottom.toFloat()
        attr.origin.x = left.toFloat()
        attr.origin.y = bottom.toFloat()
    }

    fun String.top() = target(this)?.top()?: 0F
    fun String.right() = target(this)?.right()?: 0F
    fun String.bottom() = target(this)?.bottom()?: 0F
    fun String.left() = target(this)?.left()?: 0F

    fun moveUnits(relativeX: Number?, relativeY: Number?) {
        attr.correct((relativeX?.toFloat()?: 0F) * unit.toFloat(),
                (relativeY?.toFloat()?: 0F) * unit.toFloat())
    }

    private fun target(id: String): LayoutPosition? = this[id]?.attr
}