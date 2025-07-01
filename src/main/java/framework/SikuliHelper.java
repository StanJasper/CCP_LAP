package framework;

import org.sikuli.script.*;

public class SikuliHelper {

    private static final Screen screen = new Screen();

    public static void click(Pattern pattern) throws Exception {
        screen.wait(pattern, 10);
        screen.click(pattern);
    }

    public static void click(Match match) throws Exception {
        screen.click(match);
    }

    public static void paste(Pattern pattern, String value) throws Exception {
        screen.wait(pattern, 10);
        screen.paste(pattern, value);
    }

    public static void pasteWithoutTarget(String value) throws Exception {
        screen.paste(value);
    }

    public static void pressEnter() throws Exception {
        screen.type(Key.ENTER);
    }

    public static void scrollDown(int steps) {
        screen.wheel(Button.WHEEL_DOWN, steps);
    }

    public static void scrollUp(int steps) {
        screen.wheel(Button.WHEEL_UP, steps);
    }

    public static Match find(Pattern pattern, int timeout) throws Exception {
        return screen.exists(pattern, timeout);
    }

    public static void clickOffset(Match match, int offsetX, int offsetY) throws Exception {
        Location offsetLocation = match.getTarget().offset(offsetX, offsetY);
        screen.click(offsetLocation);
    }

	public static void pressArrowDown(int i) {
		// TODO Auto-generated method stub
		
	}
}
