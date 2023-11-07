A = [ 1 2; ...
3 4 ];

b = [ 5; ...
11 ];

x1 = inv(A)*b,
x2 = A\b,
x3 = pinv(A)*b,
x4 = fCramer(A, b),

bhat = A*x1, % sprawdzenie
err = max(abs(x1-x2)), % blad

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% ZMIANA WYZNACZNIKA

A(1,2) = 7/6;


x1 = inv(A)*b,
x2 = A\b,
x3 = pinv(A)*b,
x4 = fCramer(A, b),

bhat = A*x1, % sprawdzenie
err = max(abs(x4-x1)), % blad

%%%%%%%%%%%%%%%%%%%%%%%%%%

A(1,2) = 1.34;


x1 = inv(A)*b,
x2 = A\b,
x3 = pinv(A)*b,
x4 = fCramer(A, b),

bhat = A*x1, % sprawdzenie
err = max(abs(x4-x1)), % blad

%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% ZMIANA SZUMU
A = [ 1 2; ...
3 4 ];

A=A+0.1*randn(size(A));

x1 = inv(A)*b,
x2 = A\b,
x3 = pinv(A)*b,
x4 = fCramer(A, b),

bhat = A*x1, % sprawdzenie
err = max(abs(x4-x1)), % blad
