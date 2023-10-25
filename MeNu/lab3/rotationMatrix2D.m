function [Matrix] = rotationMatrix2D(x_degree,y_degree)
    x = x_degree/360*2*pi;
    y = y_degree/360*2*pi;
    Matrix = [[cos(x) -sin(y)];
     [sin(x) cos(y)]];
end

