package com.axsos.javaexam.services;

import com.axsos.javaexam.models.Celebrity;
import com.axsos.javaexam.models.User;
import com.axsos.javaexam.repositories.CelebrityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelebrityService {

    private final CelebrityRepository celebrityRepo;

    public CelebrityService(CelebrityRepository celebrityRepo) {
        this.celebrityRepo = celebrityRepo;
    }


    public List<Celebrity> allCelebrities(){
        return celebrityRepo.findAll();
    }

//    public List<Celebrity> allCelebritiesNotContaining(User user){
//        return celebrityRepo.findByUsersNotContains(user);
//    }
//
//    public List<Celebrity> allCelebritiesContaining(User user){
//        return celebrityRepo.findAllByUsers(user);
//    }
//
//    public List<Celebrity> allCelebrities(User user){
//        return celebrityRepo.findAllByUsers(user);
//    }

    public Celebrity findCelebrityById(Long id) {
        Optional<Celebrity> optionalCelebrity = celebrityRepo.findById(id);
        if(optionalCelebrity.isPresent()) {
            return optionalCelebrity.get();
        }
        else {
            return null;
        }
    }

    public Celebrity createCelebrity(Celebrity p) {
        return celebrityRepo.save(p);
    }
    public Celebrity updateCelebrity(Celebrity p) {
        return celebrityRepo.save(p);
    }
    public void deleteCelebrity(Long id) {
        celebrityRepo.deleteById(id);
    }
}
