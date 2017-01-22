# This creates the .class, .h, and libHW9.so files and runs the program.
all:
	javac HW9.java
	javah HW9
	gcc -shared -fPIC HW9.c -o libHW9.so -I/usr/jdk/jdk1.7.0_51/include/ -I/usr/jdk/jdk1.7.0_51/include/solaris
	java -Djava.library.path=. HW9

# This removes all created files, cleaning the directory
clean:
	rm HW9.class HW9.h libHW9.so
