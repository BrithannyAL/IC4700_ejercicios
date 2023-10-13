persona("Brithanny", "Arguello", [1,0,0,1,0,0,1,1,1,0]).
persona("Carlos", "Perez", [1,1,0,0,1,0,0,1,0,1]).
persona("Maria", "Garcia", [0,1,1,0,1,1,0,0,1,0]).
persona("Juan", "Lopez", [1,0,1,0,0,1,1,1,0,0]).
persona("Fabricio", "Rodriguez", [0,1,0,1,0,1,1,0,0,1]).
persona("Ana", "Martinez", [1,0,0,1,1,0,1,0,1,1]).
persona("Miguel", "Sanchez", [0,1,0,1,0,1,0,1,1,0]).
persona("Elena", "Diaz", [1,0,1,1,0,1,0,0,1,1]).
persona("Pablo", "Gomez", [0,1,0,1,1,0,1,0,0,1]).
persona("Laura", "Rojas", [1,1,0,0,1,1,0,1,0,1]).

persona_mas_parecida(X, Nombre) :-
    persona(Nombre, _, Cromosoma),
    contar_aciertos(X, Cromosoma, 0, MaxContador),
    not((persona(_, _, OtroCromosoma),
         contar_aciertos(X, OtroCromosoma, 0, OtroContador),
         OtroContador > MaxContador)).

contar_aciertos([], [], Contador, Contador).
contar_aciertos([X|RestoX], [X|RestoY], TempContador, Contador) :-
    NuevoContador is TempContador + 1,
    contar_aciertos(RestoX, RestoY, NuevoContador, Contador).
contar_aciertos([_|RestoX], [_|RestoY], TempContador, Contador) :-
    contar_aciertos(RestoX, RestoY, TempContador, Contador).
