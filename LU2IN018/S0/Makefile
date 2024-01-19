all : hello_world hello_world2 image

hello_world: hello_world.c
	gcc -Wall -o hello_world hello_world.c

hello_world2: hello_world2.c
	gcc -Wall -o hello_world2 hello_world2.c

image: image.c image.h
	gcc -Wall -o image image.c 
clean:
	rm -f hello_world
	rm -f hello_world2
	rm -f image