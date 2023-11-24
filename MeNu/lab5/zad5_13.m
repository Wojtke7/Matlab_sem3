clear all; 
close all;
clc;

left_boundary = -2*pi;
right_boundary = 2*pi;

% Funkcja dokladnie - malymi kroczkami
x = ( left_boundary : 0.01 : right_boundary)';
y = cos(x);
% Wezly - zgrubnie - duze kroki
xk = ( left_boundary : 0.5*pi : right_boundary)';
yk = cos(xk);
% Linear spline
yi = interp1(xk,yk,x,'linear');
figure; plot(x,y,'r',xk,yk,'ko',x,yi,'b.'); xlabel('x'); title('y(x) linear'); grid;
% Cubic spline
yi = interp1(xk,yk,x,'cubic');
figure; plot(x,y,'r',xk,yk,'ko',x,yi,'b.'); xlabel('x'); title('y(x) cubic'); grid;
% Cubic spline ze Spline Toolbox
cs = spline(x,[0; y; 0]);
yi = ppval(cs,x);
figure; plot(x,y,'r-', xk,yk,'ko', x,yi,'b.-'); xlabel('x'); title('y=f(x) cubic (Spline toolbox)'); grid;