package ejercicios

import (
	"fmt"
	"strings"
)

func ImprimirFigura(cantidad int) {
	if cantidad%2 == 0 {
		fmt.Println("La función solo acepta números impares positivos")
	} else {
		espacios := int(cantidad / 2)
		for i := 1; i <= cantidad; i += 2 {
			fmt.Printf("%s%s\n", strings.Repeat("  ", espacios), strings.Repeat(" *", i))
			espacios--
		}
		espacios = 1
		for i := cantidad - 2; i >= 1; i -= 2 {
			fmt.Printf("%s%s\n", strings.Repeat("  ", espacios), strings.Repeat(" *", i))
			espacios++
		}
	}
}
