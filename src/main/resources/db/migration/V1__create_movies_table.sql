CREATE TABLE IF NOT EXISTS movies (
  id SERIAL PRIMARY KEY,
  movie_name    VARCHAR(255) NOT NULL,
  director_name VARCHAR(255),
  genre         VARCHAR(100),
  imdb_score    REAL,
  movie_banner  TEXT,
  created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at    TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_movies_movie_name    ON movies(movie_name);
CREATE INDEX IF NOT EXISTS idx_movies_director_name ON movies(director_name);
CREATE INDEX IF NOT EXISTS idx_movies_genre         ON movies(genre);