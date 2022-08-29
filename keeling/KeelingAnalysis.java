import java.io.*;
import java.util.*;
import java.awt.*;

public class KeelingAnalysis {

	public static void main(String[] args) throws FileNotFoundException {

		// read input from text file
		double[] original_data = new double[697];
		File f = new File("KeelingDataSavGol.txt");
		Scanner input = new Scanner(f);
		for (int i = 0; i < 697; i++) {
			original_data[i] = input.nextDouble();
		}

		// create filters
		int smoothing_window = 36;
		double[] moving_avg_filter = new double[smoothing_window];
		Arrays.fill(moving_avg_filter, 1.0/smoothing_window);
		double[] derivative_filter = new double[]{-4, -3, -2, -1, 0, 1, 2, 3, 4};

		// create filtered data
		double[] smoothed_data = applyfilter(original_data, moving_avg_filter);
		double[] derivative = applyfilter(smoothed_data, derivative_filter);

		// graph
		DrawingPanel panel = new DrawingPanel(800,400);
		Graphics g = panel.getGraphics();

		graph(g, original_data, -310, 4);
		graph(g, smoothed_data, -310, 4);
		graph(g, derivative, 2, 20);


		// draw tick marks
		g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		for (int i = 22; i < 800; i += 24) {
			g.drawLine(i, 399, i, 397);
			g.drawString(Integer.toString((i - 22) / 12 + 1960), i-10, 390);
		}
	}

	public static void graph(Graphics g, double[] data, double shift, double scaling_factor) {
		for (int i = 0; i < 697; i++) {
			g.drawOval((int) i, 400 - (int) (scaling_factor * (data[i] + shift)), 1, 1);
		}
	}

	public static double[] applyfilter(double[] original_data, double[] filter) {
	
		double[] filtered_data = new double[697];
		Arrays.fill(filtered_data, 0);
		for (int i = 0; i < 697 - filter.length; i++) {
			for (int j = 0; j < filter.length; j++) {
				filtered_data[i + (filter.length / 2)] += original_data[i + j] * filter[j];
			}
		}
		return filtered_data;
	}

}