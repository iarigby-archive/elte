package helpers;

public enum Screens {
	MAIN("../view/WelcomeScreen.fxml"),
	LOGIN("../view/LogInScreen.fxml"),
	REGISTRATION("../view/RegistrationScreen.fxml"),
	ADMINPANEL("../view/AdminScreen.fxml"),
	SESSION("../view/SessionScreen.fxml"),
	MODIFYDEVICES("../view/ModifyDevices.fxml"),
	LISTCLIENTS("../view/ListClients.fxml"),
	LISTUSAGES("../view/ListUsages.fxml");
	
	private final String path;
	
	Screens(String path) {
		this.path = path;
	}
	public String toString() {
       return this.path;
    }
}
