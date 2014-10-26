package spring.services;

import spring.entities.Account;
import spring.entities.Blog;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
