package com.qiyachao.movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.qiyachao.movie.domain.Movie;
import com.qiyachao.movie.service.MovieService;
import com.qiyachao.movie.util.PageUtil;
import com.qiyachao.movie.vo.MovieVo;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,MovieVo movieVo,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize){
		if(movieVo.getOrderFiled()==null) {
			movieVo.setOrderMethod("asc");
		}
		 PageInfo<Movie> info = movieService.list(movieVo, page, pageSize);
		 PageUtil.page(request, "/list", pageSize, info.getList(), (int)info.getTotal(), page);
		 request.setAttribute("movies", info.getList());
		 request.setAttribute("movieVO",movieVo);
		 return "movies";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(Movie movie) {
		return movieService.update(movie);
		
	}
}
