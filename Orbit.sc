
// Orbit

Orbit{
	
	classvar <n; classvar <q;  classvar <server;

	*start{arg direccion = "127.0.0.1", puerto = 5612;	
		("-----|||PiranhaLib|||-----").postln;
		//("-----|||Ajúuuuuuua|||-----").postln;
		n = NetAddr(direccion, puerto);
		server = Server.local;
	}

	*vload {arg layer = 1, name = "samplehap";
		PirS.n.sendMsg("/vload", layer, name);	
	}

	*vfree {arg layer = 1;
		PirS.n.sendMsg("/vfree", layer);
	}

	*vspeed {arg layer = 1, speed = 1;
		PirS.n.sendMsg("/vspeed", layer, speed);
	}

	*light {arg onOff = 1;
		PirS.n.sendMsg("/light", onOff);
	}

	*cbackground {arg onOff = 1;
		PirS.n.sendMsg("/cbackground", onOff);
	}

	*sceneload {arg onOff = 1, name = "";
		PirS.n.sendMsg("/sceneload", onOff, name);
	}

	*scenefree {
		PirS.n.sendMsg("/sceneclear");
	}

	*tempo {arg tempo = 1;
		PirS.n.sendMsg("/tempo", tempo);
	}

	*vop {arg layer = 1, opacity = 255;
		PirS.n.sendMsg("/vop", layer, opacity);
	}

	*vpos {arg layer = 1, posX = 0, posY = 0, posZ = 0;
		PirS.n.sendMsg("/vpos", layer, posX, posY, posZ);
	}

	*vscale {arg layer = 1, scale = 1;
		PirS.n.sendMsg("/vcale", layer, scale);
	}

	*fbxy {arg fbx = 40, fby = 40;
		PirS.n.sendMsg("/fbxy", fbx, fby);
	}

	*fbx {arg fbx = 40;
		PirS.n.sendMsg("/fbx", fbx);
	}

	*fby {arg fby = 40;
		PirS.n.sendMsg("/fby", fby);
	}

	*texclear {
		PirS.n.sendMsg("/texclear");
	}

	*itex {arg layer = 1, texture = "stone.jpg";
		PirS.n.sendMsg("/itex", layer, texture);
	}

	*mload {arg layer = 1, model = "stone";
		PirS.n.sendMsg("/mload", layer, model);
	}

	*mfree {arg layer = 1;
		PirS.n.sendMsg("/mfree", layer);
	}

	*mpos {arg layer = 1, posX = 0, posY = 0, posZ = 0;
		PirS.n.sendMsg("/mpos", layer, posX, posY, posZ);
	}

	*mscale {arg scale = 1;
		PirS.n.sendMsg("/mscale", scale);
	}

	*mrot {arg layer = 1, rotX = 0, rotY = 0, rotZ = 0;
		PirS.n.sendMsg("/mrot", layer, rotX, rotY, rotZ);
	}

	*blur {arg onOff = 1, bluramnt = 0.1;
		PirS.n.sendMsg("/blur", onfOff, bluramnt);
	}

	*gblur {arg onOff = 1, bluramnt = 0.1;
		PirS.n.sendMsg("/gblur", onfOff, bluramnt);
	}

	*vrot {arg layer = 1, rotX = 0, rotY = 0, rotZ = 0;
		PirS.n.sendMsg("/vrot", layer, rotX, rotY, rotZ);
	}

	*msg {arg message = "hola", nombre = "alguien";
		PirS.n.sendMsg("/message", hola, alguien);
	}

	*msg {arg message = "hola";
		PirS.n.sendMsg("/message", message);
	}

	*clear {
		PirS.n.sendMsg("/clear");
	}

	*scenescale {arg scale = 1;
		PirS.n.sendMsg("/scenescale", scale);
	}

	*vtex {arg video = "samplehap.mov";
		PirS.n.sendMsg("/vtex", video);
	}

	*multimsg {arg layer = 1, posX = 0, posY = 0, rotX = 0, rotY = 0, rotZ = 0, message = "hola";
		PirS.n.sendMsg("/multimsg", layer, posX, posY, rotX, rotY, rotZ, message);
	}

	*dome {arg onOff = 1;
		PirS.n.sendMsg("/dome", onfOff);
	}

}
