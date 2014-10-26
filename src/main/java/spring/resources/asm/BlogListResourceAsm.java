package spring.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import spring.controller.BlogController;
import spring.resources.BlogListResource;
import spring.services.util.BlogList;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}
