package cm.aptoide.pt.networking;

import android.accounts.Account;
import android.accounts.AccountManager;
import cm.aptoide.pt.account.AndroidAccountProvider;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationPersistence {
    public static final String ACCOUNT_ACCESS_TOKEN = "access_token";
    public static final String ACCOUNT_REFRESH_TOKEN = "refresh_token";
    public static final String ACCOUNT_TYPE = "aptoide_account_manager_login_mode";
    private final AccountManager androidAccountManager;
    private final AndroidAccountProvider androidAccountProvider;

    public AuthenticationPersistence(AndroidAccountProvider androidAccountProvider, AccountManager accountManager) {
        this.androidAccountProvider = androidAccountProvider;
        this.androidAccountManager = accountManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createAuthentication$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, Account account) {
        this.androidAccountManager.setUserData(account, ACCOUNT_REFRESH_TOKEN, str);
        this.androidAccountManager.setUserData(account, "access_token", str2);
        this.androidAccountManager.setPassword(account, str3);
        this.androidAccountManager.setUserData(account, ACCOUNT_TYPE, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAuthentication$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Authentication b(Account account) {
        return new Authentication(account.name, this.androidAccountManager.getUserData(account, ACCOUNT_REFRESH_TOKEN), this.androidAccountManager.getUserData(account, "access_token"), this.androidAccountManager.getPassword(account), this.androidAccountManager.getUserData(account, ACCOUNT_TYPE));
    }

    static /* synthetic */ Authentication lambda$getAuthentication$1(Throwable th) {
        return new Authentication(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAuthentication$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(String str, Account account) {
        this.androidAccountManager.setUserData(account, "access_token", str);
    }

    public rx.b createAuthentication(String str, final String str2, final String str3, final String str4, final String str5) {
        return this.androidAccountProvider.createAndroidAccount(str).g(new rx.m.b() { // from class: cm.aptoide.pt.networking.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6632f.a(str3, str4, str2, str5, (Account) obj);
            }
        }).z();
    }

    public Single<Authentication> getAuthentication() {
        return this.androidAccountProvider.getAndroidAccount().n(new rx.m.e() { // from class: cm.aptoide.pt.networking.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6629f.b((Account) obj);
            }
        }).r(new rx.m.e() { // from class: cm.aptoide.pt.networking.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AuthenticationPersistence.lambda$getAuthentication$1((Throwable) obj);
            }
        });
    }

    public rx.b removeAuthentication() {
        return this.androidAccountProvider.removeAndroidAccount();
    }

    public rx.b updateAuthentication(final String str) {
        return this.androidAccountProvider.getAndroidAccount().g(new rx.m.b() { // from class: cm.aptoide.pt.networking.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6630f.c(str, (Account) obj);
            }
        }).z();
    }
}
