package sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Message {
	@Id
	@GeneratedValue
	Long id;
	String text;
}






