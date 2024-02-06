package videostore.horror;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {

	private String title;
	private MovieType movieType;

}