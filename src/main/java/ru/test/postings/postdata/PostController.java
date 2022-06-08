package ru.test.postings.postdata;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/postings")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "listall")
    public List<PostRecord> listall()
    {
        return postService.listall();
    }


    @GetMapping(path = "listauth")
    @ResponseBody
    public List<PostRecord> list(@RequestParam String dateFrom, @RequestParam String dateTo, @RequestParam String authorized)
    {
        LocalDate datefrom = LocalDate.parse(dateFrom);
        LocalDate dateto = LocalDate.parse(dateTo);
        return postService.list(datefrom, dateto, authorized);
    }

    @GetMapping(path = "list")
    @ResponseBody
    public List<PostRecord> list(@RequestParam String dateFrom, @RequestParam String dateTo)
    {
        LocalDate datefrom = LocalDate.parse(dateFrom);
        LocalDate dateto = LocalDate.parse(dateTo);
        return postService.list(datefrom, dateto, null);
    }

}
