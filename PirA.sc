
PirA {

	classvar <muestra; classvar <s;
	
	*buf{arg muestra = PirA.muestra, frecuencia = #[1], multiplicador = #[1], secuencia = Dseq(#[1], inf);

		var seqfrec1, seqseq1, pistaAudio1, pulse; 

		muestra = Buffer.read(s, Platform.resourceDir +/+ "sounds/a11wlk01.wav"); 
		pulse = Impulse.kr(multiplicador);
		seqfrec1 = Demand.kr(pulse, 0, Dseq(frecuencia, inf));
		seqseq1 = Demand.kr(pulse, 0, secuencia);
		^Pan2.ar(PlayBuf.ar(muestra.numChannels, muestra, BufRateScale.kr(muestra) * seqfrec1, pulse * seqseq1, 0, 0));
			
	}

	*dec{arg multiplicador = #[1], secuencia = Dseq(#[1], inf), atk = 0.001, rel = 0.2;

		var seqDem, seqDec, pulse;

		pulse = Impulse.kr(multiplicador);
		seqDem = Demand.kr(pulse, 0, secuencia);
		^seqDec = Decay2.kr(seqDem * pulse, atk, rel);
		
	}
	
}

