function [Q, R] = qrHouseholder(A)
    [m, n] = size(A);
    Q = zeros(m,n);
    R = A;
    M = cell(n,1);

    for k = 1:m-1 %Rozpoczynamy iterację po kolumnach od 1 do  (m-1) 
        test = zeros(m,1);
        test(k) = 1;
        x = R(:, k), %Pobieramy kolumnę k z macierzy R i przypisujemy ją do wektora x
        if k-1 ~= 0
            x(k-1,1)=0; 
        end

        v = x + norm(x) * test, % obliczamy v przez dodanie do wektora x 
     
        I = eye(m);

        H=I-((2*v*v')/(v'*v));
        R = H*R;
        M{k}=H;
    end
    Q = M{1}*M{2}; 
end

%https://www.if.pw.edu.pl/~agatka/numeryczne/wyklad_04.pdf
%Dla każdej kolumny j od k do n, obliczamy [Q,R] = qrHouseholder(test);
%nową wartość elementu R(i, j) w macierzy R za pomocą równania Householdera: R(k:m, k:n) = R(k:m, k:n) - 2 * v * (v' * R(k:m, k:n)). To pomaga w zerowaniu elementów pod diagonalką w macierzy R.