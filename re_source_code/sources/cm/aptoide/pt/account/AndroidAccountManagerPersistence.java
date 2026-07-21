package cm.aptoide.pt.account;

import android.accounts.AccountManager;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AccountFactory;
import cm.aptoide.accountmanager.AccountPersistence;
import cm.aptoide.accountmanager.Store;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.Authentication;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAccountManagerPersistence implements AccountPersistence {
    public static final String ACCOUNT_ACCESS_CONFIRMED = "access_confirmed";
    public static final String ACCOUNT_ACCESS_LEVEL = "access";
    public static final String ACCOUNT_ADULT_CONTENT_ENABLED = "aptoide_account_manager_mature_switch";
    public static final String ACCOUNT_AVATAR_URL = "useravatar";
    public static final String ACCOUNT_ID = "userId";
    public static final String ACCOUNT_NICKNAME = "username";
    private static final String ACCOUNT_PRIVACY_POLICY = "account_privacy_policy";
    public static final String ACCOUNT_STORE_AVATAR_URL = "storeAvatar";
    private static final String ACCOUNT_STORE_DOWNLOAD_COUNT = "account_store_download_count";
    private static final String ACCOUNT_STORE_ID = "account_store_id";
    public static final String ACCOUNT_STORE_NAME = "userRepo";
    private static final String ACCOUNT_STORE_PASSWORD = "account_store_password";
    private static final String ACCOUNT_STORE_THEME = "account_store_theme";
    private static final String ACCOUNT_STORE_USERNAME = "account_store_username";
    private static final String ACCOUNT_TERMS_AND_CONDITIONS = "account_terms_and_conditions";
    private Account accountCache;
    private final AccountFactory accountFactory;
    private final AccountManager androidAccountManager;
    private final AndroidAccountProvider androidAccountProvider;
    private final AuthenticationPersistence authenticationPersistence;
    private final rx.h scheduler;
    private final DatabaseStoreDataPersist storePersist;

    public AndroidAccountManagerPersistence(AccountManager accountManager, DatabaseStoreDataPersist databaseStoreDataPersist, AccountFactory accountFactory, AndroidAccountProvider androidAccountProvider, AuthenticationPersistence authenticationPersistence, rx.h hVar) {
        this.androidAccountManager = accountManager;
        this.storePersist = databaseStoreDataPersist;
        this.accountFactory = accountFactory;
        this.androidAccountProvider = androidAccountProvider;
        this.authenticationPersistence = authenticationPersistence;
        this.scheduler = hVar;
    }

    private Store createStore(android.accounts.Account account) {
        return new Store(Long.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_STORE_DOWNLOAD_COUNT)).longValue(), this.androidAccountManager.getUserData(account, ACCOUNT_STORE_AVATAR_URL), Long.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_STORE_ID)).longValue(), this.androidAccountManager.getUserData(account, ACCOUNT_STORE_NAME), this.androidAccountManager.getUserData(account, ACCOUNT_STORE_THEME), this.androidAccountManager.getUserData(account, ACCOUNT_STORE_USERNAME), this.androidAccountManager.getUserData(account, ACCOUNT_STORE_PASSWORD), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(String str, List list, android.accounts.Account account, boolean z, boolean z2, Authentication authentication) {
        return authentication.isAuthenticated() ? Single.m(this.accountFactory.createAccount(str, list, this.androidAccountManager.getUserData(account, ACCOUNT_ID), account.name, this.androidAccountManager.getUserData(account, "username"), this.androidAccountManager.getUserData(account, ACCOUNT_AVATAR_URL), createStore(account), Boolean.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_ADULT_CONTENT_ENABLED)).booleanValue(), Boolean.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_ACCESS_CONFIRMED)).booleanValue(), z, z2)) : Single.h(new IllegalStateException("Account not authenticated"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single b(final String str, final android.accounts.Account account, final boolean z, final boolean z2, final List list) {
        return this.authenticationPersistence.getAuthentication().i(new rx.m.e() { // from class: cm.aptoide.pt.account.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3787f.a(str, list, account, z, z2, (Authentication) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAccount$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(final android.accounts.Account account) {
        final String userData = this.androidAccountManager.getUserData(account, ACCOUNT_ACCESS_LEVEL);
        final boolean zBooleanValue = this.androidAccountManager.getUserData(account, ACCOUNT_TERMS_AND_CONDITIONS) != null ? Boolean.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_TERMS_AND_CONDITIONS)).booleanValue() : false;
        final boolean zBooleanValue2 = this.androidAccountManager.getUserData(account, ACCOUNT_PRIVACY_POLICY) != null ? Boolean.valueOf(this.androidAccountManager.getUserData(account, ACCOUNT_PRIVACY_POLICY)).booleanValue() : false;
        return this.storePersist.get().e(new rx.m.b() { // from class: cm.aptoide.pt.account.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }).i(new rx.m.e() { // from class: cm.aptoide.pt.account.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3780f.b(userData, account, zBooleanValue2, zBooleanValue, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeAccount$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.accountCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveAccount$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Account account) {
        this.accountCache = account;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveAccount$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(final Account account, android.accounts.Account account2) {
        this.androidAccountManager.setUserData(account2, ACCOUNT_ID, account.getId());
        this.androidAccountManager.setUserData(account2, "username", account.getNickname());
        this.androidAccountManager.setUserData(account2, ACCOUNT_AVATAR_URL, account.getAvatar());
        this.androidAccountManager.setUserData(account2, ACCOUNT_ADULT_CONTENT_ENABLED, String.valueOf(account.isAdultContentEnabled()));
        this.androidAccountManager.setUserData(account2, ACCOUNT_ACCESS_LEVEL, account.getAccess().name());
        this.androidAccountManager.setUserData(account2, ACCOUNT_ACCESS_CONFIRMED, String.valueOf(account.isAccessConfirmed()));
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_NAME, account.getStore().getName());
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_AVATAR_URL, account.getStore().getAvatar());
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_DOWNLOAD_COUNT, String.valueOf(account.getStore().getDownloadCount()));
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_ID, String.valueOf(account.getStore().getId()));
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_THEME, account.getStore().getTheme());
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_USERNAME, account.getStore().getUsername());
        this.androidAccountManager.setUserData(account2, ACCOUNT_STORE_PASSWORD, account.getStore().getPassword());
        this.androidAccountManager.setUserData(account2, ACCOUNT_TERMS_AND_CONDITIONS, String.valueOf(account.acceptedTermsAndConditions()));
        this.androidAccountManager.setUserData(account2, ACCOUNT_PRIVACY_POLICY, String.valueOf(account.acceptedPrivacyPolicy()));
        return this.storePersist.persist(account.getSubscribedStores()).m(new rx.m.a() { // from class: cm.aptoide.pt.account.d0
            @Override // rx.m.a
            public final void call() {
                this.f3777f.e(account);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public Single<Account> getAccount() {
        Account account = this.accountCache;
        return account != null ? Single.m(account) : this.androidAccountProvider.getAndroidAccount().i(new rx.m.e() { // from class: cm.aptoide.pt.account.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3773f.c((android.accounts.Account) obj);
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public rx.b removeAccount() {
        return this.androidAccountProvider.removeAndroidAccount().m(new rx.m.a() { // from class: cm.aptoide.pt.account.a0
            @Override // rx.m.a
            public final void call() {
                this.f3771f.d();
            }
        });
    }

    @Override // cm.aptoide.accountmanager.AccountPersistence
    public rx.b saveAccount(final Account account) {
        return this.androidAccountProvider.getAndroidAccount().j(new rx.m.e() { // from class: cm.aptoide.pt.account.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3794f.f(account, (android.accounts.Account) obj);
            }
        }).K(this.scheduler);
    }
}
