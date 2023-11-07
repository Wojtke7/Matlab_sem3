% equnonlin_invmat.m
% A*x = b, x=?
clear all; close all;
A = [ 1 2; ...
3 4 ];
b = [ 5; ...
11 ];

A=A+0.1*randn(size(A));
%Wprowadzenie szumu nie powoduje rozbieżności wyników w dwóch metodach

x1 = inv(A)*b, % x=A^(-1)*b
x2 = A\b, % optymalne rozwiazywanie rown. Ax=b
x3 = pinv(A)*b, % x = inv( A’*A ) * A’ * b , sprawdzisz?

%Przy zmianie wyznacznika z -2 na 1 nadal wszystko ok
%Przy zmianie wyznacznika z -2 na 0.5 (A(1,2) == 7/6) err wynosi 1,7764e-15
%Przy zmianie wyznacnzika z -2 na -0.02 bład (A(1,2) == 1.34) wynosi 5.6843e-14

bhat = A*x1, % sprawdzenie
err = max(abs(x1-x2)), % blad

A = [ 1, 2, 3; ...
3, 44, 5;
7, 8, 9];
b = [ 5; ...
11;
10];
det(A),

x1 = inv(A)*b,
x2 = A\b,
x3 = pinv(A)*b,

bhat = A*x1,
err = max(abs(x1-x2)), 
%W tym przypadku dhat nie różni się od d(w użytej precyzji) a err wynosi    2.2204e-16
