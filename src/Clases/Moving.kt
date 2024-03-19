package Clases

class Moving (
    val client: Client,
    val worker: Worker,
    val totalPrice:Double,
    var isCancelled: Boolean = false,
)