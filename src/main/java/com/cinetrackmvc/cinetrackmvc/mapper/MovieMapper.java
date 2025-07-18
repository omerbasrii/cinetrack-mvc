package com.cinetrackmvc.cinetrackmvc.mapper;


import com.cinetrackmvc.cinetrackmvc.dto.MovieRequest;
import com.cinetrackmvc.cinetrackmvc.dto.MovieResponse;
import com.cinetrackmvc.cinetrackmvc.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieResponse toResponse(Movie movie);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Movie toMovieEntity(MovieRequest movieRequest);

    List<MovieResponse> toResponseList(List<Movie> movies);

}
