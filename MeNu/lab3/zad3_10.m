close all;
hold off;
Z = [[7 2];
     [5 5];
     [4 4]];
babiaGora = load("babia_gora.dat");  
% [ x y z ]
plot3(babiaGora(:,1),babiaGora(:,2),babiaGora(:,3));fill3(babiaGora(:,1),babiaGora(:,2),babiaGora(:,3),'y');title("bez rotacji");

rotated_babiaGora = babiaGora * rotationMatrixDeg(90,90,180);

figure;plot3(rotated_babiaGora(:,1),rotated_babiaGora(:,2),rotated_babiaGora(:,3));fill3(rotated_babiaGora(:,1),rotated_babiaGora(:,2),rotated_babiaGora(:,3),'r');title("rotacjai");

figure;plot(Z(:,1),Z(:,2),'linewidth',4);title("bez rotacji");

rotated_Z = Z*rotationMatrix2D(90,90); 

figure;plot(rotated_Z(:,1),rotated_Z(:,2),'linewidth',4);title("rotacja");