package ca.sheridancollege.biernaca.beans;

import java.time.LocalDate;
//import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie {

	private Long id;
	private String name;
	private String rating;
	private String genre;
	private String platform;
	private LocalDate reviewDate;
	private String reviewTime;
}