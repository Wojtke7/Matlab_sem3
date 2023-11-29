syms x;
y = @(x) sin(x);

h = pi/8;
x0 = pi/8;

xs = [x0-h, x0, x0+h],
ys = [y(x0-h), y(x0), y(x0+h)],

%Przybliżanie całki
a=1/2; b=1; c=1/2;
%Suma trapezów
A1 = h*(a*ys(1) + b*ys(2) + c*ys(3)),
%Dokładna wartość: 0.2929
%Wartość przybliżona: 0.2891


%Przybliżanie pochodnej
a2=0; b2=-1;, c2=1;
%Iloraz różnicowy 
A2 = 1/h*(a2*ys(1) + b2*ys(2) + c2*ys(3)),
%Wartość przybliżona równa wartości dokładnej 



% FUunkcję sinus przybliża się wielomianem taylora (?)