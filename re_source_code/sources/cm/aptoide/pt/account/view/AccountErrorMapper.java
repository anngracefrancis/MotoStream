package cm.aptoide.pt.account.view;

import android.content.Context;
import cm.aptoide.accountmanager.AccountException;
import cm.aptoide.accountmanager.AccountValidationException;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.ErrorsMapper;
import cm.aptoide.pt.account.FacebookSignUpException;
import cm.aptoide.pt.account.GoogleSignUpException;
import cm.aptoide.pt.dataprovider.util.ErrorUtils;
import cm.aptoide.pt.view.ThrowableToStringMapper;

/* JADX INFO: loaded from: classes.dex */
public class AccountErrorMapper implements ThrowableToStringMapper {
    private final Context context;
    private final ErrorsMapper errorsMapper;

    public AccountErrorMapper(Context context, ErrorsMapper errorsMapper) {
        this.context = context;
        this.errorsMapper = errorsMapper;
    }

    @Override // cm.aptoide.pt.view.ThrowableToStringMapper
    public String map(Throwable th) {
        String string;
        String string2 = this.context.getString(R.string.unknown_error);
        if (th instanceof GoogleSignUpException) {
            return this.context.getString(R.string.google_login_cancelled);
        }
        if (th instanceof FacebookSignUpException) {
            int code = ((FacebookSignUpException) th).getCode();
            if (code == 1) {
                return this.context.getString(R.string.facebook_email_permission_regected_message);
            }
            if (code != 2) {
                return code != 99 ? string2 : this.context.getString(R.string.error_occured);
            }
            return this.context.getString(R.string.facebook_login_cancelled);
        }
        if (th instanceof AccountException) {
            AccountException accountException = (AccountException) th;
            if (accountException.hasCode()) {
                return this.context.getString(this.errorsMapper.getWebServiceErrorMessageFromCode(accountException.getCode(), this.context.getApplicationContext().getPackageName(), this.context.getResources()));
            }
            return this.context.getString(this.context.getResources().getIdentifier("ws_error_" + accountException.getErrors().entrySet().iterator().next().getKey().replace("-", "_"), "string", this.context.getPackageName()));
        }
        if (!(th instanceof AccountValidationException)) {
            return ErrorUtils.isNoNetworkConnection(th) ? this.context.getString(R.string.connection_error) : string2;
        }
        int code2 = ((AccountValidationException) th).getCode();
        if (code2 == 1) {
            string = this.context.getString(R.string.no_email_error_message);
        } else if (code2 == 2) {
            string = this.context.getString(R.string.no_pass_error_message);
        } else if (code2 == 3) {
            string = this.context.getString(R.string.no_email_and_pass_error_message);
        } else if (code2 == 4) {
            string = this.context.getString(R.string.password_validation_text);
        } else {
            if (code2 != 5) {
                return string2;
            }
            string = this.context.getString(R.string.nothing_inserted_user);
        }
        return string;
    }
}
