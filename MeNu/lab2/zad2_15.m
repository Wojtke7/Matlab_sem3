frequency = 20; 
probe_frequency = 192000; 
initial_angle = 0;
iteration_count=50000; 
omega_zero = 2*pi*frequency/probe_frequency;
a = 2*cos(omega_zero);

y=[sin(initial_angle+omega_zero),sin(initial_angle+2*omega_zero)];
x=zeros(1,iteration_count);

x(2)=omega_zero;

for i=3:iteration_count
   y(i)=a*y(i-1)-y(i-2);
   x(i)=x(i-1)+omega_zero;
end

plot(x,y);
title("Wykres wynikowy");
xlabel("radiany");
ylabel("sin(x)");