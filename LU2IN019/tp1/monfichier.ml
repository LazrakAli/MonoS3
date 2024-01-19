let rec factorielle (n:int) : int =
if n=0 then 1 else n * (factorielle (n-1));;
assert ((factorielle 0) = 1);;
assert ((factorielle 3) = 6);;
assert ((factorielle 3)=6);;


let rec sum_chiffres (n:int) :int =
  if n<10 then n else n mod 10+(sum_chiffres ((n-(n mod 10))/10));;
  assert ((sum_chiffres 125)=8);; 

let rec nb_chiffres(n:int):int=
  if n<10 then 1 else 1+(nb_chiffres (n/10));;
  assert ((nb_chiffres 125)=3);;


let rec less_divider(i:int)(n:int):int=
  if (n<=i) 
    then 0
  else if (n mod i=0) 
    then i 
  else (less_divider(i+1) n);; 
  assert ((less_divider 2 19)=0);;
  assert ((less_divider 7 21)=7);;
  assert ((less_divider 5 21)=7);;
  assert ((less_divider 9 21)=0);;


let prime(i:int) :bool=
  if (i<2) then false
  else if ((less_divider 2 i)=0) then true else false;;
  assert ((prime 1)=false);;
  assert ((prime 21)=false);;
  assert ((prime 19)=true);;

let rec next_prime(i:int):int=
  if (prime i = true) then i else (next_prime (i+1));;
assert ((next_prime 0)=2);;
assert ((next_prime 15)=17);;


let rec nth_prime(n:int):int=
  if (n<0) then failwith "invalid exponent"
  else if (n=0) then 2 
  else next_prime(nth_prime(n-1)+1);;
assert ((nth_prime 0)=2);;
assert ((nth_prime 1)=3);;
assert ((nth_prime 2)=5);;
assert ((nth_prime 12)=41);;