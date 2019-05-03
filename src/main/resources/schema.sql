DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  userID INT(11) NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  active INT(1) NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS MCUMovies;

CREATE TABLE MCUMovies (
  movieID INT(11) NOT NULL AUTO_INCREMENT,
  movieName VARCHAR(255) NOT NULL,
  moviePosterURL VARCHAR(255) NOT NULL,
  movieTrailerURL VARCHAR(255) NOT NULL,
  movieReleaseDate VARCHAR(255) NOT NULL
);

-- // create three tables
-- CREATE TABLE WatchList | WatchedMovies | likedMovies (
--     id
--     userId/email
--     moviePosterURL
-- )




-- DROP TABLE IF EXISTS UserMovies;

-- CREATE TABLE UserMovies AS SELECT MCUMovies.*, Users.email, Users.userID FROM MCUMovies LEFT OUTER JOIN Users;