package nestedcontrollerexample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PersonEditorController {
	private final ObjectProperty<Person> person ;
	@FXML
	private TextField firstName ;
	@FXML
	private TextField lastName ;
	
	public PersonEditorController() {
		this.person = new SimpleObjectProperty<>(this, "person", null);
	}
	
	public void initialize() {
		this.person.addListener(new ChangeListener<Person>() {
			@Override
			public void changed(ObservableValue<? extends Person> observable,
					Person oldPerson, Person newPerson) {
				if (oldPerson != null) {
					firstName.textProperty().unbindBidirectional(oldPerson.firstNameProperty());
					lastName.textProperty().unbindBidirectional(oldPerson.lastNameProperty());
				}
				if (newPerson != null) {
					firstName.textProperty().bindBidirectional(newPerson.firstNameProperty());
					lastName.textProperty().bindBidirectional(newPerson.lastNameProperty());
				}
			}
		});
	}
	
	public final ObjectProperty<Person> personProperty() {
		return person ;
	}
	
	public final Person getPerson() {
		return person.get() ;
	}
	
	public final void setPerson(Person person) {
		this.person.set(person);
	}
}
