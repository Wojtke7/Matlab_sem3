function L = myCholesky(A)

    [N, N] = size(A);
    L = zeros(N, N);
    L(1,1) =  sqrt(A(1,1));

    for i = 1:N
        for j = 1:i
            if i == j
                L(i, j) = sqrt(A(i, i) - sum(L(i, 1:i-1).^2));
            else
                L(i, j) = (A(i, j) - sum(L(i, 1:j-1) .* L(j, 1:j-1))) / L(j, j);
            end
        end
    end
end

