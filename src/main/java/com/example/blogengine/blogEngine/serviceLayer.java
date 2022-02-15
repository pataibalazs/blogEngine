package com.example.blogengine.blogEngine;

import com.example.blogengine.entities.Category;
import com.example.blogengine.entities.Combination;
import com.example.blogengine.entities.Tag;
import com.example.blogengine.entities.blogPost;
import com.example.blogengine.repositories.BlogpostRepository;
import com.example.blogengine.repositories.CategoryRepository;
import com.example.blogengine.repositories.CombinationRepository;
import com.example.blogengine.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;


@Service
public class serviceLayer {

    private final BlogpostRepository blogpostRepository;
    private final CategoryRepository categoryRepository;
    private final CombinationRepository combinationRepository;
    private final TagRepository tagRepository;

    @Autowired
    public serviceLayer(BlogpostRepository temp, CategoryRepository temp2, CombinationRepository temp3, TagRepository temp4) {

        this.blogpostRepository=temp;
        this.categoryRepository=temp2;
        this.combinationRepository=temp3;
        this.tagRepository=temp4;
    }

    // blogpost
    public List<blogPost> getPosts(){
        return blogpostRepository.findAll();
    }

    public void addNewBlog(blogPost newPost)
    {
        blogpostRepository.save(newPost);
    }

    public void deletePost(int ID)
    {
        boolean exists=blogpostRepository.existsById(ID);
        if(!exists){
            throw new IllegalStateException(
                    "blog does not exist with this ID :"+ID);
        }
        blogpostRepository.deleteById(ID);
    }

    @Transactional
    public void updatePost(Integer ID, String context){

        blogPost post=blogpostRepository.findById(ID).orElseThrow(()->new IllegalStateException(
                "blog does not exist with this ID"+ID
        ));
        if(context==null) {
            throw new IllegalStateException("cart ID does not exist");
        }
        if(context!=null && context.length()>0){

            ZonedDateTime zonedDateTimeNow=ZonedDateTime.now(ZoneId.of("CET"));
            post.setLastModification(zonedDateTimeNow.toLocalDateTime());
            post.setContext(context);
        }
    }


    public List<Combination> searchPost(String tagName,int pageNo, int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
            return combinationRepository.SearchByTag(tagName, paging);


    }


    //category ------------------------------------------

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
    public void addNewCat(Category cat)
    {
        categoryRepository.save(cat);
    }

    public void deleteCat(int ID)
    {
        boolean exists=categoryRepository.existsById(ID);
        if(!exists){
            throw new IllegalStateException(
                    "blog does not exist with this ID :"+ID);
        }

        List<Tag> tagList=tagRepository.SearchByCatID(ID);
        for (Tag elem : tagList) {
            elem.setCatID(null);
        }

        List<Combination> comList=combinationRepository.SearchByCatID(ID);
        for (Combination elem : comList) {
            elem.setCatID(null);
        }

        categoryRepository.deleteById(ID);
    }


    //Combination
    public List<Combination> getCombination(){
        return combinationRepository.findAll();
    }
    public void addNewCombination(Combination newCom)
    {
        boolean blog_id_existence=blogpostRepository.existsById(newCom.getBlogID());
        boolean cart_id_existence=categoryRepository.existsById(newCom.getCatID());
        boolean tag_existence=tagRepository.existsById(newCom.getTagID());
        Long numberOfOccurences=combinationRepository.CountByID(newCom.getBlogID());



        if(numberOfOccurences>4)
        {
            throw new IllegalStateException("Too much connection for a blog post");
        }
        else if(!tag_existence)
        {
            throw new IllegalStateException("this tag does not exist");
        }
        else if(!blog_id_existence && !cart_id_existence)
        {
            throw new IllegalStateException("blog and cart ID does not exist");
        }
        else if(!blog_id_existence)
        {
            throw new IllegalStateException("blog ID does not exist");
        }
        else if(!cart_id_existence)
        {
            throw new IllegalStateException("cart ID does not exist");
        }
        else
        {
            combinationRepository.save(newCom);
        }


    }
    public void deleteCom(int ID)
    {
        boolean exists=combinationRepository.existsById(ID);
        if(!exists){
            throw new IllegalStateException(
                    "Combination does not exist with this ID :"+ID);
        }
        combinationRepository.deleteById(ID);
    }

    //tag repository
    public List<Tag> getTags(){
        return tagRepository.findAll();
    }
    public void addNewTag(Tag newTag)
    {
        System.out.println(newTag.getTag());
        boolean tag_id_existence=tagRepository.existsById(newTag.getTagID());
        boolean cat_id_existence=categoryRepository.existsById(newTag.getCatID());

        if(!cat_id_existence)
        {
            throw new IllegalStateException("category ID does not exist");
        }
        else if(tag_id_existence)
        {
            throw new IllegalStateException("tag ID already exists");
        }
        else if (newTag.getTag().length()<3 || newTag.getTag().length()>10)
        {
            throw new IllegalStateException("tagName does not have a proper length");
        }
        else
        {
            tagRepository.save(newTag);
        }
    }

    @Transactional
    public void updateTag(Integer tagID, String tag){
        Tag newTag=tagRepository.findById(tagID).orElseThrow(()->new IllegalStateException(
                "tag does not exist with this ID"+tagID
        ));
        if (tag.length()<3 || tag.length()>10)
        {
            throw new IllegalStateException("tagName does not have a proper length");
        }
        else
        {
            newTag.setTag(tag);
        }

    }

    public void deleteTag(int ID)
    {
        boolean exists=tagRepository.existsById(ID);
        if(!exists){
            throw new IllegalStateException(
                    "Tag does not exist with this ID :"+ID);
        }
        tagRepository.deleteById(ID);
    }



}
