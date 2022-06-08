package ru.test.postings.postdata;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostRecord> listall()
    {
        return postRepository.findAll();
    }


    public List<PostRecord> list(LocalDate dateFrom, LocalDate dateTo, String authorized)
    {
        if(authorized != null && authorized.equalsIgnoreCase("true"))
            return postRepository.findPostRecordByDatesAuth(dateFrom, dateTo);
        else
            return postRepository.findPostRecordByDates(dateFrom, dateTo);
    }

}
