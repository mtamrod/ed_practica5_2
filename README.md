# Generación de Diagrama de Clases y Código

## Actividad

La actividad consiste en generar el diagrama de clases y posteriormente un esquema de lo que sería el código que se derive del diagrama de clases que represente lo descrito en el supuesto.

## Objetivo

- Conocer los elementos que forman parte de un diagrama de clases.
- Conocer las relaciones que existen entre las clases.
- Conocer herramientas.

## Trabajo a realizar

Para diseñar un sistema que gestione los pedidos de mi empresa, es necesario considerar los siguientes requerimientos:

- Los pedidos los realizan los clientes, y pueden contener uno o varios productos.
- Debe registrar la información de cada pedido, incluyendo la fecha en que se realizó.
- Estos productos deben estar registrados en el sistema junto con su información correspondiente (nombre, descripción, precio, impuestos, etc.).
- El sistema debe ser capaz de calcular el coste total de cada pedido, teniendo en cuenta la cantidad de cada producto incluido en el pedido, sus precios individuales y los impuestos correspondientes.
- Debe haber un registro actualizado del stock de cada producto, de forma que se pueda informar al cliente si habrá algún retraso en la entrega debido a falta de stock.
- Cada pedido puede ser pagado de una sola vez o en varios pagos.
- Se debe ser capaz de registrar la información de cada pago realizado por el cliente.
- Las formas de pago aceptadas por el sistema son:
  - **Card** (número, fecha de caducidad y tipo de tarjeta).
  - **Cash** (Tipo de moneda).
  - **Cheque** (nombre y banco).
- Cada pedido puede estar en uno de los siguientes estados: **pdte, pgdo, pcdo, envdo, entgdo**. El estado de cada pedido debe ser actualizado en el sistema en función de su evolución.

## Otras tareas

### a) Conceptos de UML y Programación Orientada a Objetos

Una breve lista de los conceptos que te has encontrado en los diagramas UML que se asemejan a los conceptos de programación orientada a objetos. Por ejemplo: Clases: GestorPedidos

- **Clases**: Ejemplo: `GestorPedidos`
- **Atributos**: Datos asociados a una clase, como `nombre`, `precio`, `stock`.
- **Métodos**: Acciones que una clase puede realizar, como `calcularTotal()`, `registrarPago()`.
- **Relaciones**: Asociación entre clases, como la relación entre `Cliente` y `Pedido`.

### b) Herramienta utilizada para el diagrama UML

Explicación de la herramienta que has utilizado parra generar el diagrama UML, y si la has contrastado con otra y conclusiones de porque has elegido esa

```
| Característica                   | DIA                                                       | Lucidchart                                                       |
|----------------------------------|-----------------------------------------------------------|------------------------------------------------------------------|
| Facilidad de uso                 | Interfaz sencilla pero menos intuitiva.                   | Interfaz moderna y amigable.                                     |
| Plataforma                       | Software de escritorio (Windows, Linux).                  | Basado en la web (multiplataforma).                              |
| Colaboración en tiempo real      | No soporta colaboración en línea.                         | Permite colaboración en tiempo real con múltiples usuarios.      |
| Personalización de diagramas     | Opciones básicas de personalización.                      | Amplia gama de opciones de estilo y personalización.             |
| Soporte para UML                 | Compatible con UML pero con menos herramientas avanzadas. | Soporta UML con muchas herramientas y plantillas avanzadas.      |
| Exportación                      | SVG, PNG, PDF, XML, entre otros.                          | PNG, SVG, PDF, Visio, y más formatos compatibles.                |
| Integraciones                    | No tiene muchas integraciones.                            | Se integra con herramientas como Google Drive, Confluence, Jira. |
| Precio                           | Gratuito y de código abierto.                             | Modelo Freemium, requiere suscripción para funciones avanzadas.  |
|Plantillas y automatización       | Plantillas básicas y poca automatización.                 | Plantillas avanzadas y generación automática de diagramas.       |
```

He usado DIA porque anteriormente en el pasado ya la había utilizado para crear modelos Entidad Relación de base de datos e incluso algunos modelos UML. Por lo tanto estaba familiarizado.

### c) Conversión del Diagrama UML a Código

### Conversión de UML a Kotlin

1. **Enums**:  
   - Transformar los estados del pedido y los tipos de pago a `enum class`.  

2. **Clases de datos (`data class`)**:  
   - `Producto`, `Pedido`, `Pago`, `Cliente`, `Tarjeta` y `Cheque` son `data class` porque manejan datos.  

3. **Relaciones**:  
   - `Cliente` tiene una lista de `Pedido`, relación uno a muchos.  
   - `Pedido` es lista de productos junto con cantidades (`Pair<Producto, Int>`).  
   - `Pago` usa `TipoPago` para definir su forma de pago.  

4. **Funciones**:  
   - `Pedido` con métodos para agregar productos, calcular el total y actualizar el estado.  
   - `Producto` tiene `actualizarStock()`, reduciendo cantidad de stock según las compras.  
   - `Pago` tiene `registrarPago()`, que imprime la si se ha pagado correctamente.
     

* [src](uml2.kt)

## Recursos

- Apuntes dados en clase.
- Recursos vistos en clase.
- Herramientas para diagramas UML:
  - **Dia**: [Descargar](https://sourceforge.net/projects/dia-installer/files/latest/download)
  - **Otras opciones**: [GitMind](https://gitmind.com/es/herramienta-gratis-diagrama-uml.html)

