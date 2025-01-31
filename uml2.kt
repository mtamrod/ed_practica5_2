enum class EstadoPedido {
    PENDIENTE_DE_PAGO,
    ENVIADO,
    ENTREGADO,
    PENDIENTE_DE_ENVIO
}

enum class TipoPago {
    TARJETA,
    EFECTIVO,
    CHEQUE
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

data class Pedido(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val impuesto: Double,
    var stock: Int,
    var estado: EstadoPedido,
    val productos: MutableList<Producto> = mutableListOf()
) {
    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (producto.stock >= cantidad) {
            productos.add(producto)
            producto.actualizarStock(cantidad)
        }
    }
    
    fun calcularTotal(): Double {
        return productos.sumOf { it.precio + it.impuesto }
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
    fun realizaPedido(pedido: Pedido) {
        pedidos.add(pedido)
    }
}

data class Pago(
    val metodoPago: TipoPago,
    val cantidad: Double
) {
    fun registrarPago() {
        // Implementación del pago
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