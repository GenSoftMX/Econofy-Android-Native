package todoflutter.com.econofy.ui.extensions

object ECONOFYKEYS {
    const val AUTHENTICATION_LOCATION = "authentication_location"
    const val UNDEFINED_SIZE = 0
    const val INT_ZERO = 0
}

fun Int.isNotZero(): Boolean {
    return this > ECONOFYKEYS.INT_ZERO
}