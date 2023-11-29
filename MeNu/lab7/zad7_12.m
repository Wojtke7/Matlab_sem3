syms x;
f = @(x) sin(x);
F = @(x) cos(x);

dt_cos = (pi/2 + pi/2)/2;

dt_sin = (pi)/2;

q = quadl(F, -pi/2, pi/2),
q2 = quadl(f,0, pi),


wages3 = [5/9, 8/9, 5/9]; 
nodes3 = [-sqrt(3/5), 0, sqrt(3/5)];
%wagi i węzły mają być zgodne z tymi wyprowadzonymi dla kwadratury Gaussa-Legendra

% 3-punktowa cos
field_cos3 = 0;
N = 3;
for k=1:N
    field_cos3= field_cos3 + wages3(k)*F(0 + ((pi/2) * nodes3(k)));
end

field_cos3 = dt_cos * field_cos3,
err = abs(q - field_cos3),

% 3-punktowa sin
field_sin3 = 0;
N = 3;
for k=1:N
    field_sin3= field_sin3 + wages3(k)*f(pi/2 + ((pi/2) * nodes3(k)));
end

field_sin3 = dt_sin * field_sin3,
err2 = abs(q2 - field_sin3),


wages2 = [1,1];
nodes2 = [-1/sqrt(3), 1/sqrt(3)];

% 2-punktowa cos 
field_cos2 = 0;
N=2;

for k=1:N
    field_cos2= field_cos2 + wages2(k)*F(0 + ((pi/2) * nodes2(k)));
end

field_cos2 = dt_cos * field_cos2,
err3 = abs(q - field_cos2),

% 2-punktowa sin
field_sin2 = 0;
N=2;

for k=1:N
    field_sin2= field_sin2 + wages2(k)*f(pi/2 + ((pi/2) * nodes2(k)));
end

field_sin2 = dt_sin * field_sin2,
err4 = abs(q2 - field_sin2),

