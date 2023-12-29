function binaryRepresentation = decimalToBinary(decimalNumber, integerBits, fractionBits)
    % Konwersja liczby dziesiętnej na postać binarną

    % Określenie znaku
    signBit = '0';
    if decimalNumber < 0
        signBit = '1';
        decimalNumber = abs(decimalNumber);
    end
    
    % Podział na część całkowitą i ułamkową
    integerPart = fix(decimalNumber);
    fractionalPart = decimalNumber - integerPart;
    
    % Konwersja części całkowitej na postać binarną
    %integerBinary = dec2bin(integerPart),
    integerBinary = '';
    while integerPart > 0

        % najmłodszy bit części całkowitej
        bit = mod(integerPart, 2);

        integerBinary = [num2str(bit), integerBinary];
        integerPart = (integerPart - bit) / 2;
    end

    % Uzupełnienie zerami z przodu, jeśli jest to konieczne
    while length(integerBinary) < integerBits
        integerBinary = ['0', integerBinary];
    end

    % Konwersja części ułamkowej na postać binarną
    fractionalBinary = '';
    for i = 1:fractionBits
        
        % Przesunięcie bitowe
        fractionalPart = fractionalPart * 2;
        
        bit = fix(fractionalPart);
        fractionalBinary = [fractionalBinary, num2str(bit)];
        fractionalPart = fractionalPart - bit;
    end
    
    % Uzupełnienie zerami z przodu, jeśli jest to konieczne
    while length(fractionalBinary) < fractionBits
        fractionalBinary = ['0', fractionalBinary];
    end
    
    % Łączenie części całkowitej, ułamkowej i znaku
    binaryRepresentation = [signBit, integerBinary, fractionalBinary];
    
    
    disp(['Liczba binarna: ', binaryRepresentation]);




    % Binarna na dziesiętną, część całkowita
    
    decimalInteger = '';
    rozmiarInt = numel(integerBinary);
    dec = 0;
    
    for i = rozmiarInt:-1:1
        dec = dec + str2double(integerBinary(i)) * 2^(rozmiarInt - i);        
    end
    
    decimalInteger = [decimalInteger, num2str(dec)],
    
    % Binarna na dziesiętną, część dziesiętna
    
    decimalFrac = '';
    rozmiarFrac = numel(fractionalBinary);
    dec = 0;

    for i = 1:rozmiarFrac
        dec = dec + str2double(fractionalBinary(i)) * 2^-(i);        
    end
    
    %błąd spowodowany przybliżeniem double
    decimalFrac = [decimalFrac, num2str(dec)],
    decimalFrac = strrep(decimalFrac, '0.', '');
    
    if signBit == '1'
        decimalNum = ['-', decimalInteger, ".", decimalFrac];
    else
        decimalNum = [decimalInteger, ",", decimalFrac];
    end
    
    decimalNum,

end
