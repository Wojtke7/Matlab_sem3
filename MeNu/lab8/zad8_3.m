% evd_power.m
clear all; close all; clc;

if(1) A = [ 4 0.5, 6; 0.5 1, 5; 6,7,8 ];       % wybor/definicja symetrycznej macierzy kwadratowej
else  A = magic(4);
end
[ N, N ] = size(A);               % wymiar 

x = ones(N,1);                    % inicjalizacja
for i = 1:20                      % poczatek petli
    y = A*x;                      % pierwsze mnozenie
    [ymax,imax] = max(abs(y));    % najwieksza wartosc abs() i jej indeks
    x = y/ymax;                   % wektor wlasny
    lambda = ymax;                % wartosc wlasna ymax=y(imax)
end                               % koniec petli
x, lambda,                        % pokaz wynik: max wartosc wlasna i wektor wlasny
[ V, D ] = eig(A)                 % porownaj z funkcja Matlaba

% Wektor własny x jest normalizowany przez podzielenie go przez max wartośc
% bezwzgl, tutaj mogą wystąpic rozbieżnośći
% Algorytm zaimplementowany jest potęgwy (dośc prosty), a EiG dopiera
% algorytm w zależności od podanej macierzy 
