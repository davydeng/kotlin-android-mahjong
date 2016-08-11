package dev.yuriel.kotmvp.layout

/**
 * Created by yuriel on 8/10/16.
 */
class RelativeLayoutElement(override val id: String): LayoutElement() {

    fun o(x: Number?, y: Number?) {
        x(x?: 0)
        y(y?: 0)
    }

    infix fun Number.x(other: Number) {
        w(this)
        h(other)
    }

    infix fun x(originX: Number) {
        attr.origin.x = originX.toFloat() * unit.toFloat()
    }

    infix fun y(originY: Number) {
        attr.origin.y = originY.toFloat() * unit.toFloat()
    }

    infix fun w(width: Number) {
        attr.size.width = width.toFloat() * unit.toFloat()
    }

    infix fun h(height: Number) {
        attr.size.height = height.toFloat() * unit.toFloat()
    }

    infix fun moveTop(top: Number) {
        attr moveTop top.toFloat() * unit.toFloat()
    }

    infix fun moveRight(right: Number) {
        attr moveRight right.toFloat() * unit.toFloat()
    }

    infix fun moveBottom(bottom: Number) {
        attr moveBottom bottom.toFloat() * unit.toFloat()
    }

    infix fun moveLeft(left: Number) {
        attr moveLeft left.toFloat() * unit.toFloat()
    }

    infix fun above(id: String) {
        val t = target(id)?: return
        attr above t
    }

    infix fun below(id: String) {
        val t = target(id)?: return
        attr below t
    }

    infix fun toLeftOf(id: String) {
        val t = target(id)?: return
        attr toLeftOf t
    }

    infix fun toRightOf(id: String) {
        val t = target(id)?: return
        attr toRightOf t
    }

    infix fun alignTopOf(id: String) {
        val t = target(id)?: return
        attr alignTopOf t
    }

    infix fun alignBottomOf(id: String) {
        val t = target(id)?: return
        attr alignBottomOf t
    }

    infix fun alignLeftOf(id: String) {
        val t = target(id)?: return
        attr alignLeftOf t
    }

    infix fun alignRightOf(id: String) {
        val t = target(id)?: return
        attr alignRightOf t
    }

    infix fun centerHorizontal(id: String) {
        val t = target(id)?: return
        attr centerHorizontal t
    }

    infix fun centerVertical(id: String) {
        val t = target(id)?: return
        attr centerVertical t
    }

    infix fun cutBy(id: String) {
        val t = target(id)?: return
        attr cutBy t
    }

    var padding: Number = 0
        set(padding: Number) {
            attr.setPadding(padding.toFloat() * unit.toFloat())
        }

    var paddingTop: Number = 0
        set(top: Number) {
            attr.setPadding(top.toFloat() * unit.toFloat(), 0F, 0F, 0F)
        }

    var paddingRight: Number = 0
        set(right: Number) {
            attr.setPadding(0F, right.toFloat() * unit.toFloat(), 0F, 0F)
        }

    var paddingBottong: Number = 0
        set(bottom: Number) {
            attr.setPadding(0F, 0F, bottom.toFloat() * unit.toFloat(), 0F)
        }

    var paddingLeft: Number = 0
        set(left: Number) {
            attr.setPadding(0F, 0F, 0F, left.toFloat() * unit.toFloat())
        }

    fun move(relativeX: Number?, relativeY: Number?) {
        attr.correct((relativeX?.toFloat()?: 0F) * unit.toFloat(),
                (relativeY?.toFloat()?: 0F) * unit.toFloat())
    }

    fun moveBy(relativeX: Number?, relativeY: Number?) {
        attr.correct(relativeX?.toFloat()?: 0F, relativeY?.toFloat()?: 0F)
    }

    private fun target(id: String): LayoutPosition? = this[id]?.attr
}