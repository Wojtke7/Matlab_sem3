S = 20; 
syms r real
V = r * (S/2); 

V = diff(V), % optimal V 

r = (2*V)/S, % 

h = S/(2*pi*r) % 