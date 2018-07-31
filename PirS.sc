
PirS{
	
	classvar <n;

	*start{arg direccion = "127.0.0.1", puerto = 5612;
		
		
		("-----|||PiranhaLib|||-----").postln;
		//("-----|||Ajúuuuuuua|||-----").postln;
		n = NetAddr(direccion, puerto);

	}
	
}
