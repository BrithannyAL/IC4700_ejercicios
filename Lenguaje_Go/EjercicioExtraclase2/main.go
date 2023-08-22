package main

import (
	"fmt"
	"sort"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}
type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	var prod, err = l.buscarProducto(nombre)
	if err != -1 {
		prod.cantidad = prod.cantidad + cantidad
		prod.precio = precio
	} else {
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}

func (l *listaProductos) buscarProducto(nombre string) (*producto, int) {
	var result = -1
	var punt *producto = nil
	var i int
	for i = 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			result = i
			punt = &((*l)[i])
			break
		}
	}
	return punt, result
}

func (l *listaProductos) venderProducto(nombre string, cantidadVenta int) {
	var prod, err = l.buscarProducto(nombre)
	if err != -1 {

		if prod.cantidad < cantidadVenta {
			fmt.Println("No hay suficientes productos para vender")
		} else {
			prod.cantidad = prod.cantidad - cantidadVenta
			if prod.cantidad == 0 {
				l.eliminarProductos(prod.nombre)
			}
		}
	}
}

func (l *listaProductos) modificarPrecioProducto(nombre string, nuevoPrecio int) {
	var prod, err = l.buscarProducto(nombre)
	if err != -1 {
		prod.precio = nuevoPrecio
		fmt.Println("El precio del producto se ha modificado")
	} else {
		fmt.Println("El producto buscado no existe")
	}
}

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)

}

func (l *listaProductos) listarProductosMínimos() listaProductos {
	var nuevaLista listaProductos
	var i int
	for i = 0; i < len(*l); i++ {
		if (*l)[i].cantidad > existenciaMinima {
			nuevaLista = append(nuevaLista, (*l)[i])
		}
	}
	return nuevaLista
}

func (l *listaProductos) agregarVariosProductos(prods ...producto) {
	for _, prod := range prods {
		*l = append(*l, prod)
	}
}

func (l *listaProductos) eliminarProductos(gatito string) {
	var prod, err = l.buscarProducto(gatito)
	*l = append((*l)[:err], (*l)[err+1:]...)
	fmt.Println("El producto eliminado es: ", prod.nombre)
}

// La función `aumentarInventarioDeMinimos` se utiliza para aumentar el inventario de productos que
// tienen una cantidad por debajo del umbral mínimo (“existenciaMinima”).
func (l *listaProductos) aumentarInventarioDeMinimos() {
	for prod := 0; prod < len(*l); prod++ {
		if (*l)[prod].cantidad < existenciaMinima {
			fmt.Println("Comprando", (existenciaMinima - (*l)[prod].cantidad), "de", (*l)[prod].nombre)
			(*l)[prod].cantidad = existenciaMinima
		}
	}
}

// La función `func (l listaProductos) Len() int` está implementando el método `Len` de la interfaz
// `sort.Interface` para el tipo `listaProductos`. Este método devuelve la longitud del segmento
// `listaProductos`. Lo utiliza la función `sort.Sort` para determinar la longitud del segmento que se
// está ordenando.
func (l listaProductos) Len() int {
	return len(l)
}

// La función `Less` está implementando el método `Less` de la interfaz `sort.Interface` para el tipo
// `listaProductos`. Este método lo utiliza la función `sort.Sort` para determinar el orden de los
// elementos en la lista.
func (l listaProductos) Less(i, j int) bool {
	return (l)[i].nombre < (l)[j].nombre
}

// La función `Swap` se utiliza para intercambiar las posiciones de dos elementos en el segmento
// `listaProductos`. Toma dos índices "i" y "j" como parámetros e intercambia los elementos en esos
// índices.
func (l listaProductos) Swap(i, j int) {
	nuevai := (l)[j]
	nuevaj := (l)[i]
	(l)[i] = nuevai
	(l)[j] = nuevaj
}

