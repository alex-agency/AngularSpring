package spring.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import spring.controller.AccountController;
import spring.resources.AccountListResource;
import spring.resources.AccountResource;
import spring.services.util.AccountList;

import java.util.List;

public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
