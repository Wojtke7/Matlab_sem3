# Deklaracja i inicjalizacja
A = Int64(1234)
F = Float16(1.125)
B = Float64(A)

# Proste funkcje na zmiennych
tol = eps(Float16), eps(Float32), eps(Float64), eps(BigFloat)
println("Proste funkcje na zmiennych", tol)

println("Reprezentacja bitowa liczby zmiennoprzecinkowej Float 32: -0.009765625 ", bitstring(Float32(-0.009765625)))
println("Reprezentacja bitowa liczby zmiennoprzecinkowej Float 32: minus nieskończoność ", bitstring(Float32(-Inf)))

result = Float16(1.) + eps(Float64)
println(result)

a = Float16(1.25)
b = a + eps(Float16)
println("Dokładność liczby w formacie Float16: ", eps(Float16))
println(b)
println("Reprezentacja bitowa sumy liczb 1.25 oraz jej dokładnośći: ", bitstring(b))
