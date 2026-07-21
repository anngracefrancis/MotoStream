package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import cm.aptoide.pt.account.AccountAnalytics;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
@KeepName
public class SignInHubActivity extends androidx.fragment.app.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f11529f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11530g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SignInConfiguration f11531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Intent f11534k;

    private class a implements c.p.a.a.InterfaceC0083a<Void> {
        private a() {
        }

        @Override // c.p.a.a.InterfaceC0083a
        public final /* synthetic */ void a(c.p.b.b<Void> bVar, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f11533j, SignInHubActivity.this.f11534k);
            SignInHubActivity.this.finish();
        }

        @Override // c.p.a.a.InterfaceC0083a
        public final c.p.b.b<Void> b(int i2, Bundle bundle) {
            return new zze(SignInHubActivity.this, GoogleApiClient.l());
        }

        @Override // c.p.a.a.InterfaceC0083a
        public final void c(c.p.b.b<Void> bVar) {
        }
    }

    private final void b(int i2) {
        Status status = new Status(i2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f11529f = false;
    }

    private final void d() {
        getSupportLoaderManager().c(0, null, new a());
        f11529f = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        if (this.f11530g) {
            return;
        }
        setResult(0);
        if (i2 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.x() != null) {
                GoogleSignInAccount googleSignInAccountX = signInAccount.x();
                zzp.c(this).b(this.f11531h.y(), googleSignInAccountX);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", googleSignInAccountX);
                this.f11532i = true;
                this.f11533j = i3;
                this.f11534k = intent;
                d();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = AccountAnalytics.UNKNOWN_STATUS_CODE;
                }
                b(intExtra);
                return;
            }
        }
        b(8);
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            b(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String strValueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", strValueOf.length() != 0 ? "Unknown action: ".concat(strValueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
        this.f11531h = signInConfiguration;
        if (signInConfiguration == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        if (!(bundle == null)) {
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.f11532i = z;
            if (z) {
                this.f11533j = bundle.getInt("signInResultCode");
                this.f11534k = (Intent) bundle.getParcelable("signInResultData");
                d();
                return;
            }
            return;
        }
        if (f11529f) {
            setResult(0);
            b(12502);
            return;
        }
        f11529f = true;
        Intent intent2 = new Intent(action);
        if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent2.setPackage("com.google.android.gms");
        } else {
            intent2.setPackage(getPackageName());
        }
        intent2.putExtra("config", this.f11531h);
        try {
            startActivityForResult(intent2, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f11530g = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            b(17);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f11532i);
        if (this.f11532i) {
            bundle.putInt("signInResultCode", this.f11533j);
            bundle.putParcelable("signInResultData", this.f11534k);
        }
    }
}
