
# Spring Boot Movie Recommendations API

This is a Spring Boot application that consumes a RESTful endpoint for retrieving a list of movies and provides a new endpoint for recommending movies based on the user's preferred genre.

The `/recommendations` endpoint accepts a query parameter `genre` and returns a list of movies that belong to the specified genre, sorted by release year in descending order. The movie data is retrieved from an external RESTful endpoint.


## Endpoints
The application provides the following endpoint:


#### GET /recommendations


```http
  GET /recommendations?genre=Action
```
Retrieves a list of recommended movies based on the user's preferred genre.

Example Response:
```json
[
  { "id": 3,
    "title": "The Dark Knight",
    "genre": "Action",
    "releaseYear": 2008,
    "director": "Christopher Nolan" },
  { "id": 6,
    "title": "The Matrix",
    "genre": "Action",
    "releaseYear": 1999,
    "director": "The Wachowskis" }
]
```
## Notes

The movie data is retrieved from an external RESTful endpoint at https://6419938ec152063412c5fdcb.mockapi.io/movies. You can update the endpoint in the application.properties file.
