package game_of_life;

/**
 * 
 * @author Omer Zano
 * Interface for a rule for the game
 */
public interface CA_Rule
{
	abstract public void ImplementRule(int i, int j, GoL_Board prev, GoL_Board next);
}
