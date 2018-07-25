/// hola esta es una prueba


CineVivo{

	classvar <version; classvar <n;

	*init {
		super.initClass;
			 version = "Jul 24 2018";
		     ("CineVivo.sc: " ++ version).postln;
	}

	*start{arg address = "127.0.0.1", port = 5612;

		n = NetAddr(address, port);

	}

	*windowShape {arg width, height;
		n.sendMsg("/windowShape", width, height);
	}

	*backColor {arg red, green, blue;
		n.sendMsg("/backColor", red, green, blue);
	}

	*fullscreen{arg onOff;
		n.sendMsg("/fullscreen", onOff);
	}

	*clean{
		n.sendMsg("/clean", 0);
	}

	*playAll{
		n.sendMsg("/playAll");
	}

	*stopAll{
		n.sendMsg("/stopAll");
	}

	*pauseAll{
		n.sendMsg("/pauseAll");
	}

	*load{arg layer = 1, videoNameOrCamera = "fluido";
		n.sendMsg("/load", layer, videoNameOrCamera);
	}

	*mask{arg layer = 1, maskName;
		n.sendMsg("/mask", layer, maskName);
	}

	*syphon{arg layer = 1, onOff;
		n.sendMsg("/syphon", layer, onOff);
	}

	*play{arg layer = 1;
		n.sendMsg("/play", layer);
	}

	*pause{arg layer = 1;
		n.sendMsg("/pause", layer);
	}

	*stop{arg layer;
		n.sendMsg("/stop", layer);
	}

	*rectMode{arg layer, onOff;
		n.sendMsg("/rectMode", layer, onOff);

	}

	*pos{arg layer, posX, posY;
		n.sendMsg("/pos", layer, posX, posY);

	}

	*posX{arg layer, posX;
		n.sendMsg("PosX", layer, posX);
	}

	*posY{arg layer, posY;
		n.sendMsg("/posY", layer, posY);
	}

	*rot{arg layer, rotX, rotY, rotZ;
		n.sendMsg("/rot", layer, rotX, rotY, rotZ);
	}

	*rotX{arg layer, rotX;
		n.sendMsg("/rotX", layer, rotX);
	}

	*rotY{arg layer, rotY;
		n.sendMsg("/rotY", layer, rotY);
	}

	*rotZ{arg layer, rotZ;
		n.sendMsg("/rotZ", layer, rotZ);
	}

	*size{arg layer, width, height;
		n.sendMsg("/size", layer, width, height);
	}

	*width{arg layer, width;
		n.sendMsg("/width", layer, width);
	}

	*height{arg layer, height;
		n.sendMsg("/height", layer, height);
	}

	*scale{arg layer, width, height;
		n.sendMsg("/scale", layer, width, height);
	}

	*speed{arg layer, speed;
		n.sendMsg("/speed", layer, speed);
	}

	*color{arg layer, red, green, blue;
		n.sendMsg("/color", layer, red, green, blue);
	}

	*opacity{arg layer, opacity;
		n.sendMsg("/opacity", layer, opacity);
	}

	*shader{arg layer, onOff;
		n.sendMsg("/shader", layer, onOff);

	}

	*shaderMode{arg layer, shader;
		n.sendMsg("/shaderMode", layer, shader);

	}

	*fit{arg layer;
		n.sendMsg("/fit", layer);
	}

	*fitHorizontal{arg layer;
		n.sendMsg("/fitHorizontal", layer);
	}

	*fitVertical{arg layer;
		n.sendMsg("/fitVertical", layer);
	}

	*fitAllHorizontal{arg layer;
		n.sendMsg("/fitAllHorizontal", layer);
	}

	*fitAllVertical{arg layer;
		n.sendMsg("/fitAllVertical", layer);
	}

}