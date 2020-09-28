package template;

import javafx.scene.web.WebEngine;

/**
 * JavaScript interface object
 */
public class JSBridge {

	private final WebEngine browserEngine;

	public JSBridge(WebEngine browserEngine) {
		this.browserEngine = browserEngine;
	}

	public void handleButtonPressedEvent() {
		System.out.println("We've been invoked from JavaScript");
		browserEngine.executeScript("invokedFromJava('HI')");
	}
}
