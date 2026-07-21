package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.logging.Logger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zzh {
    private static Logger a = new Logger("GoogleSignInCommon", new String[0]);

    public static GoogleSignInResult a(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra("googleSignInStatus") && !intent.hasExtra("googleSignInAccount")) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.f11688g;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions) {
        a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static PendingResult<Status> c(GoogleApiClient googleApiClient, Context context, boolean z) {
        a.a("Signing out", new Object[0]);
        d(context);
        return z ? PendingResults.b(Status.f11688g, googleApiClient) : googleApiClient.k(new a(googleApiClient));
    }

    private static void d(Context context) {
        zzp.c(context).a();
        Iterator<GoogleApiClient> it = GoogleApiClient.l().iterator();
        while (it.hasNext()) {
            it.next().r();
        }
        GoogleApiManager.b();
    }

    public static PendingResult<Status> e(GoogleApiClient googleApiClient, Context context, boolean z) {
        a.a("Revoking access", new Object[0]);
        String strE = Storage.b(context).e();
        d(context);
        return z ? zzd.a(strE) : googleApiClient.k(new c(googleApiClient));
    }
}
