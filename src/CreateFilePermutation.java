

import util.WriteTextFile;

public class CreateFilePermutation
{
	public static void main(String[] args)
	{
		//DO THIS
		//use the Keyboard class to obtain the upper integer value
		//also, obtain the file name to save the data later
		
		util.Keyboard inpt = util.Keyboard.getKeyboard();
		
		int in_val = inpt.readInt("Please enter the upper limit integer value : ");
		System.out.println(in_val);
		
		String file_nombre = inpt.readString("\nPleae enter the file name that will store the permutations : ");
		System.out.println(file_nombre);
		//DO THIS
		//obtain the random permutation using the upper integer value
		//write out the values to a text file (close the file)

		util.RandomPermutation rand = new util.RandomPermutation(in_val, in_val);
		util.WriteTextFile write_file =  new util.WriteTextFile(file_nombre);
		
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
		int counter = 0;
		
		util.ReadTextFile read_file = new util.ReadTextFile(file_nombre);
		String line_val = read_file.readLine();
		while(!read_file.EOF())
		{
			
			rand_nums[counter] = Integer.parseInt(line_val);
			counter++;
			line_val = read_file.readLine();
		}
		read_file.close();

		//DO THIS
		//sort the integers (use java.util.Arrays.sort)
		//print them out to make sure they are all there once
		java.util.Arrays.sort(rand_nums);

		for(int i = 0; i < rand_nums.length; i++){
			System.out.println(rand_nums[i]);
		}


	}
}
