package examsolutions;
import stdlib.*;


public class PlayChordsFromFile {

	
	public static void playChord(double... frequencies) {
		double duration = 0.5;
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			for (double frequency: frequencies) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
			slices[i] /= frequencies.length;
		}
		StdAudio.play(slices);
	}
	
	public static void main(String[] args) {
		
		StdIn.fromFile("data/risingchords.txt");
		
		while(!StdIn.isEmpty()) {
				
				String line = StdIn.readLine();
				String[] fields = line.split("\\s+");
				Double a = Double.valueOf(fields[0]);
				Double b = Double.valueOf(fields[1]);
				Double c = Double.valueOf(fields[2]);
				playChord(a,b,c);
				
			}
	
	}
	
}
