open Recipientes
open RutaCorta

printfn "\nBusqueda de profundidad del grafo con pesos"
let rutaCorta, pesoRuta = busquedaProf "i" "f" grafoConPesos
printfn "La ruta más corta es %A" rutaCorta
printfn "Con un peso de %d" pesoRuta

//NOTA IMPORTANTE:
//Hay dos laberintos, uno sin paredes y otro con paredes, las funciones se aplican a
//ambos laberintos, pero cuando se intenta hacer una busqueda en profundidad del
//laberinto sin paredes, este se encicla.
//Puede ser a causa de la cantidad de posibilidades para resolverlo, pero en el
//laberinto con paredes funciona muy bien

printfn "\nBusqueda a profundidad de laberinto"
let vec = vecinos 3 laberintoConParedes
printfn "Los vecinos del 3 son %A" vec
let ruta3 = extender vec laberintoConParedes
printfn "La ruta anterior extendida es %A" ruta3
let result = prof2 2 32 laberintoConParedes
printfn "Busqueda en profundidad del laberinto: %A" result
let rutaCortaLab = rutaCortaLaberinto result
printfn "La ruta más corta para resolver el laberinto con paredes es: %A" rutaCortaLab



//Cuando se quiere hacer una buqueda en profundidad con el laberinto sin paredes
//el programa en encicla
//  let result = prof2 2 32 laberintoSinParedes
//  printfn "Busqueda en profundidad del laberinto: %A" result
