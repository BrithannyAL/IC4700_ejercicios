conc([], L, L).
conc([H|T], L2, [H|Zs]):-conc(T, L2,Zs).

%%patron(oscar,universidad).
patron(smith,nasa).
patron(pratt,nasa).
patron(carlos,tienda).

editor(oscar,prenticehall).
editor(pratt,prenticehall).

%%empleadoPublica(Empresa,Editorial,Persona).
empleadoPublica(Empresa,Editorial,Persona):-
    patron(Persona,Empresa),editor(Persona,Editorial).
