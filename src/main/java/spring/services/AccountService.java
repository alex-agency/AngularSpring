package spring.services;

import spring.entities.Account;
import spring.entities.Blog;
import spring.services.util.AccountList;
import spring.services.util.BlogList;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
