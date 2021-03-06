package output;

import base.Displayer;

public class DisplayerFactory {
	
	public static Displayer getDisplayer(DisplayerType displayerType)
	{
		switch (displayerType) {
		case TEXT:
			return new TextDisplayer();

		default:
			return new TextDisplayer();
		}
	}

}
