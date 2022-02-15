package com.example.blogengine.blogEngine;


import com.example.blogengine.entities.Category;
import com.example.blogengine.entities.Combination;
import com.example.blogengine.entities.Tag;
import com.example.blogengine.entities.blogPost;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path="api/tables/application")
public class apiLayer {
    private serviceLayer sl;

    public apiLayer(serviceLayer sl) {
        this.sl = sl;
    }

    //bejegyzések listázása
    @GetMapping(path="/blog")
    public StringBuilder initialBlogpost(){

        StringBuilder output = new StringBuilder();
        sl.getPosts().forEach(output::append);

        return output;
    }

    //bejegyzés létrehozása
    @PostMapping("/blog")
    public void PostBlog(@RequestBody blogPost newPost){
        sl.addNewBlog(newPost);
    }

    //bejegyzés törlése
    @DeleteMapping(path="/blog/{postId}")
    public void deletePost(@PathVariable("postId") Integer postId){
        sl.deletePost(postId);
    }

    @PutMapping(path="/blog/{postId}")
    public void updatePost(
            @PathVariable("postId") Integer postId,
            @RequestParam(required = false) String context) {
        sl.updatePost(postId, context);
    }

    //bejegyzésnek a keresése tag alapján
    //tesztelése lehetőség : http://localhost:8080/api/tables/application/blog/search?tag=facebook&pageNo=0&pageSize=5
    @GetMapping(path="/blog/search")
    public List SearchBlogpost(@RequestParam String tag,@RequestParam int pageNo,@RequestParam int pageSize){

        return sl.searchPost(tag,pageNo,pageSize);
    }


    //------------------------------------------- Category

    //Category listázás
    @GetMapping(path="/cat")
    public StringBuilder initialCat(){

        StringBuilder output = new StringBuilder();
        sl.getCategory().forEach(output::append);

        return output;
    }
    //kategória törlése
    @DeleteMapping(path="/cat/{catId}")
    public void deleteCat(@PathVariable("catId") Integer catId){

        sl.deleteCat(catId);
    }


    //kategória létrehozása
    @PostMapping("/cat")
    public void PostCat(@RequestBody Category cat){
        sl.addNewCat(cat);
    }


    //------------------------------------------------Combination

    @GetMapping(path="/com")
    public StringBuilder initialCom(){

        StringBuilder output = new StringBuilder();
        sl.getCombination().forEach(output::append);

        return output;
    }

    @DeleteMapping(path="/com/{comId}")
    public void deleteCom(@PathVariable("comId") Integer comId){
        sl.deleteCom(comId);
    }

    //bejegyzés létrehozása
    @PostMapping("/com")
    public void PostCom(@RequestBody Combination com){
        sl.addNewCombination(com);
    }

    //------------------------------------------------Tag

    @GetMapping(path="/tag")
    public StringBuilder initialTag(){

        StringBuilder output = new StringBuilder();
        sl.getTags().forEach(output::append);

        return output;
    }

    @DeleteMapping(path="/tag/{tagID}")
    public void deleteTag(@PathVariable("tagID") Integer tagID){
        sl.deleteTag(tagID);
    }


    @PostMapping("/tag")
    public void PostTag(@RequestBody Tag tag){
        sl.addNewTag(tag);
    }

    @PutMapping(path="/tag/{tagID}")
    public void updateTag(
            @PathVariable("tagID") Integer tagID,
            @RequestParam(required = false) String tag) {
        sl.updateTag(tagID, tag);
    }



}

