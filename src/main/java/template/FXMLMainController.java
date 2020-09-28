package template;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 * FXML Controller class
 */
public class FXMLMainController implements Initializable {

	@FXML
	private WebView browser;

	private WebEngine browserEngine;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		browser.setContextMenuEnabled(false);

		browserEngine = browser.getEngine();
		browserEngine.load(getClass().getResource("html_main.html").toExternalForm());

		// Create JavaScript bridge
		browserEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
			@Override
			public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
				if (newState == State.SUCCEEDED) {
					JSObject win = (JSObject) browserEngine.executeScript("window");
					win.setMember("app", new JSBridge(browserEngine));
				}
			}
		});
	}
}
