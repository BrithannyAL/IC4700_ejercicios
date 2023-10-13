conectado(i,2).
conectado(2,3).
conectado(2,8).
conectado(8,9).
conectado(9,3).
conectado(3,4).
conectado(4,10).
conectado(10,16).
conectado(16,22).
conectado(22,21).
conectado(21,15).
conectado(15,14).
conectado(14,13).
conectado(13,7).
conectado(7,1).
conectado(14,20).
conectado(20,26).
conectado(22,28).
conectado(26,27).
conectado(27,28).
conectado(28,29).
conectado(29,23).
conectado(23,17).
conectado(17,11).
conectado(11,5).
conectado(1,7).
conectado(5,6).
conectado(28,34).
conectado(34,35).
conectado(35,36).
conectado(36,30).
conectado(30,24).
conectado(24,18).
conectado(18,12).
conectado(32,31).
conectado(31,25).
conectado(25,19).
conectado(34,33).
conectado(33,32).
conectado(32,f).

ruta(X,Y,L):- ruta_aux(X,Y,[],L).

ruta_aux(X,X,L,LFinal):- reverse(L,LFinal).
ruta_aux(X,Y,L,Resultado):-
	conectado(X,X1),
	not(member(X1,L)),
	ruta_aux(X1,Y,[X|L],Resultado).

todas_rutas(X,Y,LRutas):- findall(R,ruta(X,Y,R),LRutas).

imprimir_rutas([]).
imprimir_rutas([HeadRutas|TailRutas]):-
	imprimir_rutas(TailRutas),
	write(HeadRutas),nl.

ruta_corta(X, Y, RutaCorta) :-
    findall([Ruta, Peso], (ruta(X, Y, Ruta), calcular_peso(Ruta, Peso)), Rutas),
    sort(2, @=<, Rutas, [RutaCorta | _]).

calcular_peso([], 0).
calcular_peso([_], 0).
calcular_peso([_, Y | Resto], Peso) :-
    calcular_peso([Y | Resto], PesoResto),
    Peso is PesoResto + Y.
