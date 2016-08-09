package elbar;

import java.util.*;
import javax.ws.rs.core.*;

public class SET extends Application {
	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(Service.class);
		return set;
	}
}
