module ejercicio1

//Para la creación de las lista mutables
open System.Collections.Generic

//La función recibe dos parámetros, una lista de string y un string
let filtarCadenas (lista: string list) (subcadena: string) =
    List.filter (fun (cadena : string)-> cadena.Contains(subcadena)) lista
    //Filtra las cadenas que poseen la subcadena designada por el usuario

//Función que recibe una lista de enterros y devuelve el entero que se encuentra en el indice
let n_esimo (indice: int) (lista: int list) =
    let resultado = List.mapi(fun indx num -> if indx = indice then Some num else None) lista
    let elementos = List.choose id resultado
    match elementos with
    | [e] -> Some e
    | _ -> None

//Hace un shift (a la derecha o izquierda) en la lista la cantidad de pasos indicada por el usuario
let shift_fun (n:int) (dir:string) (lista:int list) =
    if dir = "der" then
        let resultado = List.mapi(fun i num -> if i <= n-1 then 0 else lista.[i-n]) lista
        resultado
    else 
        let resultado = List.mapi(fun i num -> if i > (lista.Length-n)-1 then 0 else lista.[i+n]) lista
        resultado