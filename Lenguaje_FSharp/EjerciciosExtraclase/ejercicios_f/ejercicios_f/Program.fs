// For more information see https://aka.ms/fsharp-console-apps
open ejercicio1

printfn "Primer ejercicio"
let listaNumeros = [1;2;3;4;5]
//Escribir izq o der
let resultado1 = shift_fun 3 "izq" listaNumeros
printfn "%A" resultado1

printfn "\nSegundo ejercicio"
let cadenas = ["Manzana"; "Banana"; "Cereza"; "Uva"; "Kiwi"]
let resultado2 = filtarCadenas cadenas "na"
printfn "%A" resultado2

printfn "\nTercer ejercicio"
let resultado3 = n_esimo 2 [1;2;3;4;5]
printfn "%A" resultado3

printfn "\nCuarto ejercicio"
