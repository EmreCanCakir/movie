package Movie.movie.core.utilities.constants;

import Movie.movie.core.utilities.results.Result;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class CONSTANTS {
    public static final String ACTOR_ADD_SUCCESSFULLY = "Actor is successfully added";
    public static final String ACTOR_NOT_ADD = "Actor is not added successfully because actor name lenght is not smaller than 3";
    public static final String ACTOR_DELETE_SUCCESSFULLY = "Actor is successfully deleted";
    public static final String ACTOR_NOT_DELETE = "Actor is not deleted successfully because actor is not exist";
    public static final String ACTOR_UPDATE_SUCCESSFULLY = "Actor is successfully updated";
    public static final String ACTOR_NOT_UPDATE = "Actor is not updated successfully because actor name lenght is not smaller than 3";
    public static final String ACTOR_GET_SUCCESSFULLY = "Actor is successfully gotten";
    public static final String ACTOR_NOT_FOUND = "Actor is not found";
    public static final String ACTORS_GET_ALL_SUCCESSFULLY = "ALl actors successfully gotten";

    public static final String DIRECTOR_ADD_SUCCESSFULLY = "Director is successfully added";
    public static final String DIRECTOR_NOT_ADD = "Director is not added successfully because director name lenght is not smaller than 3";
    public static final String DIRECTOR_DELETE_SUCCESSFULLY = "Director is successfully deleted";
    public static final String DIRECTOR_NOT_DELETE = "Director is not deleted successfully because director is not exist";
    public static final String DIRECTOR_UPDATE_SUCCESSFULLY = "Director is successfully updated";
    public static final String DIRECTOR_NOT_UPDATE = "Director is not updated successfully because director name lenght is not smaller than 3";
    public static final String DIRECTOR_GET_SUCCESSFULLY = "Director is successfully gotten";
    public static final String DIRECTOR_NOT_FOUND = "Director is not found";
    public static final String DIRECTOR_GET_ALL_SUCCESSFULLY = "ALl Directors successfully gotten";

    public static final String GENRE_ADD_SUCCESSFULLY = "Genre is successfully added";
    public static final String GENRE_NOT_ADD = "Genre is not added successfully because genre name lenght cannot be empty";
    public static final String GENRE_DELETE_SUCCESSFULLY = "Genre is successfully deleted";
    public static final String GENRE_NOT_DELETE = "Genre is not deleted successfully because genre is not exist";
    public static final String GENRE_UPDATE_SUCCESSFULLY = "Genre is successfully updated";
    public static final String GENRE_NOT_UPDATE = "Genre is not updated successfully because genre name lenght is not smaller than 3";
    public static final String GENRE_GET_SUCCESSFULLY = "Genre is successfully gotten";
    public static final String GENRE_NOT_FOUND = "Genre is not found";
    public static final String GENRE_GET_ALL_SUCCESSFULLY = "ALl genres successfully gotten";

    public static final String LINK_ADD_SUCCESSFULLY = "Link is successfully added";
    public static final String LINK_NOT_ADD = "Link is not added successfully because link address lenght cannot be empty";
    public static final String LINK_DELETE_SUCCESSFULLY = "Link is successfully deleted";
    public static final String LINK_NOT_DELETE = "Link is not deleted successfully because link is not exist";
    public static final String LINK_UPDATE_SUCCESSFULLY = "Link is successfully updated";
    public static final String LINK_NOT_UPDATE = "Link is not updated successfully because link address lenght is not smaller than 10";
    public static final String LINK_GET_SUCCESSFULLY = "Link is successfully gotten";
    public static final String LINK_NOT_FOUND = "Link is not found";
    public static final String LINK_GET_ALL_SUCCESSFULLY = "ALl Links successfully gotten";

    public static final String MOVIE_CAST_ADD_SUCCESSFULLY = "Movie cast is successfully added";
    public static final String MOVIE_CAST_NOT_ADD = "Movie cast is not added successfully because movie id or actor id cannot be 0";
    public static final String MOVIE_CAST_DELETE_SUCCESSFULLY = "Movie cast is successfully deleted";
    public static final String MOVIE_CAST_NOT_DELETE = "Movie cast is not deleted successfully because movie cast is not exist";
    public static final String MOVIE_CAST_UPDATE_SUCCESSFULLY = "Movie cast is successfully updated";
    public static final String MOVIE_CAST_NOT_UPDATE = "Movie cast is not updated successfully because movie id or actor id cannot be 0";
    public static final String MOVIE_CAST_GET_SUCCESSFULLY = "Movie cast is successfully gotten";
    public static final String MOVIE_CAST_NOT_FOUND = "Movie cast is not found";
    public static final String MOVIE_CAST_GET_ALL_SUCCESSFULLY = "ALl Movie casts successfully gotten";

    public static final String MOVIE_DIRECTION_ADD_SUCCESSFULLY = "Movie direction is successfully added";
    public static final String MOVIE_DIRECTION_NOT_ADD = "Movie direction is not added successfully because movie id or director id cannot be 0";
    public static final String MOVIE_DIRECTION_DELETE_SUCCESSFULLY = "Movie direction is successfully deleted";
    public static final String MOVIE_DIRECTION_NOT_DELETE = "Movie direction is not deleted successfully because movie direction is not exist";
    public static final String MOVIE_DIRECTION_UPDATE_SUCCESSFULLY = "Movie direction is successfully updated";
    public static final String MOVIE_DIRECTION_NOT_UPDATE = "Movie direction is not updated successfully because movie id or director id cannot be 0";
    public static final String MOVIE_DIRECTION_GET_SUCCESSFULLY = "Movie direction is successfully gotten";
    public static final String MOVIE_DIRECTION_NOT_FOUND = "Movie direction is not found";
    public static final String MOVIE_DIRECTION_GET_ALL_SUCCESSFULLY = "ALl Movie directions successfully gotten";

    public static final String MOVIE_GENRE_ADD_SUCCESSFULLY = "Movie genre is successfully added";
    public static final String MOVIE_GENRE_NOT_ADD = "Movie genre is not added successfully because movie id or genre id cannot be 0";
    public static final String MOVIE_GENRE_DELETE_SUCCESSFULLY = "Movie genre is successfully deleted";
    public static final String MOVIE_GENRE_NOT_DELETE = "Movie genre is not deleted successfully because movie genre is not exist";
    public static final String MOVIE_GENRE_UPDATE_SUCCESSFULLY = "Movie genre is successfully updated";
    public static final String MOVIE_GENRE_NOT_UPDATE = "Movie genre is not updated successfully because movie id or genre id cannot be 0";
    public static final String MOVIE_GENRE_GET_SUCCESSFULLY = "Movie genre is successfully gotten";
    public static final String MOVIE_GENRE_NOT_FOUND = "Movie genre is not found";
    public static final String MOVIE_GENRE_GET_ALL_SUCCESSFULLY = "ALl Movie genres successfully gotten";

    public static final String MOVIE_ITEM_ADD_SUCCESSFULLY = "Movie item is successfully added";
    public static final String MOVIE_ITEM_NOT_ADD = "Movie item is not added successfully because movie or description cannot be null";
    public static final String MOVIE_ITEM_DELETE_SUCCESSFULLY = "Movie item is successfully deleted";
    public static final String MOVIE_ITEM_NOT_DELETE = "Movie item is not deleted successfully because movie item is not exist";
    public static final String MOVIE_ITEM_UPDATE_SUCCESSFULLY = "Movie item is successfully updated";
    public static final String MOVIE_ITEM_NOT_UPDATE = "Movie item is not updated successfully because movie or description cannot be null";
    public static final String MOVIE_ITEM_GET_SUCCESSFULLY = "Movie item is successfully gotten";
    public static final String MOVIE_ITEM_NOT_FOUND = "Movie item is not found";
    public static final String MOVIE_ITEM_GET_ALL_SUCCESSFULLY = "ALl Movie items successfully gotten";

    public static final String MOVIE_ADD_SUCCESSFULLY = "Movie is successfully added";
    public static final String MOVIE_NOT_ADD = "Movie is not added successfully because title cannot be null";
    public static final String MOVIE_DELETE_SUCCESSFULLY = "Movie is successfully deleted";
    public static final String MOVIE_NOT_DELETE = "Movie is not deleted successfully because movie is not exist";
    public static final String MOVIE_UPDATE_SUCCESSFULLY = "Movie is successfully updated";
    public static final String MOVIE_NOT_UPDATE = "Movie is not updated successfully because title cannot be null";
    public static final String MOVIE_GET_SUCCESSFULLY = "Movie is successfully gotten";
    public static final String MOVIE_NOT_FOUND = "Movie is not found";
    public static final String MOVIE_GET_ALL_SUCCESSFULLY = "ALl Movies successfully gotten";

    public static final String PHOTO_ADD_SUCCESSFULLY = "Photo is successfully added";
    public static final String PHOTO_NOT_ADD = "Photo is not added successfully because data cannot be null";
    public static final String PHOTO_DELETE_SUCCESSFULLY = "Photo is successfully deleted";
    public static final String PHOTO_NOT_DELETE = "Photo is not deleted successfully because movie is not exist";
    public static final String PHOTO_UPDATE_SUCCESSFULLY = "Photo is successfully updated";
    public static final String PHOTO_NOT_UPDATE = "Photo is not updated successfully because data cannot be null";
    public static final String PHOTO_GET_SUCCESSFULLY = "Photo is successfully gotten";
    public static final String PHOTO_NOT_FOUND = "Photo is not found";
    public static final String PHOTO_GET_ALL_SUCCESSFULLY = "ALl Photos successfully gotten";

    public static final String USER_ADD_SUCCESSFULLY = "User is successfully added";
    public static final String USER_NOT_ADD = "User is not added successfully because email | password cannot be null";
    public static final String USER_DELETE_SUCCESSFULLY = "User is successfully deleted";
    public static final String USER_NOT_DELETE = "User is not deleted successfully because user is not exist";
    public static final String USER_UPDATE_SUCCESSFULLY = "User is successfully updated";
    public static final String USER_NOT_UPDATE = "User is not updated successfully because email | password | username cannot be null";
    public static final String USER_GET_SUCCESSFULLY = "User is successfully gotten";
    public static final String USER_NOT_FOUND = "User is not found";
    public static final String USER_GET_ALL_SUCCESSFULLY = "ALl Users successfully gotten";

    public static final String USER_MOVIE_ITEM_COMMENT_ADD_SUCCESSFULLY = "User movie item comment is successfully added";
    public static final String USER_MOVIE_ITEM_COMMENT_NOT_ADD = "User movie item comment is not added successfully because comment name cannot be null";
    public static final String USER_MOVIE_ITEM_COMMENT_DELETE_SUCCESSFULLY = "User movie item comment is successfully deleted";
    public static final String USER_MOVIE_ITEM_COMMENT_NOT_DELETE = "User movie item comment is not deleted successfully because user movie item comment is not exist";
    public static final String USER_MOVIE_ITEM_COMMENT_UPDATE_SUCCESSFULLY = "User movie item comment is successfully updated";
    public static final String USER_MOVIE_ITEM_COMMENT_NOT_UPDATE = "User movie item comment is not updated successfully because comment name cannot be null";
    public static final String USER_MOVIE_ITEM_COMMENT_GET_SUCCESSFULLY = "User movie item comment is successfully gotten";
    public static final String USER_MOVIE_ITEM_COMMENT_NOT_FOUND = "User movie item comment is not found";
    public static final String USER_MOVIE_ITEM_COMMENT_GET_ALL_SUCCESSFULLY = "ALl User movie item comments successfully gotten";

    public ResponseEntity<?> getResponseEntity(Result result){
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
