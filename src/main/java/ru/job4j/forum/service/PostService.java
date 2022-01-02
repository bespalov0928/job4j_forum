package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of("Продаю машину ладу 01."));
    }

    public List<Post> getAll() {
        return posts;
    }

    public void add(Post post, String[] idArr) {
        if (idArr != null) {
            Post postOld = posts.get(Integer.parseInt(idArr[0]));
            postOld.setName(post.getName());
            postOld.setDescription(post.getDescription());
            postOld.setDiscussion(post.getDiscussion());
            return;
        }
        Post postNew = Post.of(post.getName());
        postNew.setDescription(post.getDescription());
        postNew.setCreated(Calendar.getInstance());
        posts.add(postNew);
        postNew.setId(posts.size() - 1);
    }

    public Post findById(int id) {
        Post rsl;
        rsl = posts.get(id);
        return rsl;
    }

}
