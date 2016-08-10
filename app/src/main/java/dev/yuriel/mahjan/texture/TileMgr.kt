package dev.yuriel.mahjan.texture

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import dev.yuriel.kotmahjan.models.Hai
import dev.yuriel.kotmahjan.models.HaiType
import dev.yuriel.kotmahjan.models.UnbelievableException

/**
 * Created by yuriel on 8/5/16.
 */
object TileMgr: TextureMgr {
    private var atlas: TextureAtlas? = null
    private var loaded: Boolean = false

    override fun load(): Boolean {
        try {
            if (loaded)
                return true
            atlas = TextureAtlas(Gdx.files.internal("tiles.txt"))

            loaded = true
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    operator fun get(name: String): TextureRegion? {
        return atlas?.findRegion(name)
    }

    operator fun get(hai: Hai): TextureRegion? {
        val name = findTextureNameByHai(hai)
        return this[name]
    }

    fun getBack(): TextureRegion? {
        return this["back"]
    }

    fun getObverse(): TextureRegion? {
        return this["back_side"]
    }

    override fun destroy() {
        //map.clear()
        atlas?.regions?.clear()
        atlas = null
        loaded = false
    }

    private fun findTextureNameByHai(hai: Hai): String {
        fun normal(hai: Hai): String {
            val fileName: String
            val haiName = hai.toString()
            when (haiName.length) {
                2 -> fileName = haiName
                3 -> {
                    when(haiName.first()) {
                        'p' -> fileName = "aka1"
                        's' -> fileName = "aka2"
                        'm' -> fileName = "aka3"
                        else -> throw UnbelievableException()
                    }
                }
                else -> throw UnbelievableException()
            }
            return fileName
        }
        return when(hai.type) {
            HaiType.E -> "ji1"
            HaiType.S -> "ji2"
            HaiType.W -> "ji3"
            HaiType.N -> "ji4"
            HaiType.D -> "ji5"
            HaiType.H -> "ji6"
            HaiType.T -> "ji7"
            else -> normal(hai)
        }
    }
}