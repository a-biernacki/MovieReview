package ca.sheridancollege.biernaca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.biernaca.beans.Movie;
import ca.sheridancollege.biernaca.database.DatabaseAccess;

@Controller
public class MovieController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {

		da.insertMovie();
		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", da.getMovieList());
		return "index";
	}

	@PostMapping("/insertMovie")
	public String insertMovie(Model model, @ModelAttribute Movie movie) {
		da.insertMovie(movie);
		model.addAttribute("movie", new Movie());
		model.addAttribute("movieList", da.getMovieList());
		return "index";
	}

}
