package brass;

import java.awt.Graphics;
import java.util.ArrayList;

import gui.BasicGUI;
import gui.DrawImage;
import gui.Drawable;
import gui.ImageLoader;

public class BrassGame implements Drawable
{
	private DrawImage board_img;
	private BasicGUI brass_gui;
	private BrassDeck brass_deck;

   public BrassGame()
   {
		ImageLoader il = ImageLoader.getImageLoader();

		BrassXML brass_xml = new BrassXML("resources/brass_pixels.xml");

		gui.PixelDimension board_dimension = brass_xml.getPixelDimension("board");
		gui.PixelPoint board_center_loc = brass_xml.getPixelCenter("board");
		board_img = new DrawImage(il.getImage("images/brass_board.jpg"), "images/brass_board.jpg", board_dimension.getWidth(), board_dimension.getHeight());
		board_img.showImage(board_center_loc.getX(), board_center_loc.getY());

		brass_deck = new BrassDeck(il, brass_xml);
		brass_deck.dealStartCanalPhase();  //shuffles the deck, removes 6 cards

		//DO THIS
		//get a random number generator from util.Random
		util.Random rand_num = util.Random.getRandomNumberGenerator();

		for (int i = 1; i <= 60; i++)
		{
			BrassCard brass_card = brass_deck.deal();
			System.out.println(brass_card.getCardName());
			System.out.println(brass_card.getCardCityTechID());

			//DO THIS
			//set x to a random integer from 0 till the width of the board that you can get from board_dimension
			//set y to a random integer from 0 till the height of the board that you can get from board_dimension
			//call showSmallCard() method on brass_card, providing the randomly generated x and y
			int x = rand_num.randomInt(0, board_img.getWidth());
			int y = rand_num.randomInt(0, board_img.getHeight());
			brass_card.showSmallCard(x,y);
			System.out.println(x + ", " + y);
		}

		//create the gui last
		gui.PixelDimension gui_dimension = brass_xml.getPixelDimension("gui");
		brass_gui = new BasicGUI(gui_dimension.getWidth(), gui_dimension.getHeight(), "Brass", "images/brass_icon.png", this);
   }

   //DO THIS
   //draw the deck
   public void draw(Graphics g, int width, int height)
   {
		board_img.draw(g);
		brass_deck.draw(g);
   }

   public void mouseClicked(int x_click, int y_click)
	{
		System.out.println("The mouse was clicked at (" + x_click + "," + y_click + ").");
	}

   public void keyPressed(char key)
	{
		System.out.println("The " + key + " key was pressed.");
	}
}
