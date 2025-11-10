package zid.paie.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import zid.paie.demo.models.Postetravail;
import zid.paie.demo.repository.PostTravailRepository;

@Service
@RequiredArgsConstructor
public class PosteTravailService {

    private final PostTravailRepository postTravailRepository;

    public List<Postetravail> getListePostetravail()
    {
        return postTravailRepository.findAll();
    }
    
    public Optional<Postetravail>  getPostetravail(Long idpostetravail)
    {
        return postTravailRepository.findById(idpostetravail);

    }
    
    public boolean deletePosteTravail(Long postetravailid)
    {
        Optional<Postetravail> postetravail = postTravailRepository.findById(postetravailid);

        if (postetravail.isPresent()) {
            postTravailRepository.delete(postetravail.get());
            return true;
        } else
            return false;

    }
    
    public Postetravail createPostetravail(Postetravail postetravail)
    {

        return postTravailRepository.save(postetravail);

    }
    
    public Postetravail updPostetravail(Postetravail postetravail)
    {
    return postTravailRepository.save(postetravail);

    }
    


}
