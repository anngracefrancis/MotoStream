package cm.aptoide.pt.account.view.user;

import android.content.Context;
import android.content.res.Resources;
import cm.aptoide.accountmanager.AccountValidationException;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.AccountErrorMapper;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.ThrowableToStringMapper;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class CreateUserErrorMapper implements ThrowableToStringMapper {
    private final AccountErrorMapper accountErrorMapper;
    private final Context context;
    private Resources resources;

    public CreateUserErrorMapper(Context context, AccountErrorMapper accountErrorMapper, Resources resources) {
        this.context = context;
        this.accountErrorMapper = accountErrorMapper;
        this.resources = resources;
    }

    @Override // cm.aptoide.pt.view.ThrowableToStringMapper
    public String map(Throwable th) {
        String map = this.accountErrorMapper.map(th);
        if ((th instanceof SocketTimeoutException) || (th instanceof TimeoutException)) {
            return this.context.getString(R.string.user_upload_photo_failed);
        }
        if (!(th instanceof AccountValidationException)) {
            return map;
        }
        int code = ((AccountValidationException) th).getCode();
        if (code != 5) {
            return code != 6 ? map : AptoideUtils.StringU.getResString(R.string.nothing_inserted_user, this.resources);
        }
        return AptoideUtils.StringU.getResString(R.string.no_username_inserted, this.resources);
    }
}
