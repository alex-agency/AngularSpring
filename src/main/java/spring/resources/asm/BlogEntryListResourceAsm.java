package spring.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import spring.controller.BlogController;
import spring.resources.BlogEntryListResource;
import spring.resources.BlogEntryResource;
import spring.services.util.BlogEntryList;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList, BlogEntryListResource> {
    public BlogEntryListResourceAsm() {
        super(BlogController.class, BlogEntryListResource.class);
    }

    @Override
    public BlogEntryListResource toResource(BlogEntryList list) {
        List<BlogEntryResource> resources = new BlogEntryResourceAsm().toResources(list.getEntries());
        BlogEntryListResource listResource = new BlogEntryListResource();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}
