clear all; 
close all;
clc;

A = [ 2 0 1; 0 -2 0; 1 0 2 ]; 
[N,N] = size(A);
% Pojedyncza rotacja zerujaca element A(p,q) macierzy A
[R, D] = solve(A)
display(R'*D*R);
pause;

% Macierz symetryczna 4x4
A = [4 5 6 7;
       5 6 7 8;
       6 7 8 9;
       7 8 9 10;];

[R, D] = solve(A)

function [R, D] = solve(A)
   D = A; 
   [N, N] = size(D);
   R = eye(N);
   while (true) %pętla do momentu gdy macierz D ma element do wyzerowania
       D_abs = abs(D - tril(D)); % utworzenie macierzy zawierającej tylko wartości nad główną przekątną 
       [v, x, y] = mmax(D_abs); % znalezienie maksymalnej wartości macierzy oraz jej indeksów
       assert(D_abs(y, x) == v); %sprawdzenie czy przypadkiem x nie równe -1 

    % jeśli w macierzy D zostały jeszcze wartości nie wyzerowane
       if (abs(v) > 0.000001)
           Ri = rotation_matrix( y, x, D);
           D = Ri.' * D * Ri;
           R = R * Ri;
       else
           return
       end
   end
end

%Funkcja znajdujące największą wartość w macierzy oraz jej indeksy
function [v, x, y] = mmax(A)
   [N, N] = size(A);
   [v, i] = max(A, [], 'all'); % znalezeinie maks wartości w macierzy A, i (indeks w indeksacji jednowymiarowej)
   
   % indeksowanie (x,y)
   x = fix(i / N) + 1;
   y = rem(i, N);
   
   if (x == 0)
       y = N;
       x = x - 1;
       return
   end
end

%funckaj z listingu 8.4
function [Ri] = rotation_matrix(p, q, A)
   xi = (A(q,q) - A(p,p)) / 2 / A(p,q); %obliczenie xi
   if( xi > -eps )
       t =  (abs(xi) + sqrt(1 + xi^2)); %obliczenie t
   else
       t = -(abs(xi) + sqrt(1 + xi^2));
   end
  
   c = 1 / sqrt(1+t^2);
   s = t * c;
   [N, N] = size(A);
   Ri = eye(N);
   Ri(p, p) = c;
   Ri(q, q) = c;
   Ri(p, q) = -s;
   Ri(q, p) = s;
end