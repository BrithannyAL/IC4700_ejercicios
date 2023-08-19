package ejercicios

import "fmt"

var arreglo []string = []string{"a", "b", "c", "d", "e"}

func rotarcionElementos(arreglo *[]string, movimientos int, direccion int) {
	var anterior string = "-"
	var actual string = "-"
	rotaciones := 0

	if direccion == 1 {
		for rotaciones < movimientos {
			for indice := 0; indice < len(*arreglo); indice++ {
				actual = (*arreglo)[indice]
				(*arreglo)[indice] = anterior
				anterior = actual
			}
			(*arreglo)[0] = anterior
			rotaciones++
		}
	} else if direccion == 0 {
		for rotaciones < movimientos {
			for indice := len(*arreglo) - 1; indice >= 0; indice-- {
				actual = (*arreglo)[indice]
				(*arreglo)[indice] = anterior
				anterior = actual
			}
			(*arreglo)[len(*arreglo)-1] = anterior
			rotaciones++
		}
	} else {
		fmt.Println(`La dirección proporcionada no es válida:
			0: Derecha
			1: Izquierda
		`)
	}
}

func EjercicioRotacion() {
	fmt.Println("Arreglo original: ", arreglo)
	rotarcionElementos(&arreglo, 2, 0)
	fmt.Println("Arreglo rotado:", arreglo)
}

// 0: Izquierda
// 1: Derecha
