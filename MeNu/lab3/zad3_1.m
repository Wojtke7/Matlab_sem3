u=[1;2;3];
v=[4;5;6]; 

A=[1,2,3;4,5,6;7,8,9], 
B=eye(3);

% 1.Mnozenie wektora poziomego przez macierz
(u')*v,

% 2.Iloczyn wektorowy dwóch wektorów
u*(v.'),

% 3.Dodawanie macierzy o tych samych wymiarach
A + B,

% 4.Mnozenie macierzy A i B
A * B,

% 5.Mnozenie wektora poziomego przez macierz
(u.')*A,

% 6.Mnozenie macierzy przez wektor pionowy
A * u

7% 7.Mnozenie macierzy przez liczbę
5*A

% 8.Łączność i przemienność operacji macierzowych 
(A+B)*u,
A*u+B*u,
B*u+A*u,

% 9.Macierz odwrotna
C=[1,2;3,4];
inv(C),

% 10. Równanie macierzowe 
x=[1;2];
b=C*x;
x=inv(C)*b,

% 11. Wielomian charakterystyczny macierzy kwadratowej 
poly(A),

% 12. Wyznacznik macierzy 
det(C),

% 13. Rząd macierzy
rank(A),

% 14.Forma kwadratowa
(x.')*C*x,

% 15. Dekompozycja EVD macierzy
S=[2,1;1,2],
[V,D]=eig(S),
S=V*D*V',

% 16. Dekompozycja SVD macierzy
[U,D,V]=svd(C),
C=U*D*V'