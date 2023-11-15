A = [1, 1, 1;
     1,  2, 3;
      1, 3, 4];
%[L, U] = lu(A), %Problem z funkcją ?
[L, U] = myLU(A),

b = [3;0;-2];
y(1)=b(1);
[N,N] = size(A);

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