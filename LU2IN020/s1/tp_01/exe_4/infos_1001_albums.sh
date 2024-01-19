

# Ali   Lazrak     28605235

# Question 4
echo "Les albums recommandés des Beatles sont: "
ls *Beatles*
echo

# Question 5
echo "Le.s album.s dont les nom est une simple lettre sont: "
ls *-[A-z]-*.flac
echo

# Question 6
CPT=0
for f in *.flac
do
	CPT=$(( $CPT + 1 ))
done
echo -e "Cette collection comporte $CPT albums.\n"

# Question 7
SOMME=0
for f in *.flac
do
	SOMME=$(( $SOMME + ${#f} ))
done
MOYENNE=$(( SOMME / CPT ))
echo -e "La longueur moyenne des noms de fichiers est de $MOYENNE caractères.\n"

# Question 8
for f in *.flac
do
	ANNEE_DECALE=${f:(-9):(4)}
	annees[ANNEE_DECALE]+='X'
done

for a in "${!annees[@]}"
do
	echo "$a:" ${annees[$a]}
done
