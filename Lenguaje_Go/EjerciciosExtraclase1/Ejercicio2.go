package main

import "fmt"

func imprimirFigura(cantidad int) {
	if cantidad%2 == 0 {
		fmt.Println("Solo se puede imprimir la figura con los números impares positivos")
	} else {
		for x := 0; x < cantidad; x++ {
			for y := 0; y < cantidad-x; y++ {
				fmt.Print("  ")
			}
			for z := 0; z < x*2-1; z++ {
				fmt.Print(" *")
			}
			fmt.Println()
		}
	}
}

func main() {
	fmt.Println("Hola Mundo")

	imprimirFigura(5)
}
