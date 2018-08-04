
PirS{
	
	classvar <n; classvar <q;  classvar <server;

	*start{arg direccion = "127.0.0.1", puerto = 5612;
		
		
		("-----|||PiranhaLib|||-----").postln;
		//("-----|||Ajúuuuuuua|||-----").postln;
		n = NetAddr(direccion, puerto);
		server = Server.local;
		
	}

	*history{arg name = \PirataVivo;

		(
		q = ();
		NetAddr.broadcastFlag = true;
		q.addrs = (0..7).collect { |x|
			NetAddr("255.255.255.255", 57120 + x)
		};
		q.sendAll = { |q ... args|
			q.addrs.do { |addr|
				addr.sendMsg(*args)
			}; ""
		}
		);

		(
		History.start;
		//History.makeWin;

		OSCdef(\hist, { |msg|
			msg.postln;
			History.enter(msg[2].asString, msg[1]);
		}, \hist).fix;

		History.localOff;

		History.forwardFunc = { |code|
			q.sendAll(\hist, name, code);
		}
		)
		
	}
	
}
