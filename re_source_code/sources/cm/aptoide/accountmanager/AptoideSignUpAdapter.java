package cm.aptoide.accountmanager;

import java.net.SocketTimeoutException;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AptoideSignUpAdapter implements SignUpAdapter<AptoideCredentials> {
    private final CredentialsValidator credentialsValidator;

    public AptoideSignUpAdapter(CredentialsValidator credentialsValidator) {
        this.credentialsValidator = credentialsValidator;
    }

    static /* synthetic */ Account lambda$signUp$0(c.i.j.e eVar) {
        return (Account) eVar.a;
    }

    static /* synthetic */ Single lambda$signUp$1(AccountService accountService, AptoideCredentials aptoideCredentials, Throwable th) {
        return th instanceof SocketTimeoutException ? accountService.getAccount(aptoideCredentials.getEmail(), aptoideCredentials.getCode(), HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET).n(new rx.m.e() { // from class: cm.aptoide.accountmanager.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AptoideSignUpAdapter.lambda$signUp$0((c.i.j.e) obj);
            }
        }) : Single.h(th);
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public boolean isEnabled() {
        return true;
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public rx.b logout() {
        return rx.b.e();
    }

    @Override // cm.aptoide.accountmanager.SignUpAdapter
    public Single<Account> signUp(final AptoideCredentials aptoideCredentials, final AccountService accountService) {
        return this.credentialsValidator.validate(aptoideCredentials).c(accountService.createAccount(aptoideCredentials.getEmail(), aptoideCredentials.getCode())).q(new rx.m.e() { // from class: cm.aptoide.accountmanager.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AptoideSignUpAdapter.lambda$signUp$1(accountService, aptoideCredentials, (Throwable) obj);
            }
        });
    }
}
