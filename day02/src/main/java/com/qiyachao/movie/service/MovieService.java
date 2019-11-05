package com.qiyachao.movie.service;

import com.github.pagehelper.PageInfo;
import com.qiyachao.movie.domain.Movie;
import com.qiyachao.movie.vo.MovieVo;


public interface MovieService {

	PageInfo<Movie> list(MovieVo movieVo,Integer page,Integer pageSize);

	boolean update(Movie movie);
	
}
