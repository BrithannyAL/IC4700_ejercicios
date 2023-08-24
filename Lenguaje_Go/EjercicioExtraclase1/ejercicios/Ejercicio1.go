package ejercicios

import (
	"fmt"
	"strings"
)

func ContadorEnTexto(texto string) {

	caracteresConEspacios := len(texto)

	palabras := strings.Count(texto, " ") + 1

	letras := caracteresConEspacios - (palabras - 1)

	lineas := strings.Count(texto, "\n") + 1

	// Print the results.
	fmt.Println("Número de letras:", letras)
	fmt.Println("Número de palabras:", palabras)
	fmt.Println("Número de líneas:", lineas)
}
