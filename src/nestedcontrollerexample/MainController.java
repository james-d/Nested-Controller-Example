package nestedcontrollerexample;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class MainController {
	@FXML
	private PersonEditorController personEditorController ;
	@FXML
	private ListView<Person> personList ;
	
	public void initialize() {
		personList.getItems().addAll(
			new Person("Hugo", "Lloris"),
			new Person("Kyle", "Walker"),
			new Person("Jan", "Verthongen"),
			new Person("Younes", "Kaboul"),
			new Person("Danny","Rose"),
			new Person("Nacir", "Chadli"),
			new Person("Etienne", "Capoue"),
			new Person("Paulinho", "Maciel"),
			new Person("Andros", "Townsend"),
			new Person("Erik", "Lamela"),
			new Person("Roberto", "Soldado")
		);
		personList.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {

			@Override
			public ListCell<Person> call(ListView<Person> listView) {
				return new ListCell<Person>() {
					@Override
					public void updateItem(Person person, boolean empty) {
						super.updateItem(person, empty);
						textProperty().unbind();
						if (person != null) {
							textProperty().bind(Bindings.format("%s %s", person.firstNameProperty(), person.lastNameProperty()));
						}
					}
				};
			}
			
		});
		
		personEditorController.personProperty().bind(personList.getSelectionModel().selectedItemProperty());
	}
}
