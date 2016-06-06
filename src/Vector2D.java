import java.lang.Math;
import java.util.Random;

/**
 * <h1>Vector2D</h1>
 * This class represents a 2D vector and stores two components vectors Vx and Vy for a vector V
 *
 * @author  Y3508038
 * @version 1.0
 * @since   13-04-2015
 */
public class Vector2D
{
    /***********************************************
     *      INSTANCE VARIABLES
     ***********************************************/

	private double x;
	private double y;

    /***********************************************
     *      INSTANCE VARIABLES END
     ***********************************************/

    /**
     * Default constructor which produces a zero vector
     */
    public Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor which produces a vector V with Vx and Vy as component values
     * @param vX Component vector Vx
     * @param vY Component vector Vy
     */
    public Vector2D(double vX, double vY)
	{
		this.x = vX;
		this.y = vY;
	}

    /**
     * Constructor which produces a pseudo random vector with component vectors in the range of ± max_component
     * @param maxComponentSize Component vectors will be set between ± this
     */
    public Vector2D(double maxComponentSize)
    {
        Random randomSeed = new Random();
        this.x  = (int) (randomSeed.nextInt(2 * (int) maxComponentSize) - maxComponentSize);
        this.y = (int) (randomSeed.nextInt(2 * (int) maxComponentSize) - maxComponentSize);
    }

    /**
     * Constructor that produces a vector from one coordinate to a second coordinate
     * @param coordinate1 Coordinate one - Vector goes from this point
     * @param coordinate2 Coordinate two - Vector goes to this point
     */
    public Vector2D(Coordinate coordinate1, Coordinate coordinate2)
    {
        this.x = coordinate2.getxCoord() - coordinate1.getxCoord();
        this.y = coordinate2.getyCoord() - coordinate1.getyCoord();
    }

    /***********************************************
     *      Physics Vector Implementation
     ***********************************************/
    /**
     * Adds this vector with another vector
     * @param two Vector is added to the current vector
     */
    public void add(Vector2D two)
    {
        this.x += two.getX();
        this.y += two.getY();
    }

    /**
     * Multiplies this vector with another vector
     * @param factor Vector is multiplied by this factor
     */
	public void mult(double factor)
	{
		this.x *= factor;
		this.y *= factor;
	}

    /**
     * Divides this vector with another vector
     * @param factor Vector is divided by this factor
     */
    public void div(double factor)
    {
        this.x /= factor;
        this.y /= factor;
    }

    /**
     * Inverts the current vector
     */
    public void inv()
    {
        this.x *= -1;
        this.y *= -1;
    }
    
    /**
     * Makes the current vector a unit vector
     */
    public void mod() //TODO check that this works
    {
        this.x /= this.getLength() * Math.cos(this.getAngle());
        this.y /= this.getLength() * Math.sin(this.getAngle());        
    }

    /***********************************************
     *      Getters / Setters
     ***********************************************/

    /**
     * Gets the X-component of the vector
     * @return X-component
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * Gets the Y-component of the vector
     * @return Y-component
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * Calculates and returns the length(hypotenus) of the vector
     * @return Returns the length of the vector
     */
    public double getLength()
    {
        return Math.hypot(this.x, this.y);
    }

    /**
     * Calculates the angle of the vector. The angle is given as theta in a polar coordinate
     * @return Returns the angle(theta) of the vector
     */
    public double getAngle()
    {
        return (Math.atan2(this.y, this.x));
    }
}