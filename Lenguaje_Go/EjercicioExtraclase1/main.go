package main

import (
	"ejercicios1/ejercicios"
	"fmt"
)

func main() {
	fmt.Println("Funcion donde se llaman a los demás ejercicios")
	fmt.Println("------------------------------------------------")
	ejercicios.ImprimirFigura(5)
	fmt.Println("------------------------------------------------")
	ejercicios.ContadorEnTexto("Hola mundo")
	fmt.Println("------------------------------------------------")
	ejercicios.EjercicioRotacion()

}

/*
NOTAS:
La mayoría de los datos quemados están en los propios archivos de los ejercicios dentro de la carpeta "ejercicios".
Este menú solo sirve para correrlos uno por uno.

El ejercicio 4 tiene su propio menú
*/
