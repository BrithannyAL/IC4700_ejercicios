package main

import "fmt"

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
	fmt.Println("\n-MODIFICAR EL PRODUCTO A LA EXISTENCIA MÍNIMA-")
	fmt.Println(lProductos)
	fmt.Println("Creando la nueva lista con productos con cantidad mínima:")
	var nuevaLista listaProductos = lProductos.listarProductosMínimos()
	fmt.Println(nuevaLista)
}
