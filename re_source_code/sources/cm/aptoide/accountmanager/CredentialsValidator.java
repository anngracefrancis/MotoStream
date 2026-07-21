package cm.aptoide.accountmanager;

import android.util.Patterns;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class CredentialsValidator {
    private boolean checkIsEmailValid(String str) {
        return !isEmpty(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    private boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$validate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(AptoideCredentials aptoideCredentials) {
        int iValidateFields = validateFields(aptoideCredentials);
        return iValidateFields != -1 ? rx.b.s(new AccountValidationException(iValidateFields)) : rx.b.e();
    }

    public Single<Boolean> isEmailValid(String str) {
        return Single.m(Boolean.valueOf(checkIsEmailValid(str)));
    }

    public rx.b validate(final AptoideCredentials aptoideCredentials) {
        return rx.b.i(new rx.m.d() { // from class: cm.aptoide.accountmanager.w
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f3718f.a(aptoideCredentials);
            }
        });
    }

    protected int validateFields(AptoideCredentials aptoideCredentials) {
        if (isEmpty(aptoideCredentials.getEmail()) && isEmpty(aptoideCredentials.getCode())) {
            return 3;
        }
        if (isEmpty(aptoideCredentials.getCode())) {
            return 2;
        }
        return isEmpty(aptoideCredentials.getEmail()) ? 1 : -1;
    }
}
