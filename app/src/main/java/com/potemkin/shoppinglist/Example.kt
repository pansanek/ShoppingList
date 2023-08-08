package com.potemkin.shoppinglist

open class Rectangle(
    private var a: Int,
    private var b: Int
) {

    open fun setWidth(width: Int) {
        this.a = width
    }

    open fun setHeight(height: Int) {
        this.b = height
    }

    fun getWidth() = a

    fun getHeight() = b

    fun area() = a * b
}

class Square(
    private var side: Int
):Rectangle(side,side){

    override fun setWidth(width: Int) {
        super.setWidth(width)
        super.setHeight(width)
    }

    override fun setHeight(height: Int) {
        super.setHeight(height)
        super.setWidth(height)
    }

}

fun main(){
    test()
}

private fun test(){
    val rect = Square(10)
    println(rect.area() == 100)
    println(rect.getHeight() == 10)
    println(rect.getWidth() == 10)

    rect.setWidth(5)
    rect.setHeight(20)

    println(rect.area() == 100)
    println(rect.getHeight() == 10)
    println(rect.getWidth() == 10)
}