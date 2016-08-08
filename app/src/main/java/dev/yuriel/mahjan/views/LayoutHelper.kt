package dev.yuriel.mahjan.views

import android.support.v4.view.ViewPager
import dev.yuriel.kotmvp.*
import dev.yuriel.kotmvp.bases.LayoutPosition
import dev.yuriel.kotmvp.bases.getScreenLayout

/**
 * Created by yuriel on 8/7/16.
 */
class LayoutHelper {
    private val U = Dev.U
    private val SCREEN_LAYOUT = getScreenLayout()
    val ORIGIN = Pair(0F, 0F)
    val handsBottomLayout = LayoutPosition(0F, 0F, TILE_WIDTH * U * 14.5F, TILE_HEIGHT * U * 1.5F)
    val handsLeftLayout = LayoutPosition(0F, 0F, SIDE_TILE_HEIGHT * U, SIDE_TILE_WIDTH * U * 14.5F)
    val handsRightLayout = LayoutPosition(0F, 0F, SIDE_TILE_HEIGHT * U, SIDE_TILE_WIDTH * U * 14.5F)
    val handsOppoLayout = LayoutPosition(0F, 0F, OBVERSE_TILE_WIDTH * U * 14.5F, OBVERSE_TILE_HEIGHT * U)
    val operationScreen = SCREEN_LAYOUT.copy()
    val tableArea = LayoutPosition(0F, 0F,TABLE_AREA_WIDTH * U, TABLE_AREA_HEIGHT * U)


    fun calculate() {
        handsBottomLayout.centerHorizontal(SCREEN_LAYOUT)

        tableArea.above(handsBottomLayout)
        tableArea.centerHorizontal(SCREEN_LAYOUT)
        handsLeftLayout.toLeftOf(tableArea)
        handsLeftLayout.alignTopOf(tableArea)
        handsRightLayout.toRightOf(tableArea)
        handsRightLayout.alignBottomOf(tableArea)
        handsOppoLayout.above(tableArea)
        handsOppoLayout.centerHorizontal(tableArea)
//        operationScreen.above(handsBottomLayout)
//        operationScreen.origin.y = handsBottomLayout.size.height
//        operationScreen.size.height -= handsBottomLayout.size.height
//        operationScreen.setPadding(30F * Dev.U)


//        handsLeftLayout.alignLeftOf(operationScreen)
//        handsLeftLayout.alignBottomOf(operationScreen)
//
//        handsRightLayout.alignRightOf(operationScreen)
//        handsRightLayout.alignBottomOf(operationScreen)
//
//        handsOppoLayout.alignTopOf(operationScreen)
//        handsOppoLayout.centerHorizontal(operationScreen)

        hack()
    }

    private fun hack() {
//        handsLeftLayout.origin.y -= SIDE_TILE_WIDTH * U / 2F
//        handsRightLayout.origin.y += SIDE_TILE_WIDTH * U / 2F
        handsOppoLayout.correct(OBVERSE_TILE_WIDTH * U * 13.5F, 0F)

    }
}