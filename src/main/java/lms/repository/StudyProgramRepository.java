package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.domain.StudyProgram;


@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long>{

	

}
