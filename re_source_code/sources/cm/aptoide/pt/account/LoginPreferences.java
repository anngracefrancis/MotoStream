package cm.aptoide.pt.account;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;

/* JADX INFO: loaded from: classes.dex */
public class LoginPreferences {
    private final Context context;
    private final GoogleApiAvailability googleApiAvailability;

    public LoginPreferences(Context context, GoogleApiAvailability googleApiAvailability) {
        this.context = context;
        this.googleApiAvailability = googleApiAvailability;
    }

    public boolean isFacebookLoginEnabled() {
        return true;
    }

    public boolean isGoogleLoginEnabled() {
        return this.googleApiAvailability.i(this.context) == 0;
    }
}
