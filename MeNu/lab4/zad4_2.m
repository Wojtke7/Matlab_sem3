A = [[1 2 3];
     [2 8 10];
     [3 10 22]];
A,
L = myCholesky(A),

L_MATLAB = chol(A),

test = L*transpose(L);