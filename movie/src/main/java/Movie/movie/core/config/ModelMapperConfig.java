package Movie.movie.core.config;

import Movie.movie.entities.*;
import Movie.movie.entities.dtos.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(linkDtoToLink);
        modelMapper.addMappings(actorDtoToActor);
        modelMapper.addMappings(directorDtoToDirector);
        modelMapper.addMappings(genreDtoToGenre);
        modelMapper.addMappings(movieDtoToMovie);
        modelMapper.addMappings(userDtoToUser);
        modelMapper.addMappings(movieCastDtoToMovieCast);
        modelMapper.addMappings(movieDirectionDtoToMovieDirection);
        modelMapper.addMappings(movieGenreDtoToMovieGenre);
        modelMapper.addMappings(movieItemDtoToMovieItem);
        modelMapper.addMappings(photoDtoToPhoto);
        modelMapper.addMappings(userMovieItemCommentDtoToUserMovieItemComment);
        return modelMapper;
    }

    private final PropertyMap<LinkDto, Link> linkDtoToLink = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieItemId(), destination.getMovieItemId().getId());
        }
    };
    private final PropertyMap<ActorDto, Actor> actorDtoToActor = new PropertyMap<>() {
        @Override
        protected void configure() {}
    };
    private final PropertyMap<DirectorDto, Director> directorDtoToDirector = new PropertyMap<>() {
        @Override
        protected void configure() {}
    };
    private final PropertyMap<GenreDto, Genre> genreDtoToGenre = new PropertyMap<>() {
        @Override
        protected void configure() {}
    };
    private final PropertyMap<MovieDto, Movie> movieDtoToMovie = new PropertyMap<>() {
        @Override
        protected void configure() {}
    };
    private final PropertyMap<UserDto, User> userDtoToUser = new PropertyMap<>() {
        @Override
        protected void configure() {}
    };
    private final PropertyMap<MovieCastDto, MovieCast> movieCastDtoToMovieCast = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieId(), destination.getMovieId().getId());
            map(source.getActorId(), destination.getActorId().getId());
            map(source.getRole(), destination.getRole());
        }
    };
    private final PropertyMap<MovieDirectionDto, MovieDirection> movieDirectionDtoToMovieDirection = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieId(), destination.getMovieId().getId());
            map(source.getDirectorId(), destination.getDirectorId().getId());
        }
    };
    private final PropertyMap<MovieGenreDto, MovieGenres> movieGenreDtoToMovieGenre = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieId(), destination.getMovieId().getId());
            map(source.getGenreId(), destination.getGenreId().getId());
        }
    };
    private final PropertyMap<MovieItemDto, MovieItem> movieItemDtoToMovieItem = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieId(), destination.getMovie().getId());
            map(source.getDescription(), destination.getDescription());
            map(source.getCreatedAt(), destination.getCreatedAt());
            map(source.getLastModifiedAt(), destination.getLastModifiedAt());
        }
    };
    private final PropertyMap<PhotoDto, Photo> photoDtoToPhoto = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieId(), destination.getMovieId().getId());
            map(source.getId(), destination.getId());
            map(source.getName(), destination.getName());
            map(source.getData(), destination.getData());
            map(source.getType(), destination.getType());
        }
    };
    private final PropertyMap<UserMovieItemCommentDto, UserMovieItemComment> userMovieItemCommentDtoToUserMovieItemComment = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getMovieItemId(), destination.getMovieItemId().getId());
            map(source.getUserId(), destination.getUserId().getId());
            map(source.getCommentName(), destination.getCommentName());
            map(source.getCreatedAt(), destination.getCreatedAt());
            map(source.getLastModifiedAt(), destination.getLastModifiedAt());
        }
    };
}
