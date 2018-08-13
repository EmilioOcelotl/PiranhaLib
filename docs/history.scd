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

//hola

(

PirS.start;
PirS.n.sendMsg("/textON", 1);

History.start;
//History.makeWin;

OSCdef(\hist, { |msg|
	msg.postln;
	History.enter(msg[2].asString, msg[1]);
}, \hist).fix;

OSCdef(\ofx, { |msg|
	PirS.n.sendMsg("/message", msg[2].asString, msg[1].asString);
}, \hist);


History.localOff;

History.forwardFunc = { |code|
	//q.sendAll(\hist, \killall, code);
	q.sendAll(\hist, \emi, code);
};

)