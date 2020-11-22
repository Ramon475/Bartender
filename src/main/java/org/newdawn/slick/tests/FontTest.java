package org.newdawn.slick.tests;
	
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;


public class FontTest extends BasicGame {
	
	private AngelCodeFont font;
	
	private AngelCodeFont font2;
	
	private Image image;
	
	
	public FontTest() {
		super("Font Test");
	}
	
	
	public void init(GameContainer container) throws SlickException {
		font = new AngelCodeFont("testdata/demo2.fnt","testdata/demo2_00.tga");
		font2 = new AngelCodeFont("testdata/hiero.fnt","testdata/hiero.png");
		image = new Image("testdata/demo2_00.tga", false);
	}

	
	public void render(GameContainer container, Graphics g) {
		font.drawString(80, 5, "A Font Example", Color.red);
		font.drawString(100, 32, "We - AV - Here is a more complete line that hopefully");
		font.drawString(100, 36 + font.getHeight("We Here is a more complete line that hopefully"), 
				             "will show some kerning.");
		
		font2.drawString(80, 85, "A Font Example", Color.red);
		font2.drawString(100, 132, "We - AV - Here is a more complete line that hopefully");
		font2.drawString(100, 136 + font2.getHeight("We - Here is a more complete line that hopefully"), 
				             "will show some kerning.");
		image.draw(100,400);
		
		String testStr = "Testing Font";
		font2.drawString(100, 300, testStr);
		g.setColor(Color.white);
		g.drawRect(100,300+font2.getYOffset(testStr),font2.getWidth(testStr),font2.getHeight(testStr)-font2.getYOffset(testStr));
		font.drawString(500, 300, testStr);
		g.setColor(Color.white);
		g.drawRect(500,300+font.getYOffset(testStr),font.getWidth(testStr),font.getHeight(testStr)-font.getYOffset(testStr));
	}

	
	public void update(GameContainer container, int delta) throws SlickException {
	}
	
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			System.exit(0);
		}
		if (key == Input.KEY_SPACE) {
			try {
				container.setDisplayMode(640, 480, false);
			} catch (SlickException e) {
				Log.error(e);
			}
		}
	}
	
	
	private static AppGameContainer container;
	
	
	public static void main(String[] argv) {
		try {
			container = new AppGameContainer(new FontTest());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}