package main

import (
	"fmt"
)

type horario struct {
	hora    int
	minutos int
}

type curso struct {
	nombre   string
	horarioI horario
	horarioF horario
	aula     string
	notas    []int
}
type listaCursos []curso

var lCrusos listaCursos

func (l *listaCursos) verificarCurso(horarioI horario, horarioF horario, nuevoCurso curso) bool {
	horarioOcupado := false

	for i := 0; i < len(*l); i++ {
		if (*l)[i].horarioI.hora < horarioI.hora && horarioI.hora < (*l)[i].horarioF.hora {
			if (*l)[i].aula == nuevoCurso.aula {
				horarioOcupado = true
				break
			}
		} else if (*l)[i].horarioI.hora == horarioI.hora {
			if (*l)[i].horarioI.minutos < horarioI.minutos && horarioI.hora < (*l)[i].horarioF.hora {
				if (*l)[i].aula == nuevoCurso.aula {
					horarioOcupado = true
					break
				}
			}
		}
	}
	return horarioOcupado
}

func (l *listaCursos) agregarCurso(nombre string, HI int, MI int, HF int, MF int, aula string) bool {
	horarioI := horario{hora: HI, minutos: MI}
	horarioF := horario{hora: HF, minutos: MF}
	nuevoCurso := curso{nombre: nombre, horarioI: horarioI, horarioF: horarioF, aula: aula}

	respuesta := l.verificarCurso(horarioI, horarioF, nuevoCurso)

	if !respuesta {
		*l = append(*l, nuevoCurso)
	} else if respuesta {
		fmt.Println("\n-------------------------------------------------------------------------------------------")
		fmt.Println("No se puede ingresar el curso ", nuevoCurso.nombre, " debido a un choque de horario")
		fmt.Println("-------------------------------------------------------------------------------------------")
	}
	return respuesta
}

func (l *listaCursos) insertarNotas(nombre string, notas []int) {
	for i := 0; i < len(*l); i++ {
		if (*l)[i].nombre == nombre {
			(*l)[i].notas = notas
			fmt.Println("Las notas se insertaron correctamente")
		}
	}
}

func aprobadosCurso(n int) bool {
	return n >= 70
}

func reprobadosCurso(n int) bool {
	return n < 70
}

func filter(coleccion []int, condicion func(n int) bool) []int {
	var result []int

	for _, numero := range coleccion {
		if condicion(numero) {
			result = append(result, numero)
		}
	}

	return result
}

func promedioGeneral(notas []int) int {
	var suma int
	for _, nota := range notas {
		suma = suma + nota
	}
	return suma / len(notas)
}

func promedioAprobados(notas []int) (int, []int) {
	aprobados := filter(notas, aprobadosCurso)
	promedio := promedioGeneral(aprobados)
	return promedio, aprobados
}

func promedioReporbados(notas []int) (int, []int) {
	reprobados := filter(notas, reprobadosCurso)
	promedio := promedioGeneral(reprobados)
	return promedio, reprobados
}

func llenarDatos() {
	lCrusos.agregarCurso("Lenguajes de programación", 7, 50, 11, 30, "Lab-2")
	lCrusos.agregarCurso("Introducción a la programación", 9, 0, 11, 30, "A-101")
	lCrusos.agregarCurso("Marketing Digital Avanzado", 10, 20, 11, 0, "A-205")
	lCrusos.agregarCurso("Historia del Arte", 13, 0, 15, 0, "E-103")
	lCrusos.agregarCurso("Biología molecular", 15, 30, 17, 0, "Lab-4")

	lCrusos.insertarNotas("Lenguajes de programación", []int{42, 18, 75, 9, 63, 27, 88, 51, 36, 5})
	lCrusos.insertarNotas("Introducción a la programación", []int{7, 29, 14, 68, 91, 55, 38, 83, 20, 46})
	lCrusos.insertarNotas("Marketing Digital Avanzado", []int{12, 77, 23, 50, 32, 66, 40, 96, 3, 57})
	lCrusos.insertarNotas("Historia del Arte", []int{25, 89, 44, 70, 15, 48, 82, 6, 31, 64})
	lCrusos.insertarNotas("Biología molecular", []int{99, 72, 28, 53, 17, 61, 35, 80, 2, 45})
}

func main() {
	llenarDatos()
	fmt.Println(lCrusos)

	lCrusos.agregarCurso("Nuevo Curso", 8, 30, 11, 30, "Lab-2")

	cantidadAprobados := filter(lCrusos[1].notas, aprobadosCurso)
	fmt.Printf(`
	Reporte del curso %s:
	Hay %d estudiantes aprobados cuyas notas son:
		%d
	`, lCrusos[1].nombre, len(cantidadAprobados), cantidadAprobados)

	cantidadReprobados := filter(lCrusos[2].notas, reprobadosCurso)
	fmt.Printf(`
	Reporte del curso %s:
	Hay %d estudiantes reprobados cuyas notas son:
		%d
	`, lCrusos[1].nombre, len(cantidadReprobados), cantidadReprobados)

	promedioCurso := promedioGeneral(lCrusos[0].notas)
	fmt.Printf(`
	Reporte del curso %s:
	El promedio de todo el semestre es: %d
	`, lCrusos[0].nombre, promedioCurso)

	pa, na := promedioAprobados(lCrusos[3].notas)
	fmt.Printf(`
	Reporte del curso %s:
	El promedio de los estudiantes aprobados es: %d
	Con las notas:
		%d
	`, lCrusos[3].nombre, pa, na)

	pr, nr := promedioReporbados(lCrusos[4].notas)
	fmt.Printf(`
	Reporte del curso %s:
	El promedio de los estudiantes aprobados es: %d
	Con las notas:
		%d
	`, lCrusos[4].nombre, pr, nr)

}
