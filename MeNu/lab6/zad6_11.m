clear all;
close all;
clc;

p2 = @(x, A0, A1, A2, B1, B2) (A0 + A1*x + A2*x.^2)./(1 + B1*x + B2 * x.^2);
xVal = linspace(-5,5,100);

syms x;
taylorF = taylor(erf(x), 'Order', 5)

syms A0 A1 A2 A3 B1 B2 B3;

equations2 = [A0 == 0, A1 == 2/pi^(1/2), A2 == 0, B2 == 1/3, B1 == 0];

sol = solve(equations2, [A0, A1, A2, B1, B2]);
disp(sol);


miro2 = imread("6_11.png");
figure;
imshow(miro2);
title("Obliczenia dla stopnia drugiego");

figure;
plot(xVal, erf(xVal),"g-");
hold on;
plot(xVal, p2(xVal, sol.A0, sol.A1, sol.A2, sol.B1, sol.B2), "r-");
legend("original", "Pade 2,2");