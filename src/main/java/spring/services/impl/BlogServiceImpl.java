package spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.entities.Blog;
import spring.entities.BlogEntry;
import spring.repositories.BlogEntryRepo;
import spring.repositories.BlogRepo;
import spring.services.BlogService;
import spring.services.exceptions.BlogNotFoundException;
import spring.services.util.BlogEntryList;
import spring.services.util.BlogList;

import javax.persistence.Entity;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Autowired
    private BlogEntryRepo entryRepo;

    @Override
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepo.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
    }

    @Override
    public BlogList findAllBlogs() {
        return new BlogList(blogRepo.findAllBlogs());
    }

    @Override
    public BlogEntryList findAllBlogEntries(Long blogId) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
    }

    @Override
    public Blog findBlog(Long id) {
        return blogRepo.findBlog(id);
    }
}
