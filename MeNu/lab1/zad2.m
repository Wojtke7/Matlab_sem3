a = 1;
b = 2;
c = -3;

sqrt_sum = b^2 - 4*a*c;
zero1 = (-b + sqrt(sqrt_sum))/(2 * a),
zero2 = (-b - sqrt(sqrt_sum))/(2 * a),

a*zero1^2+b*zero1+c == 0,
a*zero2^2+b*zero2+c == 0,

x=-10:10;
y = a*x.^2+b*x+c;
plot(x,y),
[~,imn] = min(y);
[~,imx] = max(y);
hold on

plot(x([imn;imx]), y([imn;imx]), 'or'),

