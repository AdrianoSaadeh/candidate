package br.edu.ulbra.election.candidate.service;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ulbra.election.candidate.output.v1.CandidateOutput;
import br.edu.ulbra.election.candidate.repository.CandidateRepository;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, ModelMapper modelMapper){
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    public List<CandidateOutput> getAll(){
        Type candidateOutputListType = new TypeToken<List<CandidateOutput>>(){}.getType();
        return modelMapper.map(candidateRepository.findAll(), candidateOutputListType);
    }
}
