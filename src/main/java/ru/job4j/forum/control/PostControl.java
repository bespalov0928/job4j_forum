package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/create")
    public String createPost() {

        return "create";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post, HttpServletRequest req) {
        String[] idString = req.getParameterValues("idString");
        posts.add(post, idString);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String editPost(@RequestParam("id") int id, Model model) {
        Post post = posts.findById(id);
        model.addAttribute("post", post);
        return "edit";
    }


}
