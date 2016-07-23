package dev.yuriel.kotmahjan.rules.yaku.yakuimpl

import dev.yuriel.kotmahjan.models.HaiType
import dev.yuriel.kotmahjan.rules.MentsuSupport

/**
 * Created by yuriel on 7/24/16.
 * 中判定クラス
 * 中の刻子もしくは槓子が含まれる場合成立
 */
fun 中Impl(s: MentsuSupport): Boolean {
    for (kotsu in s.getKotsuList()) {
        if (kotsu.getHai()?.type == HaiType.T) {
            return true
        }
    }
    return false
}