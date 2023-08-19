package main

import (
	"encoding/csv"
	"fmt"
	"os"
	"strconv"
)

type calzado struct {
	marca    string
	precio   int
	talla    int
	cantidad int
}

type inventario []calzado

var memoriaInventario inventario

func textToInt(texto string) int {
	base := 10
	bitSize := 64

	entero, err := strconv.ParseInt(texto, base, bitSize)
	if err != nil {
		fmt.Println("Error:", err)
		return int(entero)
	}
	return int(entero)
}

// La función "obtenerInventario" lee datos de un archivo CSV, valida el formato de cada línea,
// convierte ciertos campos a enteros y almacena los datos del calzado en un inventario de memoria.
func obtenerInventario() {
	archivo, err := os.Open("c:/Users/USUARIO/Desktop/EjerciciosExtraclase1/ejercicios/Ejercicio4/datos.csv")
	if err != nil {
		fmt.Println("Error al abrir el archivo:", err)
		return
	}
	defer archivo.Close()

	lector := csv.NewReader(archivo)
	lineas, err := lector.ReadAll()
	if err != nil {
		fmt.Println("Error al leer el archivo:", err)
		return
	}

	for _, line := range lineas {
		if len(line) != 4 {
			fmt.Println("Formato de línea incorrecto:", line)
			continue
		}
		precio := textToInt(line[1])
		talla := textToInt(line[2])
		cantidad := textToInt(line[3])
		memoriaInventario.almacenarZapato(line[0], precio, talla, cantidad)
	}
}

// La función "guardarInventario" guarda los datos del inventario en un archivo CSV.
func guardarInventario() {
	archivo, err := os.Create("c:/Users/USUARIO/Desktop/EjerciciosExtraclase1/ejercicios/Ejercicio4/datos.csv")
	if err != nil {
		fmt.Println("Error al abrir el crear:", err)
		return
	}
	defer archivo.Close()

	writer := csv.NewWriter(archivo)

	for _, linea := range memoriaInventario {
		row := []string{linea.marca,
			fmt.Sprintf("%d", linea.precio),
			fmt.Sprintf("%d", linea.talla),
			fmt.Sprintf("%d", linea.cantidad)}
		writer.Write(row)
	}
	defer writer.Flush()
}

// La función `almacenarZapato` es un método del tipo `inventario`. Se utiliza para almacenar un zapato
// nuevo en el inventario. Toma cuatro parámetros: `marca` (marca), `precio` (precio), `talla` (tamaño)
// y `cantidad` (cantidad).
func (inv *inventario) almacenarZapato(marca string, precio int, talla int, cantidad int) {
	*inv = append(*inv, calzado{marca: marca, precio: precio, talla: talla, cantidad: cantidad})
}

// La función `verInventario` es un método del tipo `inventario`. Se utiliza para mostrar el inventario
// de zapatos.
func (inv *inventario) verInventario() {
	fmt.Println("-------------------")
	fmt.Println("LISTA DE OPCIONES: ")
	fmt.Println("-------------------")
	opcion := 1
	for _, zapato := range *inv {
		fmt.Printf(`
		Opción %d:
		%s de talla %d en %d (%d pares)
		`, opcion, zapato.marca, zapato.talla, zapato.precio, zapato.cantidad)
		opcion++
	}
}

// La función `venderZapato` es un método del tipo `inventario`. Se utiliza para vender zapatos del
// inventario. Cuando ya no hay zapatos, la función lo elimina del inventario
func (inv *inventario) venderZapato(opcion int, cantidad int) {
	opcion--
	if (*inv)[opcion].cantidad > cantidad {
		(*inv)[opcion].cantidad = (*inv)[opcion].cantidad - cantidad
	} else if (*inv)[opcion].cantidad == cantidad {
		*inv = append((*inv)[:opcion], (*inv)[opcion+1:]...)
	} else {
		fmt.Println("No hay suficientes zapatos en el inventario")
	}
}

func main() {
	obtenerInventario()

	memoriaInventario.verInventario()

	memoriaInventario.venderZapato(9, 5)

	guardarInventario()
}
