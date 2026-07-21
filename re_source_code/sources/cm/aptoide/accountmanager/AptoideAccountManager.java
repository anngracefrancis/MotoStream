package cm.aptoide.accountmanager;

import android.text.TextUtils;
import cm.aptoide.pt.crashreports.CrashReport;
import com.aptoide.authentication.model.CodeAuth;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AptoideAccountManager {
    public static final String APTOIDE_SIGN_UP_TYPE = "APTOIDE";
    private final AccountPersistence accountPersistence;
    private final e.g.b.c<Account> accountRelay;
    private final AccountService accountService;
    private final SignUpAdapterRegistry adapterRegistry;
    private final AdultContent adultContent;
    private final CredentialsValidator credentialsValidator;
    private final StoreManager storeManager;

    public static class Builder {
        private AccountPersistence accountPersistence;
        private e.g.b.c<Account> accountRelay;
        private AccountService accountService;
        private final Map<String, SignUpAdapter> adapters = new HashMap();
        private AdultContent adultContent;
        private CredentialsValidator credentialsValidator;
        private StoreManager storeManager;

        public AptoideAccountManager build() {
            if (this.accountPersistence == null) {
                throw new IllegalArgumentException("AccountDataPersist is mandatory.");
            }
            if (this.accountService == null) {
                throw new IllegalArgumentException("AccountManagerService is mandatory.");
            }
            if (this.storeManager == null) {
                throw new IllegalArgumentException("StoreManager is mandatory.");
            }
            if (this.credentialsValidator == null) {
                this.credentialsValidator = new CredentialsValidator();
            }
            if (this.accountRelay == null) {
                this.accountRelay = e.g.b.c.f1();
            }
            SignUpAdapterRegistry signUpAdapterRegistry = new SignUpAdapterRegistry(this.adapters, this.accountService);
            signUpAdapterRegistry.register(AptoideAccountManager.APTOIDE_SIGN_UP_TYPE, new AptoideSignUpAdapter(this.credentialsValidator));
            return new AptoideAccountManager(this.credentialsValidator, this.accountPersistence, this.accountService, this.accountRelay, signUpAdapterRegistry, this.storeManager, this.adultContent);
        }

        public Builder registerSignUpAdapter(String str, SignUpAdapter signUpAdapter) {
            this.adapters.put(str, signUpAdapter);
            return this;
        }

        public Builder setAccountPersistence(AccountPersistence accountPersistence) {
            this.accountPersistence = accountPersistence;
            return this;
        }

        public Builder setAccountRelay(e.g.b.c<Account> cVar) {
            this.accountRelay = cVar;
            return this;
        }

        public Builder setAccountService(AccountService accountService) {
            this.accountService = accountService;
            return this;
        }

        public Builder setAdultService(AdultContent adultContent) {
            this.adultContent = adultContent;
            return this;
        }

        public Builder setCredentialsValidator(CredentialsValidator credentialsValidator) {
            this.credentialsValidator = credentialsValidator;
            return this;
        }

        public Builder setStoreManager(StoreManager storeManager) {
            this.storeManager = storeManager;
            return this;
        }
    }

    private Account createLocalAccount() {
        return new LocalAccount(Store.emptyStore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$accountStatus$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Account a(Throwable th) {
        return createLocalAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$disable$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(Account account) {
        return this.adultContent.disable(account.isLoggedIn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$enable$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(Account account) {
        return this.adultContent.enable(account.isLoggedIn());
    }

    static /* synthetic */ Account lambda$getAccount$1(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$login$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single d(c.i.j.e eVar) {
        return lambda$syncAccount$7((Account) eVar.a).c(Single.m((Boolean) eVar.f3281b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$logout$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(Account account) {
        return this.accountService.removeAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$logout$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        this.accountRelay.call(createLocalAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveAccount$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Account account) {
        this.accountRelay.call(account);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncAccount$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single i(Account account) {
        return this.accountService.getAccount(account.getEmail());
    }

    static /* synthetic */ void lambda$unsubscribeStore$9() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAccount$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b k(boolean z, Account account) {
        return this.accountService.updateAccount(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAccount$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b l(String str, Account account) {
        return this.accountService.updateAccountUsername(str).a(syncAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAccount$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b m(Account.Access access, Account account) {
        return this.accountService.updateAccount(access.name()).a(syncAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAccount$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b n(String str, String str2, Account account) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return rx.b.s(new AccountValidationException(6));
        }
        if (TextUtils.isEmpty(str)) {
            return rx.b.s(new AccountValidationException(5));
        }
        AccountService accountService = this.accountService;
        if (TextUtils.isEmpty(str2)) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return accountService.updateAccount(str, str2).a(syncAccount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAccount$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b o(Account account) {
        return syncAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateTermsAndConditions$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b p(Account account) {
        return this.accountPersistence.saveAccount(new AptoideAccount(account.getId(), account.getEmail(), account.getNickname(), account.getAvatar(), account.getStore(), account.isAdultContentEnabled(), account.getAccess(), account.isAccessConfirmed(), account.getSubscribedStores(), true, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: saveAccount, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public rx.b j(final Account account) {
        return this.accountPersistence.saveAccount(account).m(new rx.m.a() { // from class: cm.aptoide.accountmanager.s
            @Override // rx.m.a
            public final void call() {
                this.f3711f.g(account);
            }
        });
    }

    private Single<Account> singleAccountStatus() {
        return accountStatus().E().Z0();
    }

    private rx.b syncAccount() {
        return this.accountPersistence.getAccount().i(new rx.m.e() { // from class: cm.aptoide.accountmanager.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3702f.i((Account) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.accountmanager.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3690f.j((Account) obj);
            }
        });
    }

    public rx.e<Account> accountStatus() {
        return rx.e.a0(this.accountRelay, this.accountPersistence.getAccount().r(new rx.m.e() { // from class: cm.aptoide.accountmanager.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3705f.a((Throwable) obj);
            }
        }).A());
    }

    public rx.b createOrUpdate(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        return this.storeManager.createOrUpdate(str, str2, str3, z, str4, z2).a(syncAccount());
    }

    public rx.b disable() {
        return accountStatus().E().H(new rx.m.e() { // from class: cm.aptoide.accountmanager.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3703f.b((Account) obj);
            }
        }).X0();
    }

    public rx.b enable() {
        return accountStatus().E().H(new rx.m.e() { // from class: cm.aptoide.accountmanager.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3691f.c((Account) obj);
            }
        }).X0();
    }

    public rx.b generateEmailCode(String str) {
        return str.isEmpty() ? rx.b.s(new AccountValidationException(1)) : rx.b.e();
    }

    @Deprecated
    public Account getAccount() {
        return singleAccountStatus().r(new rx.m.e() { // from class: cm.aptoide.accountmanager.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                AptoideAccountManager.lambda$getAccount$1((Throwable) obj);
                return null;
            }
        }).y().b();
    }

    public rx.e<Boolean> hasMatureContentEnabled() {
        return this.adultContent.enabled();
    }

    @Deprecated
    public boolean isAccountAccessConfirmed() {
        Account account = getAccount();
        return account != null && account.isAccessConfirmed();
    }

    @Deprecated
    public boolean isAccountMature() {
        Account account = getAccount();
        return account != null && account.isAdultContentEnabled();
    }

    public Single<Boolean> isEmailValid(String str) {
        return this.credentialsValidator.isEmailValid(str);
    }

    @Deprecated
    public boolean isLoggedIn() {
        Account account = getAccount();
        return account != null && account.isLoggedIn();
    }

    public boolean isSignUpEnabled(String str) {
        return this.adapterRegistry.isEnabled(str);
    }

    public Single<Boolean> login(AptoideCredentials aptoideCredentials) {
        return this.credentialsValidator.validate(aptoideCredentials).c(this.accountService.getAccount(aptoideCredentials.getEmail(), aptoideCredentials.getCode(), aptoideCredentials.getState(), aptoideCredentials.getAgent())).i(new rx.m.e() { // from class: cm.aptoide.accountmanager.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3700f.d((c.i.j.e) obj);
            }
        });
    }

    public rx.b logout() {
        return this.adapterRegistry.logoutAll().a(singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3692f.e((Account) obj);
            }
        }).a(this.accountPersistence.removeAccount()).m(new rx.m.a() { // from class: cm.aptoide.accountmanager.l
            @Override // rx.m.a
            public final void call() {
                this.f3704f.f();
            }
        }));
    }

    public rx.e<Boolean> pinRequired() {
        return this.adultContent.pinRequired();
    }

    public rx.b removePin(int i2) {
        return this.adultContent.removePin(i2);
    }

    public rx.b requirePin(int i2) {
        return this.adultContent.requirePin(i2);
    }

    public Single<CodeAuth> sendMagicLink(String str) {
        return this.accountService.sendMagicLink(str);
    }

    public <T> rx.b signUp(String str, T t) {
        return this.adapterRegistry.signUp(str, t).j(new rx.m.e() { // from class: cm.aptoide.accountmanager.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3701f.h((Account) obj);
            }
        });
    }

    public rx.b subscribeStore(String str, String str2, String str3) {
        return this.accountService.subscribeStore(str, str2, str3);
    }

    public void unsubscribeStore(String str, String str2, String str3) {
        this.accountService.unsubscribeStore(str, str2, str3).I(new rx.m.a() { // from class: cm.aptoide.accountmanager.f
            @Override // rx.m.a
            public final void call() {
                AptoideAccountManager.lambda$unsubscribeStore$9();
            }
        }, new rx.m.b() { // from class: cm.aptoide.accountmanager.g
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    public rx.b updateAccount(final boolean z) {
        return singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3713f.k(z, (Account) obj);
            }
        });
    }

    public rx.b updateTermsAndConditions() {
        return this.accountService.updateTermsAndConditions().b(accountStatus()).H(new rx.m.e() { // from class: cm.aptoide.accountmanager.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3710f.p((Account) obj);
            }
        }).X0();
    }

    private AptoideAccountManager(CredentialsValidator credentialsValidator, AccountPersistence accountPersistence, AccountService accountService, e.g.b.c<Account> cVar, SignUpAdapterRegistry signUpAdapterRegistry, StoreManager storeManager, AdultContent adultContent) {
        this.credentialsValidator = credentialsValidator;
        this.accountPersistence = accountPersistence;
        this.accountService = accountService;
        this.accountRelay = cVar;
        this.adapterRegistry = signUpAdapterRegistry;
        this.storeManager = storeManager;
        this.adultContent = adultContent;
    }

    public rx.b updateAccount(final String str) {
        return TextUtils.isEmpty(str) ? rx.b.s(new AccountValidationException(5)) : singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3696f.l(str, (Account) obj);
            }
        });
    }

    public rx.b enable(int i2) {
        return this.adultContent.enable(i2);
    }

    public rx.b updateAccount(final Account.Access access) {
        return singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3707f.m(access, (Account) obj);
            }
        });
    }

    public rx.b updateAccount(final String str, final String str2) {
        return singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3693f.n(str, str2, (Account) obj);
            }
        });
    }

    @Deprecated
    public rx.b updateAccount() {
        return singleAccountStatus().j(new rx.m.e() { // from class: cm.aptoide.accountmanager.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3709f.o((Account) obj);
            }
        });
    }
}
