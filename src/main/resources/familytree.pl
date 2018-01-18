male(ravi).
male(ram).
male(km).
male(jam).
male(sri).

female(vidya).
female(parvathi).
female(sudha).
female(samhi).


parent(ravi, ram).
parent(vidya, ram).
parent(ravi, sam).
parent(vidya, sam).
parent(km, vidya).
parent(parvathi, vidya).
parent(km, sudha).
parent(parvathi, sudha).
parent(sudha, samhi).
parent(sri, samhi).


ancestor(X, Y) :- parent(X, Y).

ancestor(X, Y) :-  parent(X, Z), ancestor(Z, Y). 

grandfather(X, Y) :- male(X), parent(X,Z), parent(Z, Y).

grandmother(X, Y) :- female(X), parent(X,Z), parent(Z, Y).

sibling(X, Y) :- parent(Z,X), parent(Z,Y), X\=Y.

aunt(X,Y) :- sibling(X,Par),parent(Par,Y).

cousin(X,Y) :- aunt(Z , X),parent(Z,Y).

