package cl.citiaps.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.citiaps.spring.backend.entities.Actor;
import cl.citiaps.spring.backend.repository.ActorRepository;
import cl.citiaps.spring.backend.repository.FilmRepository;
import cl.citiaps.spring.backend.entities.Film;
import java.util.List;

@CrossOrigin
@RestController  
@RequestMapping("/actors")
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Actor> getAllUsers() {
		return actorRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public  Actor findOne(@PathVariable("id") Integer id) {
		return actorRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
	@ResponseBody
	public List<Film> getfilmsActor(@PathVariable("id") Integer id){
		return actorRepository.findOne(id).getfilmsActor();
	}


	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor create(@RequestBody Actor resource) {
	     return actorRepository.save(resource);
	}

	@RequestMapping(value = "/{idActor}/films/{idFilm}", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Actor addFilmActor(@PathVariable("idActor") Integer idActor, @PathVariable("idFilm") Integer idFilm){
		Actor actorResult = actorRepository.findOne(idActor);
		Film filmResult = filmRepository.findOne(idFilm);
		if(!(actorResult.getfilmsActor().contains(filmResult))){
			actorResult.getfilmsActor().add(filmResult);
		}
		filmRepository.save(filmResult);
		return actorRepository.save(actorResult);
	}
	 
}