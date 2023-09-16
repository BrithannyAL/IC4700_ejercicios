module RutaCorta

open Recipientes

// Grafo de prueba
let grafo = [
    ("i", ["a"; "b"]);
    ("a", ["i"; "c"; "d"]);
    ("b", ["i"; "c"; "d"]);
    ("c", ["a"; "b"; "x"]);
    ("d", ["a"; "b"; "f"]);
    ("f", ["d"]);
    ("x", ["c"])
]

//Grafo del laberinto
let laberintoConParedes = [
    (1, [7]);           (2, [3; 8]);        (3, [2; 9; 4]);
    (4, [3; 10]);       (5, [6; 11]);       (6, [5]);
    (7, [1; 13]);       (8, [2; 9]);        (9, [8; 3]);
    (10, [4; 16]);      (11, [5; 17]);      (12, [18]);
    (13, [7; 14]);      (14, [13; 15; 20]); (15, [14; 21]);
    (16, [10; 22]);     (17, [11; 23]);     (18, [12; 24]);
    (19, [25]);         (20, [14; 26]);     (21, [15; 22]);
    (22, [16; 21]);     (23, [17; 29]);     (24, [18; 30]);
    (25, [19; 31]);     (26, [20; 27]);     (27, [26; 28]);
    (28, [27; 29; 34]); (29, [23; 28]);     (30, [24; 36]);
    (31, [25; 32]);     (32, [31; 33]);     (33, [32; 34]);
    (34, [28; 33; 35]); (35, [34; 36]);     (36, [30; 35])
]

let laberintoSinParedes = [
    (1, [2; 7]);        (2, [1; 3; 8]);     (3, [2; 4; 9]);
    (4, [3; 5; 10]);    (5, [4; 6; 11]);    (6, [5; 12]);
    (7, [1; 8; 13]);    (8, [2; 7; 9]);     (9, [3; 8; 10]);
    (10, [4; 9; 16]);   (11, [5; 12; 17]);  (12, [6; 11; 18]);
    (13, [7; 14; 19]);  (14, [13; 15; 20]); (15, [14; 21]);
    (16, [10; 22]);     (17, [11; 18; 23]); (18, [12; 17; 24]);
    (19, [13; 20; 25]); (20, [14; 19; 26]); (21, [15; 22; 27]);
    (22, [16; 21; 28]); (23, [17; 24; 29]); (24, [18; 23; 30]);
    (25, [19; 26; 31]); (26, [20; 25; 27]); (27, [21; 26; 28; 33]);
    (28, [22; 27; 29]); (29, [23; 28; 35]); (30, [24; 36]);
    (31, [25; 32]);     (32, [31; 33]);     (33, [27; 32; 34]);
    (34, [33; 35]);     (35, [29; 34; 36]); (36, [30; 35]);
]


// Función para generar vecinos
let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

// Función para extender una ruta
let extender ruta grafo = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta) grafo)) 

// Función principal de búsqueda en profundidad
let rec prof2 ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) :: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)  ) grafo
    prof_aux fin [[ini]] grafo

let rutaCortaLaberinto rutas =
    match rutas with
    | [] -> None // No hay rutas disponibles
    | [ruta] -> Some ruta // Si solo hay una ruta, es la más corta
    | rutas -> // Si hay varias rutas, encuentra la más corta
        let rutaMasCorta = List.minBy List.length rutas
        Some rutaMasCorta


//A partir de aquí es el código modificado

let grafoConPesos = [
    ("i", ["a"; "b"], [2; 3]);
    ("a", ["i"; "c"; "d"], [4; 5; 6]);
    ("b", ["i"; "c"; "d"], [4; 7; 2]);
    ("c", ["a"; "b"; "x"], [8; 9; 1]);
    ("d", ["a"; "b"; "f"], [1; 8; 2]);
    ("f", ["d"], [2]);
    ("x", ["c"], [1])
]

// Función para generar vecinos
let rec vecinosPesos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors, weights) :: rest ->
        if head = nodo then List.zip neighbors weights
        else vecinosPesos nodo rest


let extenderPesos ruta grafo = 
    let nodoActual = List.head ruta
    let vecinos =
        match List.tryFind (fun (nodo, _, _) -> nodo = nodoActual) grafo with
        | Some (_, vecinos, _) -> vecinos
        | None -> []

    List.collect (fun vecino ->
        if not (List.exists (fun n -> n = vecino) ruta) then
            [vecino :: ruta]
        else
            []
        ) vecinos

let calcularPeso ruta grafo =
    List.fold (fun peso nodo ->
        match List.tryFind (fun (n, _, pesos) -> n = nodo) grafo with
        | Some (_, _, pesos) ->
            let pesoNodo = List.head pesos
            peso + pesoNodo
        | None -> peso
    ) 0 ruta

let encontrarRutaMasCorta rutas grafo =
    let mutable rutaMasCorta = []
    let mutable pesoMasCorto = System.Int32.MaxValue 
    for ruta in rutas do
        let peso = calcularPeso ruta grafo
        if peso < pesoMasCorto then
            pesoMasCorto <- peso
            rutaMasCorta <- ruta
    rutaMasCorta, pesoMasCorto

let rec profPesos ini fin grafo =
    let rec prof_aux fin rutas grafo =
        match rutas with
        | [] -> []
        | ruta :: rest ->
            if List.head ruta = fin then
                ruta :: prof_aux fin (rest @ (extenderPesos ruta grafo)) grafo
            else
                prof_aux fin (rest @ (extenderPesos ruta grafo)) grafo
    prof_aux fin [ [ini] ] grafo

let busquedaProf ini fin grafo =
    let rutas = profPesos ini fin grafo
    let ruta, peso = encontrarRutaMasCorta rutas grafoConPesos
    ruta, peso



