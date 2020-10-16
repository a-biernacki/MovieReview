package ca.sheridancollege.biernaca.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.biernaca.beans.Movie;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertMovie() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO movie(name, rating, genre, platform, reviewDate, reviewTime) VALUES ('Halloween', '4', 'Horror', 'Shudder', '1992-10-24','3:20')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted movie into database.");
	}

	public void insertMovie(Movie movie) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "INSERT INTO movie(name, rating, genre, platform, reviewDate, reviewTime) VALUES (:name, :rating, :genre, :platform, :reviewDate, :reviewTime)";
		namedParameters.addValue("name", movie.getName());
		namedParameters.addValue("rating", movie.getRating());
		namedParameters.addValue("genre", movie.getGenre());
		namedParameters.addValue("platform", movie.getPlatform());
		namedParameters.addValue("reviewDate", movie.getReviewDate());
		namedParameters.addValue("reviewTime", movie.getReviewTime());
		int RowsAffected = jdbc.update(query, namedParameters);
		if (RowsAffected > 0)
			System.out.println("Inserted movie into database.");
	}

	public List<Movie> getMovieList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * FROM movie";

		// grabs above query
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Movie>(Movie.class));

	}

}
