package Interfaces;

public class BandPass extends Filter{
    double lowCutoff, highCutoff;
    public BandPass(double lowCut, double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    @Override
    public Waveform process(Waveform input){
        return input;
    }
}
