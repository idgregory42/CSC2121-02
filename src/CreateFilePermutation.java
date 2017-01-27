//util classes
import util.WriteTextFile;
import util.ReadTextFile;
import util.Keyboard;
import util.RandomPermutation;


public class CreateFilePermutation
{
	public static void main(String[] args)
	{
		//DO THIS
		//use the Keyboard class to obtain the upper integer value
		//also, obtain the file name to save the data later
		
		Keyboard inpt = Keyboard.getKeyboard();
		
		int in_val = inpt.readInt("Please enter the upper limit integer value : ");
		System.out.println(in_val);
		
		String file_nombre = inpt.readString("\nPleae enter the file name that will store the permutations : ");
		System.out.println(file_nombre);
		//DO THIS
		//obtain the random permutation using the upper integer value
		//write out the values to a text file (close the file)

		RandomPermutation rand = new RandomPermutation(in_val, in_val);
		WriteTextFile write_file =  new WriteTextFile(file_nombre);
		
		while(rand.hasNext())
		{
			write_file.writeLine(Integer.toString(rand.next()));
		}
		write_file.close();

		//DO THIS
		//read the values in from the text file and store them in an integer array
		//it is easiest to read the first line outside of a while loop that tests for EOF
		//use Integer.parseInt() for converting String to int
		
		
		int[] rand_nums = new int[in_val]; 
		
		ReadTextFile read_file = new ReadTextFile(file_nombre);
		String line_val = read_file.readLine();
		
		//Reads content from file and stores them in an array
		int cnt = 0;
		while(!read_file.EOF())
		{
			rand_nums[cnt] = Integer.parseInt(line_val);
			line_val = read_file.readLine();
			cnt++;
		}
		read_file.close();

		//DO THIS
		//sort the integers (use java.util.Arrays.sort)
		//print them out to make sure they are all there once
		
		//sorts the array
		java.util.Arrays.sort(rand_nums);
		
		int v = rand_nums.length;
		
		//for loop that prints the values in the array
		for (int i = 0;i < v; i++){
			System.out.println(rand_nums[i]);
		}
	}
}