func main() {
	llenarDatos()
	fmt.Println("\n-PRODUCTOS INICIALES-")
	fmt.Println(lProductos)

	//Vender un producto
	fmt.Println("\n-SE VENDEN DOS PRODUCTOS-")
	lProductos.venderProducto("leche", 5)
	lProductos.venderProducto("arroz", 2)
	fmt.Println(lProductos)

	//Cuando se agrega un producto se actualiza la cantidad (el precio es opcional)
	fmt.Println("\n-ACTUALIZAR LA CANTIDAD Y EL PRECIO DE UN PRODUCTO-")
	lProductos.agregarProducto("arroz", 20, 3000)
	lProductos.agregarProducto("atún", 16, 1700)
	fmt.Println(lProductos)

	//Función que resiva n de prodcutos
	fmt.Println("\n-AGREGAR VARIOS PRODUCTOS A LA VEZ-")
	var prod1 = producto{"natilla", 10, 2000}
	var prod2 = producto{"mantequilla", 15, 2300}
	var prod3 = producto{"chocolate", 3, 2700}
	lProductos.agregarVariosProductos(prod1, prod2, prod3)
	fmt.Println(lProductos)

	//La función buscar modificada
	fmt.Println("\n-LA FUNCIÓN BUSCAR DEVUELVE EL PRODUCTO Y EL ERROR-")
	fmt.Println("Buscando manzana")
	var prod, err = lProductos.buscarProducto("manzana")
	if err != -1 {
		fmt.Println("El producto es: "+prod.nombre+" con una cantidad de ", prod.cantidad, " y un precio de ", prod.precio)
	} else {
		fmt.Println("No se ha encontrado este producto")
	}

	//Se elimina los productos de cantidad 0
	fmt.Println("\n-VENDIENDO PRODUTOS CUANDO SU CANTIDAD LLEGUE A 0-")
	fmt.Println(lProductos)
	lProductos.venderProducto("natilla", 10)
	fmt.Println(lProductos)

	//Función que modifica el precio del producto
	fmt.Println("\n-MODIFICAR EL PRECIO DE UN PRODUCTO-")
	fmt.Println(lProductos)
	lProductos.modificarPrecioProducto("mantequilla", 2000)
	fmt.Println(lProductos)

	//Todos los productos debe tener como mínimo 10 unidades
	fmt.Println("\n-DUVUELVE UNA NUEVA LISTA CON LOS PRODUCTOS QUE CUMPLEN CON EL MÍNIMO-")
	fmt.Println(lProductos)
	fmt.Println("Creando la nueva lista con productos con cantidad mínima:")
	var nuevaLista listaProductos = lProductos.listarProductosMínimos()
	fmt.Println(nuevaLista)

	// Este código está llamando al método `aumentarInventarioDeMinimos()` sobre la variable `lProductos`,
	// que es de tipo `listaProductos`.
	fmt.Println("\n-COMPRA MÁS PRODUCTOS PARA QUE EL INVENTARIO CUMPLA CON LAS CANTIDADES MÍNIMOS-")
	fmt.Println(lProductos)
	lProductos.aumentarInventarioDeMinimos()
	fmt.Println(lProductos)

	/*
		En este código, se utiliza la librería sort de Go para ordenar una lista de productos personalizada.
		La librería sort provee funciones y tipos que simplifican el proceso de ordenamiento.

		Se implementa una estructura llamada listaProductos, que es un alias para un slice de productos.
		Esto permite personalizar el ordenamiento según las necesidades de la aplicación. Para lograrlo,
		se implementan los métodos necesarios de la interfaz sort.Interface:

		- Len() int: Devuelve la longitud de la lista de productos.
		- Less(i, j int) bool: Compara los productos en las posiciones i y j basándose en algún criterio, como el nombre en este caso.
		- Swap(i, j int): Intercambia los productos en las posiciones i y j.

		Una vez implementados estos métodos, la función sort.Sort de la librería
		sort se utiliza para ordenar la lista de productos utilizando el criterio definido en el método Less.
		Esto resulta en una lista ordenada.
	*/

	fmt.Println("\n-ORDENA LA LISTA POR ALGUNOS DE SUS ELEMENTOS-")
	fmt.Println(lProductos)
	sort.Sort(lProductos)
	fmt.Println("Lista ordenada por nombre del producto:")
	fmt.Println(lProductos)

}
