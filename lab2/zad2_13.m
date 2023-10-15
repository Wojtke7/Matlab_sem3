format long

a = 5.9,
c = 4.2,
b = -1e+6*(4*a*c), pause

x1 = (-b +sqrt(b^2 - 4*a*c)) / (2*a),
x2 = (-b -sqrt(b^2 - 4*a*c)) / (2*a),


if abs(x1) > abs(x2)
    x2_changed = (2*c)/(-b +sqrt(b^2 - 4*a*c)),
else 
    x1_changed = (2*c)/(-b -sqrt(b^2 - 4*a*c)),
end