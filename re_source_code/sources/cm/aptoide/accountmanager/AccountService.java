package cm.aptoide.accountmanager;

import com.aptoide.authentication.model.CodeAuth;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface AccountService {
    Single<Account> createAccount(String str, String str2);

    Single<Account> createAccount(String str, String str2, String str3);

    Single<Account> getAccount(String str);

    Single<c.i.j.e<Account, Boolean>> getAccount(String str, String str2, String str3, String str4);

    rx.b removeAccount();

    Single<CodeAuth> sendMagicLink(String str);

    rx.b subscribeStore(String str, String str2, String str3);

    rx.b unsubscribeStore(String str, String str2, String str3);

    rx.b updateAccount(String str);

    rx.b updateAccount(String str, String str2);

    rx.b updateAccount(boolean z);

    rx.b updateAccountUsername(String str);

    rx.b updateTermsAndConditions();
}
