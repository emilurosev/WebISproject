package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lms.domain.Title;
import lms.repository.TitleRepository;

@Service
public class TitleService {

	@Autowired
	TitleRepository titleRepository;
	
	public List<Title> findAll(){
		return titleRepository.findAll();
	}
	
	public void addTitle(Title t) {
		titleRepository.save(t);
	}
	
	public Optional<Title> getTitle(Long id) {
		return titleRepository.findById(id);
	}
	
	
	public void removeTitle(Long id) {
		Optional<Title> t = titleRepository.findById(id);
		titleRepository.delete(t.get());
	}

}
