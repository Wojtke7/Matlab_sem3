% Tworzenie danych
x_values = linspace(-5, 5, 1000);
y_linear = 2 * x_values + 3;  % Przykładowa funkcja liniowa
y_delta = zeros(size(x_values));
y_delta(length(x_values)/2) = 1;  % Delta Diraca w punkcie zero

% Tworzenie wykresu
figure;
plot(x_values, y_linear, 'LineWidth', 2, 'DisplayName', 'Funkcja liniowa: 2x + 3');
hold on;
scatter(x_values, y_delta, 'ro', 'DisplayName', 'Delta Diraca');

% Ustawienia osi i etykiet
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
grid on;
xlabel('Oś X');
ylabel('Oś Y');
title('Wykres funkcji liniowej i Delta Diraca');
legend;

% Wyświetlenie wykresu
hold off;
