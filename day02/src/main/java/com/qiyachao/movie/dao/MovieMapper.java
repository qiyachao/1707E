package com.qiyachao.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.qiyachao.movie.domain.Movie;
import com.qiyachao.movie.vo.MovieVo;

public interface MovieMapper {

	List<Movie> list(MovieVo movieVo);

	@Update("update t_movie set status=#{status} where id=#{id}")
	boolean update(Movie movie);

}
