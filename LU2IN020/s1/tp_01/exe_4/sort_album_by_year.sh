
# Ali Lazrak 280605235

# Question 9
ANNEE_DEBUT=1955
ANNEE_FIN=2016

for d in $(seq $ANNEE_DEBUT $ANNEE_FIN)
do
	mkdir -p by_year/$d
	cp *$d*.flac by_year/$d
done


