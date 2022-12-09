import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

// Simple sum example using command line

class  Sum {
	public static void main(String args[ ]) throws IOException, ClassNotFoundException {
		try {
			FileInputStream fis = new FileInputStream("/storage/emulated/0/code/input.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object obj = ois.readObject();
ois.close();
			if (obj instanceof int[][]) {
				int[][] numbers = (int[][])obj;

				System.out.println(Arrays.toString(numbers));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}


	}
}
