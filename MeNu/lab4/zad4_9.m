A = [10, -7, 0;
     -3,  2, 6;
      5, -1, 5];
[L, U] = lu(A), %Problem z algorytmem ?

b = [5;11;8];
y(1)=b(1);
[N,N] = size(A);
N,

for i=2:N
    y(i,1) = b(i)- L(i,1:i-1)*y(1:i-1,1);
end
y,
% Drugie równanie: U*x = y --> x=?
x(N,1)=y(N)/U(N,N);
for i=N-1:-1:1
    x(i,1) = (1/U(i,i)) * ( y(i) - U(i,i+1:N)*x(i+1:N) );
end

x,