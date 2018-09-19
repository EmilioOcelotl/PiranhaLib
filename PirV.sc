
PirV{

	classvar <n;

	*load {arg pista = 1, video = "prueba";

		PirS.n.sendMsg("/load", pista, video); // Hace falta trabajar en piranhavivo para que esto solo cargue
		//PirS.n.sendMsg("/size", pista, tamX, tamY);
		//PirS.n.sendMsg("/opacity", pista, 255);
		//PirS.n.sendMsg("/speed", pista, 1);
		("Cargaste el video ").post;
		(video).post;
		(" en la pista ").post;
		(pista).postln;

	}

	*free {arg layer = 1;

		PirS.n.sendMsg("/free", layer);

	}

	*text {arg onOff = 0, fixON = 1;
		PirS.n.sendMsg("/textON", onOff, fixON);
	}

	*msg {arg message = "";
		PirS.n.sendMsg("/message", message);
	}

	*tempo {arg tempo = 1;
		PirS.n.sendMsg("/tempo", tempo);
	}

	*orbit {arg onOff = 0, orbitX = 0, orbitY = 0;
		PirS.n.sendMsg("/autoOrbit", onOff, orbitX, orbitY);
	}

	*fbON {arg onOff = 1;
		PirS.n.sendMsg("/feedbackON", onOff);
	}

	*op {arg layer = 1, opacity = 255;
		PirS.n.sendMsg("/opacity", layer, opacity);
	}

	*light {arg onOff = 0;
		PirS.n.sendMsg("/lightON", onOff);
	}

	*loadFbo {arg video = "";
		PirS.n.sendMsg("/loadFbo", 1, video);
	}

	*freeFbo {arg video = "";
		PirS.n.sendMsg("/loadFbo", 0, video);
	}

	*fboSpeed {arg fboSpeed = 1;
		PirS.n.sendMsg("/fboSpeed", fboSpeed);
	}

	*glitch {arg onOff = 0, glitch = 0;
		PirS.n.sendMsg("/glitch", onOff, glitch);
	}

	*speed{arg layer, speed;
		PirS.n.sendMsg("/speed", layer, speed);
	}

	*feedback{arg retroX, retroY;

		PirS.n.sendMsg("/feedback", retroX, retroY);

	}

	*pos{arg layer, posX, posY, posZ;
		PirS.n.sendMsg("/pos", layer, posX, posY, posZ);

	}

	*load3d{arg layer =1, modelo ="rggtrn.obj";
		PirS.n.sendMsg("/load3d", layer, modelo);

	}


	*size{arg layer, width, height;
		PirS.n.sendMsg("/size", layer, width, height);
	}

	*rot{arg layer, rotX, rotY, rotZ;
		PirS.n.sendMsg("/rot", layer, rotX, rotY, rotZ);
	}

	*freeAll {

		Tdef(\detall, { loop { 0.1.wait; "-----|||staaapAll|||-----".postln}});
		//("-----|||DETALL|||-----").postln;
		Tdef(\detall).play;
		~mezcla.free;

		9.do({arg i; PirS.n.sendMsg("/free", i)});

		//PirS.n.sendMsg("/free", 1);
		//PirS.n.sendMsg("/free", 2);
		//PirS.n.sendMsg("/free", 3);
		//PirS.n.sendMsg("/free", 4);
		//PirS.n.sendMsg("/free", 5);
		//PirS.n.sendMsg("/free", 6);
		//PirS.n.sendMsg("/free", 7);
		//PirS.n.sendMsg("/free", 8);
		//PirS.n.sendMsg("/free", 9);

	}

	/// Para reproducir todo

	*playAll {
		Tdef(\detall).clear;
		("-----|||playAll|||-----").postln;
		~mezcla.play;

		9.do({arg i; PirS.n.sendMsg("/load", i)});

		//PirS.n.sendMsg("/play", 1);
		//PirS.n.sendMsg("/play", 2);
		//PirS.n.sendMsg("/play", 3);
		//PirS.n.sendMsg("/play", 4);
		//PirS.n.sendMsg("/play", 5);
		//PirS.n.sendMsg("/play", 6);
		//PirS.n.sendMsg("/play", 7);
		//PirS.n.sendMsg("/play", 8);
		//PirS.n.sendMsg("/play", 9);

	}

	*seqFBx{arg multiplicador = #[1], secuencia = #[1], secuencia2 = #[1], repeticion = inf, lag = 0;

		~v1fb = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
		~v1fbrep = {SendReply.kr(Impulse.kr(12), '/v1fbrep', ~v1fb.kr)};

		^OSCdef(\listenerv1fb, {|msg|
			var data = msg[3];
			//data.postln;
			PirS.n.sendMsg("/feedbackX", data);
		}, '/v1fbrep');


	}

	*freeSeqFB{

		~v1fb.free;
		~v1fb2.free;
		~v1fbrep.free;
		OSCdef(\listenerv1fb).free;

	}

	*loadVel {arg pista = 1, multiplicador = #[1], secuencia = #[1], repeticion = inf, lag = 0;

		var v1speed, v1speedrep;

		switch(pista,

			1, {
			("-----|||Pista 1 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v1speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v1speedrep = {SendReply.kr(Impulse.kr(12), '/v1speedrep', ~v1speed.kr)};
			^OSCdef(\listenerv1speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v1speedrep');
			},

			2, {
			("-----|||Pista 2 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v2speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v2speedrep = {SendReply.kr(Impulse.kr(12), '/v2speedrep', ~v2speed.kr)};
			^OSCdef(\listenerv2speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v2speedrep');
			},

			3, {
			("-----|||Pista 3 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v3speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v3speedrep = {SendReply.kr(Impulse.kr(12), '/v3speedrep', ~v3speed.kr)};
			^OSCdef(\listenerv3speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v3speedrep');
			},

			4, {
			("-----|||Pista 4 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v4speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v4speedrep = {SendReply.kr(Impulse.kr(12), '/v4speedrep', ~v4speed.kr)};
			^OSCdef(\listenerv4speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v4speedrep');
			},

			5, {
			("-----|||Pista 5 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v5speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v5speedrep = {SendReply.kr(Impulse.kr(12), '/v5speedrep', ~v5speed.kr)};
			^OSCdef(\listenerv5speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v5speedrep');
			},

			6, {
			("-----|||Pista 6 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v6speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v6speedrep = {SendReply.kr(Impulse.kr(12), '/v6speedrep', ~v6speed.kr)};
			^OSCdef(\listenerv6speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v6speedrep');
			},

			7, {
			("-----|||Pista 7 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v7speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v7speedrep = {SendReply.kr(Impulse.kr(12), '/v7speedrep', ~v7speed.kr)};
			^OSCdef(\listenerv7speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v7speedrep');
			},

			8, {
			("-----|||Pista 8 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v8speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v8speedrep = {SendReply.kr(Impulse.kr(12), '/v8speedrep', ~v8speed.kr)};
			^OSCdef(\listenerv8speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v8speedrep');
			},

			9, {
			("-----|||Pista 9 activada|||-----").postln;
			("-----|||Modificador: Velocidad|||-----").postln;
			~v9speed = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, secuencia), lag)};
			~v9speedrep = {SendReply.kr(Impulse.kr(12), '/v9speedrep', ~v9speed.kr)};
			^OSCdef(\listenerv9speed, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/speed", pista, data);
			}, '/v9speedrep');
			}
		)
	}

		*freeVel {arg pista = 1;

			switch(pista,

				1, {
					~v1speed.free;
					~v1speedrep.free;
					OSCdef(\listenerv1speed).free;
					("-----|||Pista 1 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
				},

				2, {
                    ~v2speed.free;
                    ~v2speedrep.free;
                    OSCdef(\listenerv2speed).free;
                    ("-----|||Pista 2 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				3, {
                    ~v3speed.free;
                    ~v3speedrep.free;
                    OSCdef(\listenerv3speed).free;
                    ("-----|||Pista 3 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				4, {
                    ~v4speed.free;
                    ~v4speedrep.free;
                    OSCdef(\listenerv4speed).free;
                    ("-----|||Pista 4 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				5, {
                    ~v5speed.free;
                    ~v5speedrep.free;
                    OSCdef(\listenerv5speed).free;
                    ("-----|||Pista 5 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				6, {
                    ~v6speed.free;
                    ~v6speedrep.free;
                    OSCdef(\listenerv6speed).free;
                    ("-----|||Pista 6 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

                7, {
                    ~v7speed.free;
                    ~v7speedrep.free;
                    OSCdef(\listenerv7speed).free;
                    ("-----|||Pista 7 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				8, {
                    ~v8speed.free;
                    ~v8speedrep.free;
                    OSCdef(\listenerv8speed).free;
                    ("-----|||Pista 8 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },

				9, {
					~v9speed.free;
                    ~v9speedrep.free;
                    OSCdef(\listenerv9speed).free;
                    ("-----|||Pista 9 desactivada|||-----").postln;
					("-----|||Modificador: Velocidad|||-----").postln;
                },


			)

		}

		*loadOpa {arg pista = 1, multiplicador = #[1], secuencia = #[1], repeticion = inf, lag = 2;

		switch(pista,

			1, {
			("-----|||Pista 1 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v1opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v1oparep = {SendReply.kr(Impulse.kr(12), '/v1oparep', ~v1opa.kr)};
			OSCdef(\listenerv1opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v1oparep');
			},

			2, {
			("-----|||Pista 2 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v2opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v2oparep = {SendReply.kr(Impulse.kr(12), '/v2oparep', ~v2opa.kr)};
			^OSCdef(\listenerv2opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v2oparep');
			},

			3, {
			("-----|||Pista 3 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v3opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v3oparep = {SendReply.kr(Impulse.kr(12), '/v3oparep', ~v3opa.kr)};
			^OSCdef(\listenerv3opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v3oparep');
			},

			4, {
			("-----|||Pista 4 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v4opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v4oparep = {SendReply.kr(Impulse.kr(12), '/v4oparep', ~v4opa.kr)};
			^OSCdef(\listenerv4opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v4oparep');
			},

			5, {
			("-----|||Pista 5 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v5opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v5oparep = {SendReply.kr(Impulse.kr(12), '/v5oparep', ~v5opa.kr)};
			^OSCdef(\listenerv5opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v5oparep');
			},

			6, {
			("-----|||Pista 6 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v6opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v6oparep = {SendReply.kr(Impulse.kr(12), '/v6oparep', ~v6opa.kr)};
			^OSCdef(\listenerv6opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v6oparep');
			},

			7, {
			("-----|||Pista 7 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v7opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v7oparep = {SendReply.kr(Impulse.kr(12), '/v7oparep', ~v7opa.kr)};
			^OSCdef(\listenerv7opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacidad", pista, data);
			}, '/v7oparep');
			},

			8, {
			("-----|||Pista 8 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v8opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v8oparep = {SendReply.kr(Impulse.kr(12), '/v8oparep', ~v8opa.kr)};
			^OSCdef(\listenerv8opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacidad", pista, data);
			}, '/v8oparep');
			},

			9, {
			("-----|||Pista 9 activada|||-----").postln;
			("-----|||Modificador: Opacidad|||-----").postln;
			~v9opa = {Lag.kr(Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion)), lag)};
			~v9oparep = {SendReply.kr(Impulse.kr(12), '/v9oparep', ~v9opa.kr)};
			^OSCdef(\listenerv9opa, {|msg|
				var data = msg[3];
				//data.postln;
				PirS.n.sendMsg("/opacity", pista, data);
			}, '/v9oparep');
			}
		)
	}

	*freeOpa {arg pista = 1;

		switch(pista,

			1, {
				~v1opa.free;
				~v1opa.free;
				OSCdef(\listenerv1opa).free;
				("-----|||Pista 1 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			2, {
				~v2opa.free;
				~v2oparep.free;
				OSCdef(\listenerv2opa).free;
				("-----|||Pista 2 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			3, {
				~v3opa.free;
				~v3oparep.free;
				OSCdef(\listenerv3opa).free;
				("-----|||Pista 3 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			4, {
				~v4opa.free;
				~v4oparep.free;
				OSCdef(\listenerv4opa).free;
				("-----|||Pista 4 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			5, {
				~v5opa.free;
				~v5oparep.free;
				OSCdef(\listenerv5opa).free;
				("-----|||Pista 5 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			6, {
				~v6opa.free;
				~v6oparep.free;
				OSCdef(\listenerv6opa).free;
				("-----|||Pista 6 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			7, {
				~v7opa.free;
				~v7oparep.free;
				OSCdef(\listenerv7opa).free;
				("-----|||Pista 7 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			8, {
				~v8opa.free;
				~v8oparep.free;
				OSCdef(\listenerv8opa).free;
				("-----|||Pista 8 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

			9, {
				~v9opa.free;
				~v9oparep.free;
				OSCdef(\listenerv9opa).free;
				("-----|||Pista 9 desactivada|||-----").postln;
				("-----|||Modificador: Opacidad|||-----").postln;
			},

		)

	}

	*loadSync{arg pista = 1, muestra = "SampleHap", multiplicador = 1, secuencia = #[1], repeticion = inf, lag = 2;

		switch(pista,

			1, {

				OSCdef(\listenerv1sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v1sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v1syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v1synctag', ~v1sync.kr)};

				^OSCdef(\listenerv1sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v1synctag');

			},

			2, {

				OSCdef(\listenerv2sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v2sync = {Demand.kr(Impulse.kr(multiplicador), 0, Dseq(secuencia, repeticion))};
				~v2syncrep = {SendReply.kr(Impulse.kr(multiplicador), '/v2synctag', ~v2sync.kr)};

				^OSCdef(\listenerv2sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v2synctag');

			},

			3, {

				OSCdef(\listenerv3sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v3sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v3syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v3synctag', ~v3sync.kr)};

				^OSCdef(\listenerv3sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v3synctag');


			},

			4, {

				OSCdef(\listenerv4sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v4sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v4syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v4synctag', ~v4sync.kr)};

				^OSCdef(\listenerv4sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v4synctag');

			},

			5, {

				OSCdef(\listenerv5sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v5sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v5syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v5synctag', ~v5sync.kr)};

				^OSCdef(\listenerv5sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v5synctag');

			},

			6, {

				OSCdef(\listenerv6sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v6sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v6syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v6synctag', ~v6sync.kr)};

				^OSCdef(\listenerv6sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v6synctag');

			},

			7, {

				OSCdef(\listenerv7sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v7sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v7syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v7synctag', ~v7sync.kr)};

				^OSCdef(\listenerv7sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v7synctag');

			},

			8, {

				OSCdef(\listenerv8sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v8sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v8syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v8synctag', ~v8sync.kr)};

				^OSCdef(\listenerv8sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v8synctag');

			},

			9, {

				OSCdef(\listenerv9sync).free;

				PirS.n.sendMsg("/speed", pista, multiplicador/2);

				~v9sync = {Demand.kr(Impulse.kr(multiplicador.abs), 0, Dseq(secuencia, repeticion))};
				~v9syncrep = {SendReply.kr(Impulse.kr(multiplicador.abs), '/v9synctag', ~v9sync.kr)};

				^OSCdef(\listenerv9sync, {|msg|
					var data = msg[3];
					//data.postln;
					//PirS.n.sendMsg("/speed", pista, data);
					if(data == 1, {PirS.n.sendMsg("/load", pista, muestra)});
				}, '/v9synctag');

			}

		)

	}


	*freeSync {arg pista = 1;

		switch(pista,

			1, {
				~v1sync.free;
				~v1syncrep.free;
				OSCdef(\listenerv1sync).free;
				("-----|||Pista 1 desactivada|||-----").postln;
				("-----|||Modificador: Sync|||-----").postln;
			},

			2, {
				~v2sync.free;
				~v2syncrep.free;
				OSCdef(\listenerv2sync).free;
				("-----|||Pista 2 desactivada|||-----").postln;
				("-----|||Modificador: Sync|||-----").postln;
			},

			3, {
				~v3sync.free;
				~v3syncrep.free;
				OSCdef(\listenerv3sync).free;
				("-----|||Pista 3 desactivada|||-----").postln;
				("-----|||Modificador: Sync|||-----").postln;
                },

			4, {
				~v4sync.free;
				~v4syncrep.free;
				OSCdef(\listenerv4sync).free;
				("-----|||Pista 4 desactivada|||-----").postln;
				("-----|||Modificador: Sync|||-----").postln;
			},

				5, {
                    ~v5sync.free;
                    ~v5syncrep.free;
                    OSCdef(\listenerv5sync).free;
                    ("-----|||Pista 5 desactivada|||-----").postln;
					("-----|||Modificador: Sync|||-----").postln;
                },

				6, {
                    ~v6sync.free;
                    ~v6syncrep.free;
                    OSCdef(\listenerv6sync).free;
                    ("-----|||Pista 6 desactivada|||-----").postln;
					("-----|||Modificador: Sync|||-----").postln;
                },

                7, {
                    ~v7sync.free;
                    ~v7syncrep.free;
                    OSCdef(\listenerv7sync).free;
                    ("-----|||Pista 7 desactivada|||-----").postln;
					("-----|||Modificador: Sync|||-----").postln;
                },

				8, {
                    ~v8sync.free;
                    ~v8syncrep.free;
                    OSCdef(\listenerv8sync).free;
                    ("-----|||Pista 8 desactivada|||-----").postln;
					("-----|||Modificador: Sync|||-----").postln;
                },

				9, {
					~v9sync.free;
                    ~v9syncrep.free;
                    OSCdef(\listenerv9sync).free;
                    ("-----|||Pista 9 desactivada|||-----").postln;
					("-----|||Modificador: Sync|||-----").postln;
                },


			)

		}

}
