package com.rabbitfighter.lightning;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.SlickCallable;

/**
 * A lightning volt experimentation based on algorithms found on Drillan's House
 * of Game Development [http://drilian.com/2009/02/25/lightning-bolts/]
 * 
 * Note: WIP
 * 
 * Published under creative commons.
 * 
 * @author rabbitfighter, redragonX, Dylan OttoKrider, and above blog post's
 *         auttor.
 *
 */
public class LightningBolt extends BasicGame {

    // Game title
    public static final String game_title = "Lightning Bolt Test";

    // Lightning bolt effect object variable.
    private LightingBoltEffect lightingBoltEffect;

    // Contructor
    public LightningBolt(String title) {
	super(title);
    }

    /**
     * Main class
     * 
     * @param arguments
     * @throws SlickException
     */
    public static void main(String[] arguments) throws SlickException {
	AppGameContainer app = new AppGameContainer(new LightningBolt(
		game_title));
	app.setDisplayMode(640, 480, false);
	app.setAlwaysRender(true);
	app.setMinimumLogicUpdateInterval(1);
	app.setShowFPS(true);
	app.start();

    }

    /*
     * (non-Javadoc) Initializes the game state.
     * 
     * @see org.newdawn.slick.BasicGame#init(org.newdawn.slick.GameContainer)
     */
    @Override
    public void init(GameContainer container) throws SlickException {
	generateLightingBolt(new Vector2f(50, 240), new Vector2f(290, 240), 100);
    }

    /*
     * (non-Javadoc) Updates the gsme state.
     * 
     * @see org.newdawn.slick.BasicGame#update(org.newdawn.slick.GameContainer,
     * int)
     */
    @Override
    public void update(GameContainer container, int delta)
	    throws SlickException {
	lightingBoltEffect.update(delta);
	if (!lightingBoltEffect.isDone())
	    return;

	Input input = container.getInput();
	if (!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
	    return;

	int mouseX = input.getMouseX();
	int mouseY = input.getMouseY();

	Random random = new Random();
	int duration = random.nextInt() % 600 + 100;
	generateLightingBolt(new Vector2f(mouseX, mouseY), new Vector2f(
		(mouseX + 300), mouseY), duration);
    }

    /*
     * (non-Javadoc) Renders the game state.
     * 
     * @see org.newdawn.slick.Game#render(org.newdawn.slick.GameContainer,
     * org.newdawn.slick.Graphics)
     */
    @Override
    public void render(GameContainer container, Graphics g)
	    throws SlickException {
	SlickCallable.enterSafeBlock();
	lightingBoltEffect.render();
	SlickCallable.leaveSafeBlock();
    }

    /**
     * Class that hold information about a lightning bolt effect. Contains raw
     * OpenGL code, and internal undating and rendering. Structured to fit in
     * one class file.
     * 
     * @author rabbitfighter
     *
     */
    public static class LightingBoltEffect {

	Collection<Line> segments;

	int totalTime;

	int currentTime;

	private float lineWidth;

	public LightingBoltEffect(int time, Collection<Line> segments,
		float lineWidth) {
	    this.totalTime = time;
	    this.segments = segments;
	    this.currentTime = time;
	    this.lineWidth = lineWidth;
	}

	public void update(int delta) {
	    currentTime -= delta;
	    if (currentTime <= 0)
		currentTime = 0;
	}

	public void render() {
	    float alpha = (float) currentTime / (float) totalTime;

	    /***** OpenGL *****/
	    glPushMatrix();
	    // Notice that the internal update will make these values all
	    // simultaneously drop to 0, making it black, thus ending the
	    // effect.
	    glColor4f(alpha, alpha, alpha, alpha);
	    glLineWidth(lineWidth);
	    glBegin(GL_LINES);
	    {
		for (Line segment : segments) {
		    glVertex(segment.getStart());
		    glVertex(segment.getEnd());
		}
	    }
	    glEnd();
	    glPopMatrix();
	    /***** End OpenGl *****/
	}

	public boolean isDone() {
	    return currentTime <= 0;
	}

	public void glVertex(Vector2f v) {
	    glVertex3f(v.x, v.y, 0);
	}

    }// End Lightning Bolt Effect

    /**
     * Generates a lightning bolt.
     * 
     * @param p0
     *            - the starting vector.
     * @param p1
     *            - the Ending Vector
     * @param duration
     *            - the duration of the effect
     */
    protected void generateLightingBolt(Vector2f p0, Vector2f p1, int duration) {
	Collection<Line> segments = new ArrayList<Line>();

	segments.add(new Line(p0, p1));

	float offset = 200f;

	double probability = 0.3; // probability to generate new partitions

	float height = 50.0f;

	Random random = new Random();

	int partitions = 4;

	for (int i = 0; i < partitions; i++) {

	    Collection<Line> newSegments = new ArrayList<Line>();

	    for (Line segment : segments) {

		Vector2f midPoint = segment.getStart().copy()
			.add(segment.getEnd()).scale(0.5f);

		Vector2f perpendicular = midPoint.copy().add(90);
		perpendicular.normalise().scale(
			random.nextFloat() * offset - (offset / 2));

		midPoint.add(perpendicular);

		if (random.nextFloat() < probability) {

		    // generate new branch
		    Vector2f direction = midPoint.copy()
			    .sub(segment.getStart());

		    direction.add(random.nextFloat() * height);

		    newSegments.add(new Line(midPoint.copy(), midPoint.copy()
			    .add(direction)));
		}

		newSegments.add(new Line(segment.getStart().copy(), midPoint
			.copy()));

		newSegments.add(new Line(midPoint.copy(), segment.getEnd()
			.copy()));
	    }

	    segments = newSegments;

	    offset /= 2;
	}

	lightingBoltEffect = new LightingBoltEffect(duration, segments, 2.0f);
    }// End generateLightingbolt()

}// EOF
