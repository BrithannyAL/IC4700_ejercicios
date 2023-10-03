femenino(petra).
femenino(carmen).
femenino(maria).
femenino(rosa).
femenino(ana).
femenino(cande).

madre(petra, juan).
madre(petra, rosa).
madre(carmen, pedro).
madre(maria, ana).
madre(maria, enrique).
madre(rosa, raul).
madre(rosa, alfonso).
madre(rosa, cande).

masculino(angel).
masculino(pepe).
masculino(juan).
masculino(pedro).
masculino(enrique).
masculino(raul).
masculino(alfonso).

:-dynamic padre/2.
padre(angel, juan).
padre(angel, rosa).
padre(pepe, pedro).
padre(juan, ana).
padre(juan, enrique).
padre(pedro, raul).
padre(pedro, alfonso).
padre(pedro, cande).

hermano(X,Y):-
    masculino(X),
    progenitor(Z,X),
    progenitor(Z,Y),
    X\=Y.
hermana(X,Y):-
    femenino(X),
    progenitor(Z,X),
    progenitor(Z,Y),
    X\=Y.

:-dynamic hermanoEncontrado/1.

hermanoNoRepetido(X,Y):-
    masculino(X),
    retractall(hermanoEncontrado(_)),
    hermano(X,Y),
    not(hermanoEncontrado(Y)),
    assert(hermanoEncontrado(Y)).

hermanaNoRepetido(X,Y):-
    femenino(X),
    retractall(hermanoEncontrado(_)),
    hermana(X,Y),
    not(hermanoEncontrado(Y)),
    assert(hermanoEncontrado(Y)).


tio(X,Y):-
    masculino(X),
    hermanoNoRepetido(X,Z),
    progenitor(Z,Y).

tia(X,Y):-
    femenino(X),
    hermanaNoRepetido(X,Z),
    progenitor(Z,Y).

progenitor(X, Y) :- padre(X, Y).
progenitor(X, Y) :- madre(X, Y).

abuelo(X, Y) :- padre(X, Z), progenitor(Z, Y).
abuela(X, Y) :- madre(X, Z), progenitor(Z, Y).

allNietos(X,Y):-abuelo(X,Y),write(Y),nl,fail.
allNietos(X,Y):-abuela(X,Y),write(Y),nl,fail.
allNietos(_,_).

not2(X):-X,!,fail.
not2(_).
