a=fi( 1.625,0,8,7), a.bin,
b=fi( 0.375,0,8,7), b.bin,
c=fi( 0.375,1,8,7), c.bin,
d=fi(-0.375,1,8,7), d.bin,

e=fi(pi,0,8,6), e.bin,  
h=fi(pi,1,8,5), h.bin, % błąd ?
f=fi(pi,0,16,7), f.bin, % wartośc bitowa 3,140625
g=fi(pi,1,16,7), g.bin, % wartoś odczytana 3,140625

error_check8_unsinged = pi - e,
error_check8_singed = pi - h,
error_check16_unsinged = pi - f,
error_check16_singed = pi - g,

pi;