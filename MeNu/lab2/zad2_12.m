format long e
for p = 0:15
    fprintf("At= %d, f1(x)=%.18f, f2(x)=%.18f\n",10^p,f1(10^p),f2(10^p));
    if p==10
        fprintf("\t sqrt(x+1)=\t %.13f\n",sqrt((10^p)+1))
        fprintf("\t sqrt(x)=\t %.13f\n",sqrt(10^p))
        fprintf("\t diff=\t %.23f\n",sqrt((10^p)+1)-sqrt(10^p))
        fprintf("\t sum=\t %.23f\n",sqrt((10^p)+1)+sqrt(10^p))
    end
end