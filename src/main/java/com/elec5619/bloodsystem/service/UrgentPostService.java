package com.elec5619.bloodsystem.service;

import com.elec5619.bloodsystem.dao.UrgentPostRepository;
import com.elec5619.bloodsystem.domain.UrgentPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elec5619.bloodsystem.dao.HistoryRecordRepository;
import com.elec5619.bloodsystem.domain.Account;
import com.elec5619.bloodsystem.domain.BloodType;
import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.domain.HistoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrgentPostService {

    @Autowired
    UrgentPostRepository urgentPostRepository;

    AccountService accountService;


    public UrgentPost saveUrgentPost(UrgentPost urgentPost){
        return urgentPostRepository.save(urgentPost);
    }


    public List<UrgentPost> getUserUrgentPost(Account account){
        return urgentPostRepository.findUrgentPostByAccount(account);
    }


    public UrgentPost findUrgentPostById(long id){
        return urgentPostRepository.findById(id).get();
    }

    public void updateUrgentPostStatus(long id, boolean matched){
        urgentPostRepository.updateUrgentPostStatus(matched, id);
    }

    public List<UrgentPost> getAllUrgentPost(){
        return urgentPostRepository.findAll();
    }

    public List<UrgentPost> getAvailableUrgentPost(Account curUser){
        List<UrgentPost> urgentPosts = getAllUrgentPost();
        List<UrgentPost> availablePosts = urgentPosts.
                stream().
                filter(post->!post.getMatched()
                        && !post.getAccount().getId().equals(curUser.getId())).toList();

        return availablePosts;
    }
}
