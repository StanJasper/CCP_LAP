package framework;

import org.sikuli.script.*;

public class SikuliHelperMobile {
    private static final Screen screen = new Screen();

    public static void click(Pattern pattern) throws Exception {
        screen.click(pattern);
    }
    
    public static void click(Match match) throws Exception {
        screen.click(match);
        Thread.sleep(500);
    }


    public static void paste(Pattern pattern, String text) throws Exception {
        screen.paste(pattern, text);
    }

    public static void pasteWithoutTarget(String text) throws Exception {
        screen.paste(text);
    }

    public static void pressEnter() throws Exception {
        screen.type(Key.ENTER);
    }

    public static void scrollDown(int steps) throws Exception {
        screen.wheel(Button.WHEEL_DOWN, steps);
    }

    public static void scrollUp(int steps) throws Exception {
        screen.wheel(Button.WHEEL_UP, steps);
    }

    public static Match find(Pattern pattern, int timeoutSeconds) throws Exception {
        return screen.exists(pattern, timeoutSeconds);
    }

    public static void clickOffset(Match match, int xOffset, int yOffset) throws Exception {
        Location location = match.getTarget().offset(xOffset, yOffset);
        screen.click(location);
    }
    
    public static void pressArrowDown(int times) throws Exception {
        for (int i = 0; i < times; i++) {
            screen.type(Key.DOWN);
            Thread.sleep(300);
        }
    }

}