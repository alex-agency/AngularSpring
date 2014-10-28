package spring.repositories;

import spring.entities.Account;
import spring.entities.Blog;

public interface AccountRepo {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
