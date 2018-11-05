// Orbit
// hace falta txtrot

Orb{
	
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

	*fb {arg onOff = 1;
		PirS.n.sendMsg("/feedbackON", onOff);
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
		PirS.n.sendMsg("/blur", onOff, bluramnt);
	}

	*gblur {arg onOff = 1, bluramnt = 0.1;
		PirS.n.sendMsg("/gblur", onOff, bluramnt);
	}

	*vrot {arg layer = 1, rotX = 0, rotY = 0, rotZ = 0;
		PirS.n.sendMsg("/vrot", layer, rotX, rotY, rotZ);
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
		PirS.n.sendMsg("/dome", onOff);
	}

	*histnames {arg onOff=0;
		PirS.n.sendMsg("/namesON", onOff);
	}

	*icos {arg onOff=0;
		PirS.n.sendMsg("/icosON", onOff);
	}
	
	*stars {arg onOff=0;
		PirS.n.sendMsg("/stars", onOff);
	}

	*orbit {arg onOff = 0, orbitX = 0, orbitY = 0;
		PirS.n.sendMsg("/orbit", onOff, orbitX, orbitY);
	}

	*glitch {arg onOff = 0, glitch = 0; PirS.n.sendMsg("/glitch",
		onOff, glitch);
	}

	*cglitch {arg onOff = 0, glitch = 0;
		PirS.n.sendMsg("/cglitch", onOff, glitch);
	}

	*mesh {arg treshold = 10, img = "marble.png", connections = 2;
		PirS.n.sendMsg("/mesh", treshold, img, connections);
	}

	*meshdisplacement {arg disX = 0, disY = 0, disZ = 0;
		PirS.n.sendMsg("/meshdisplacement", disX, disY, disZ);
	}

	*meshclear { // nada, eso esta raro
		PirS.n.sendMsg("/meshclear");
	}

	*pointsize { arg pointSize = 1;
		PirS.n.sendMsg("/pointsize", pointSize);
	}

	*meshmode { arg meshmode = "triangles";
		PirS.n.sendMsg("/meshmode", meshmode);
	}

	*meshpos {arg posX = 0, posY = 0, posZ = 0;
		PirS.n.sendMsg("/meshpos", posX, posY, posZ);
	}

	*meshrot {arg rotX = 0, rotY = 0, rotZ = 0;
		PirS.n.sendMsg("/meshrot", rotX, rotY, rotZ);
	}

	*meshscale {arg meshScale = 1;
		PirS.n.sendMsg("/meshscale", meshScale);
	}

}