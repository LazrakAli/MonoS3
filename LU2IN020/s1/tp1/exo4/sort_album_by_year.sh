# Question 9

for d in {1955..2016};do
	mkdir -p by_year/$d
	cp ./1001_Albums_You_Must_Hear_Before_You_Die/*$d*.flac ./by_year/$d
done

