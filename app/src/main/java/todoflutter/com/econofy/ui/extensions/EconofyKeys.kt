package todoflutter.com.econofy.ui.extensions

object EconofyKeys {
    val UNDEFINED_SIZE = 0
    val INT_ZERO = 0
}

fun Int.isNotZero(): Boolean {
    return this > EconofyKeys.INT_ZERO
}