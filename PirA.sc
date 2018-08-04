
PirA {

	classvar <s;
	
	*buf{arg muestra, frecuencia = #[1], multiplicador = #[1], fase = 1, secuencia = Dseq(#[1], inf);

		var seqfrec1, seqseq1, pistaAudio1, pulse; 

		//muestra = Buffer.read(s, Platform.resourceDir +/+ "sounds/a11wlk01.wav"); 
		pulse = Impulse.kr(multiplicador, fase);
		seqfrec1 = Demand.kr(pulse, 0, Dseq(frecuencia, inf));
		seqseq1 = Demand.kr(pulse, 0, secuencia);
		^Pan2.ar(PlayBuf.ar(muestra.numChannels, muestra, BufRateScale.kr(muestra) * seqfrec1, pulse * seqseq1, 0, 0));
			
	}

	*dec{arg multiplicador1 = #[1], multiplicador2 = #[1], secuencia = Dseq(#[1], inf), atk = 0.001, rel = 0.2;

		var seqDem, seqDec, pulse1, pulse2;

		pulse1 = Impulse.kr(multiplicador1);
		pulse2 = Impulse.kr(multiplicador2);
		seqDem = Demand.kr(pulse2, 0, secuencia);
		^seqDec = Decay2.kr(seqDem * pulse2, atk, rel);
		
	}

	*dem{arg multiplicador = #[1], secuencia = Dseq(#[1], inf);

		var demand, pulse;

		pulse = Impulse.kr(multiplicador);
		^demand = Demand.kr(pulse, 0, secuencia); 

	}
	
}

