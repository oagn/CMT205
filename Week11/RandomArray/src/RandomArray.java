import java.util.ArrayList;

public class RandomArray extends ArrayList{
	   public void map (Command c)
	   {
	      for (Object data: this) {
	         c.execute(data);
	      }
	   }
}
