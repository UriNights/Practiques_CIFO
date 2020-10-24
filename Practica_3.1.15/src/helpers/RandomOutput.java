package helpers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RandomOutput {

	private static Random random = new Random();

	public static ArrayList<Point> createPointsList(int quantity, int width, int height) {

		// Create an array of random numbers which are the x for every position.

		int[] listOf_x = new int[quantity];

		for (int i = 0; i < quantity; i++) {
			listOf_x[i] = random.nextInt(width);
		}

		// Create an array of number numbers which are the y for every position.
		// Till now, every pair refers the two numbers in the same position on both arrays.

		int[] listOf_y = new int[quantity];

		for (int total_y_Assigned = 0; total_y_Assigned < quantity; total_y_Assigned++) {
			
			if (listOf_x[total_y_Assigned] == 0) {						// Avoid to give 0,0 (Player start position)
				listOf_y[total_y_Assigned] = random.nextInt(height);
			} else {
				listOf_y[total_y_Assigned] = random.nextInt(height - 1) + 1;
			}

			for (int j = total_y_Assigned; 0 < j; j--) {				// Check if there is coincidence between the last pair done and the given before.
				
				if (listOf_x[total_y_Assigned] == listOf_x[j - 1]) {
					
					if (listOf_y[total_y_Assigned] == listOf_y[j - 1]) {
						
						listOf_x[total_y_Assigned] = random.nextInt(width);
						total_y_Assigned--;
						break;
					}
				}
			}
		}
		
		// Create an array list of points, with every pair of x and y which are on the same position of the arrays.
		
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			points.add(new Point(listOf_x[i], listOf_y[i]));
		}
		
		return points;
	}
}