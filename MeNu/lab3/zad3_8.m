clear all;
N = 2^13; % Ilość probek 8196
[canary, canary_fpr] = audioread('canary.wav', [1, N]);
[elephant, elephant_fpr] = audioread('elephant.wav', [1, N]);
% Dźwięk poszczególnych ściezek na wykresie
figure; plot(canary); title('Dźwięk kanarka');
figure; plot(elephant); title('Dźwięk słonia'); 
% Nałożone ścieżki dźwiękowe
overlaid = canary + elephant;
% Parametry z pdf
n=0:N-1; 
k=0:N-1;
A = sqrt(2/N)*cos( pi/N *(k'*n));
 % Widma czestotliwosciowe
canary_freq_spectrum = A * canary;
elephant_freq_spectrum = A * elephant;
figure; plot(canary_freq_spectrum); title('Widmo częstotliwościowe kanarka');
figure; plot(elephant_freq_spectrum); title('Widmo częstotliwościowe słonia');
% widmo czestotliwosciowe laczonej sciezki dzwiekowej
overlaid_spectrum = A * overlaid;
figure; plot(overlaid_spectrum); title('Widmo częstotliwościowe nałożonych ścieżek');
% odejmuje od laczonego widma, widmo słonia
back_canary_fs = overlaid_spectrum - elephant_freq_spectrum;
% zmieniam widmo spowrotem na sciezke dzwiekową
back_canary    = A^-1 * back_canary_fs;
figure; plot(back_canary); title('Odzyskana ścieżki dźwiękowej kanarka');
