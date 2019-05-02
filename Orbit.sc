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
		Orb.n.sendMsg("/vload", layer, name);	
	}

	*vfree {arg layer = 1;
		Orb.n.sendMsg("/vfree", layer);
	}

	*vspeed {arg layer = 1, speed = 1;
		Orb.n.sendMsg("/vspeed", layer, speed);
	}

	*light {arg onOff = 1;
		Orb.n.sendMsg("/light", onOff);
	}

	*cbackground {arg onOff = 1;
		Orb.n.sendMsg("/cbackground", onOff);
	}

	*sceneload {arg onOff = 1, name = "";
		Orb.n.sendMsg("/sceneload", onOff, name);
	}

	*scenefree {
		Orb.n.sendMsg("/sceneclear");
	}

	*tempo {arg tempo = 1;
		Orb.n.sendMsg("/tempo", tempo);
	}

	*vop {arg layer = 1, opacity = 255;
		Orb.n.sendMsg("/vop", layer, opacity);
	}

	*vpos {arg layer = 1, posX = 0, posY = 0, posZ = 0;
		Orb.n.sendMsg("/vpos", layer, posX, posY, posZ);
	}

	*vscale {arg layer = 1, scale = 1;
		Orb.n.sendMsg("/vcale", layer, scale);
	}

	*fb {arg onOff = 1;
		Orb.n.sendMsg("/fb", onOff);
	}

	*fbxy {arg fbx = 40, fby = 40;
		Orb.n.sendMsg("/fbxy", fbx, fby);
	}

	*fbx {arg fbx = 40;
		Orb.n.sendMsg("/fbx", fbx);
	}

	*fby {arg fby = 40;
		Orb.n.sendMsg("/fby", fby);
	}

	*texclear {
		Orb.n.sendMsg("/texclear");
	}

	*itex {arg layer = 1, texture = "stone.jpg";
		Orb.n.sendMsg("/itex", layer, texture);
	}

	*mload {arg layer = 1, model = "stone";
		Orb.n.sendMsg("/mload", layer, model);
	}

	*mfree {arg layer = 1;
		Orb.n.sendMsg("/mfree", layer);
	}

	*mpos {arg layer = 1, posX = 0, posY = 0, posZ = 0;
		Orb.n.sendMsg("/mpos", layer, posX, posY, posZ);
	}

	*mscale {arg layer = 1, scale = 1;
		Orb.n.sendMsg("/mscale", layer, scale);
	}

	*mrot {arg layer = 1, rotX = 0, rotY = 0, rotZ = 0;
		Orb.n.sendMsg("/mrot", layer, rotX, rotY, rotZ);
	}

	*blur {arg onOff = 1, bluramnt = 0.1;
		Orb.n.sendMsg("/blur", onOff, bluramnt);
	}

	*gblur {arg onOff = 1, bluramnt = 0.1;
		Orb.n.sendMsg("/gblur", onOff, bluramnt);
	}

	*vrot {arg layer = 1, rotX = 0, rotY = 0, rotZ = 0;
		Orb.n.sendMsg("/vrot", layer, rotX, rotY, rotZ);
	}

	*msg {arg message = "hola";
		Orb.n.sendMsg("/message", message);
	}

	*clear {
		Orb.n.sendMsg("/clear");
	}

	*scenescale {arg scale = 1;
		Orb.n.sendMsg("/scenescale", scale);
	}

	*vtex {arg video = "samplehap.mov";
		Orb.n.sendMsg("/vtex", video);
	}

	*multimsg {arg layer = 1, posX = 0, posY = 0, rotX = 0, rotY = 0, rotZ = 0, message = "hola";
		Orb.n.sendMsg("/multimsg", layer, posX, posY, rotX, rotY, rotZ, message);
	}

	*dome {arg onOff = 1;
		Orb.n.sendMsg("/dome", onOff);
	}

	*histnames {arg onOff=0;
		Orb.n.sendMsg("/namesON", onOff);
	}

	*icos {arg onOff=0;
		Orb.n.sendMsg("/icosON", onOff);
	}
	
	*stars {arg onOff=0;
		Orb.n.sendMsg("/stars", onOff);
	}

	*orbit {arg orbitX = 0, orbitY = 0;
		Orb.n.sendMsg("/orbit", orbitX, orbitY);
	}

	*glitch {arg onOff = 0, glitch = 0; 
		Orb.n.sendMsg("/glitch", onOff, glitch);
	}

	*cglitch {arg onOff = 0, glitch = 0;
		Orb.n.sendMsg("/cglitch", onOff, glitch);
	}

	*mesh {arg treshold = 10, img = "marble.png", connections = 2;
		Orb.n.sendMsg("/mesh", treshold, img, connections);
	}

	*meshdisplacement {arg disX = 0, disY = 0, disZ = 0;
		Orb.n.sendMsg("/meshdisplacement", disX, disY, disZ);
	}

	*meshclear { // nada, eso esta raro
		Orb.n.sendMsg("/meshclear");
	}

	*pointsize { arg pointSize = 1;
		Orb.n.sendMsg("/pointsize", pointSize);
	}

	*meshmode { arg meshmode = "triangles";
		Orb.n.sendMsg("/meshmode", meshmode);
	}

	*meshpos {arg posX = 0, posY = 0, posZ = 0;
		Orb.n.sendMsg("/meshpos", posX, posY, posZ);
	}

	*meshrot {arg rotX = 0, rotY = 0, rotZ = 0;
		Orb.n.sendMsg("/meshrot", rotX, rotY, rotZ);
	}

	*meshscale {arg meshScale = 1;
		Orb.n.sendMsg("/meshscale", meshScale);
	}

	*lightmode {arg lightmode = "white";
		Orb.n.sendMsg("/lightmode", lightmode);
	}
	
	*sphin {arg onOff = 0;
		Orb.n.sendMsg("/sphin", onOff);
	}

	*sphout {arg onOff = 0;
		Orb.n.sendMsg("/sphout", onOff);
	}

	*sphinr {arg radio = 50;
		Orb.n.sendMsg("/sphinr", radio);
	}

	*sphoutr {arg radio = 50;
		Orb.n.sendMsg("/sphoutr", radio);
	}

	*lookat {arg camposX = 0, camposY = 0, camposZ = 0;
		Orb.n.sendMsg("/lookat", camposX, camposY, camposZ);
	}

	*camdistance {arg camdist = 100;
		Orb.n.sendMsg("/camdistance", camdist);
	}

	*starsnum {arg starsnum = 100;
		Orb.n.sendMsg("/starsnum", starsnum);
	}

	*starssize {arg starssize = 1;
		Orb.n.sendMsg("/starssize", starssize);
	}

	*starsdisp {arg starsdisp = 100;
		Orb.n.sendMsg("/starsdisp", starsdisp);
	}

        *fboamount {arg fboamount = 20;
                Orb.n.sendMsg("/fboamount", fboamount);
        }

        *clearfbo {arg clearfbo = 1;
                Orb.n.sendMsg("/clearfbo", clearfbo);
        }

        *boxes {arg boxes = 1;
                Orb.n.sendMsg("/boxes", boxes);
        }



}
