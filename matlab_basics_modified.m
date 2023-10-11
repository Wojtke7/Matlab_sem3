clear all; close all; echo on;
h = [1,2,3,5],
v = [4;5;6;7],
a=h*v,
A=v*h,
a=A*v,
b=h*A,
B=A*A,

%Czasami nalezy wykona  ̇ c ́ operacj ̨e transpozycji (.’) wektora/macierzy (za-
%mian ̨e wierszy z kolumnami), 

h*h.',
v*v.',
v.'*A,
A*h.',