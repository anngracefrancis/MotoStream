package cm.aptoide.pt.account;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AccountPersistence;
import cm.aptoide.accountmanager.AdultContent;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class MatureContentPersistence implements AccountPersistence {
    private final AdultContent adultContent;
    private final AccountPersistence wrappedAccountPersistence;

    public MatureContentPersistence(AccountPersistence accountPersistence, AdultContent adultContent) {
        this.wrappedAccountPersistence = accountPersistence;
        this.adultContent = adultContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Account a(Account account) {
        return new MatureContentAccount(account, this.adultContent);
    }

    static /* synthetic */ rx.b lambda$saveAccount$0(rx.b bVar, Throwable th) {
        return bVar;
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public Single<Account> getAccount() {
        return this.wrappedAccountPersistence.getAccount().n(new rx.m.e() { // from class: cm.aptoide.pt.account.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3831f.a((Account) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public rx.b removeAccount() {
        return this.wrappedAccountPersistence.removeAccount().a(this.adultContent.disable(false));
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public rx.b saveAccount(Account account) {
        final rx.b bVarEnable = account.isAdultContentEnabled() ? this.adultContent.enable(account.isLoggedIn()) : this.adultContent.disable(account.isLoggedIn());
        return this.wrappedAccountPersistence.saveAccount(account).a(bVarEnable).C(new rx.m.e() { // from class: cm.aptoide.pt.account.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.b bVar = bVarEnable;
                MatureContentPersistence.lambda$saveAccount$0(bVar, (Throwable) obj);
                return bVar;
            }
        });
    }
}
