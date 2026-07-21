package cm.aptoide.pt.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Build;
import java.util.concurrent.Callable;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAccountProvider {
    private final String accountType;
    private final AccountManager androidAccountManager;
    private final rx.h scheduler;

    public AndroidAccountProvider(AccountManager accountManager, String str, rx.h hVar) {
        this.androidAccountManager = accountManager;
        this.accountType = str;
        this.scheduler = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAndroidAccount$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a() throws Exception {
        Account[] accountsByType = this.androidAccountManager.getAccountsByType(this.accountType);
        return accountsByType.length == 0 ? Single.h(new IllegalStateException("No account found.")) : Single.m(accountsByType[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeAndroidAccount$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Account account) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.androidAccountManager.removeAccountExplicitly(account);
        } else {
            this.androidAccountManager.removeAccount(account, null, null);
        }
    }

    public Single<Account> createAndroidAccount(String str) {
        Account account = new Account(str, this.accountType);
        try {
            this.androidAccountManager.addAccountExplicitly(account, null, null);
            return Single.m(account);
        } catch (SecurityException e2) {
            return Single.h(e2);
        }
    }

    public Single<Account> getAndroidAccount() {
        return Single.c(new Callable() { // from class: cm.aptoide.pt.account.i0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3799f.a();
            }
        }).p(this.scheduler);
    }

    public rx.b removeAndroidAccount() {
        return getAndroidAccount().g(new rx.m.b() { // from class: cm.aptoide.pt.account.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f3797f.b((Account) obj);
            }
        }).z().A();
    }
}
