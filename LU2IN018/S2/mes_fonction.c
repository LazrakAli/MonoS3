

int ma_fonction1(int v, int c) {
	if (c>=0 && v>=0) {
		if (v<=c) {
			for (int i=0;i<c;i++){
					printf("le plus grand ecarts est %d\n",i);
				}
			return c;
			}
		else {
			for (int i=0;i<v;i++){
				printf("le plus grand ecarts est %d\n",i);
			}
			return v;
		}
	}
	printf("il n'as pas d'ecart positif");
	return 0;
		}
}
