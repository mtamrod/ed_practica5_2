enum class EstadoPedido {
    PENDIENTE_DE_PAGO, ENVIADO, ENTREGADO, PENDIENTE_DE_ENVIO
}

enum class TipoPago {
    TARJETA, EFECTIVO, CHEQUE
}

data class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val impuesto: Double,
    var stock: Int
) {
    fun actualizarStock(cantidad: Int) {
        stock -= cantidad
    }
}

data class Tarjeta(
    val nombre: String,
    val fechaCaducidad: String,
    val tipoTarjeta: String
)

data class Cheque(
    val nombre: String,
    val banco: String
)

data class Pago(
    val metodoPago: TipoPago,
    val cantidad: Double
) {
    fun registrarPago() {
        println("Pago de $$cantidad registrado con método $metodoPago")
    }
}

data class Pedido(
    val nombre: String,
    val descripcion: String,
    var estado: EstadoPedido = EstadoPedido.PENDIENTE_DE_PAGO,
    private val productos: MutableList<Pair<Producto, Int>> = mutableListOf()
) {
    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (producto.stock >= cantidad) {
            productos.add(Pair(producto, cantidad))
            producto.actualizarStock(cantidad)
        } else {
            println("Stock insuficiente para ${producto.nombre}")
        }
    }

    fun calcularTotal(): Double {
        return productos.sumOf { (producto, cantidad) ->
            (producto.precio + producto.impuesto) * cantidad
        }
    }

    fun actualizarEstado(nuevoEstado: EstadoPedido) {
        estado = nuevoEstado
    }
}

data class Cliente(
    val nombre: String,
    val email: String,
    val pedidos: MutableList<Pedido> = mutableListOf()
) {
    fun realizarPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }
}
