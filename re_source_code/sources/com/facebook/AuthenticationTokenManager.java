package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.p0;
import kotlin.Metadata;

/* JADX INFO: compiled from: AuthenticationTokenManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AuthenticationTokenManager {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AuthenticationTokenManager f9581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c.q.a.a f9582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x f9583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AuthenticationToken f9584e;

    /* JADX INFO: compiled from: AuthenticationTokenManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lkotlin/u;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(intent, "intent");
        }
    }

    /* JADX INFO: compiled from: AuthenticationTokenManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final AuthenticationTokenManager a() {
            AuthenticationTokenManager authenticationTokenManager;
            AuthenticationTokenManager authenticationTokenManager2 = AuthenticationTokenManager.f9581b;
            if (authenticationTokenManager2 != null) {
                return authenticationTokenManager2;
            }
            synchronized (this) {
                authenticationTokenManager = AuthenticationTokenManager.f9581b;
                if (authenticationTokenManager == null) {
                    a0 a0Var = a0.a;
                    c.q.a.a aVarB = c.q.a.a.b(a0.c());
                    kotlin.jvm.internal.m.e(aVarB, "getInstance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager3 = new AuthenticationTokenManager(aVarB, new x());
                    a aVar = AuthenticationTokenManager.a;
                    AuthenticationTokenManager.f9581b = authenticationTokenManager3;
                    authenticationTokenManager = authenticationTokenManager3;
                }
            }
            return authenticationTokenManager;
        }
    }

    public AuthenticationTokenManager(c.q.a.a aVar, x xVar) {
        kotlin.jvm.internal.m.f(aVar, "localBroadcastManager");
        kotlin.jvm.internal.m.f(xVar, "authenticationTokenCache");
        this.f9582c = aVar;
        this.f9583d = xVar;
    }

    private final void d(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2) {
        a0 a0Var = a0.a;
        Intent intent = new Intent(a0.c(), (Class<?>) CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN", authenticationToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN", authenticationToken2);
        this.f9582c.d(intent);
    }

    private final void f(AuthenticationToken authenticationToken, boolean z) {
        AuthenticationToken authenticationTokenC = c();
        this.f9584e = authenticationToken;
        if (z) {
            if (authenticationToken != null) {
                this.f9583d.b(authenticationToken);
            } else {
                this.f9583d.a();
                p0 p0Var = p0.a;
                a0 a0Var = a0.a;
                p0.g(a0.c());
            }
        }
        p0 p0Var2 = p0.a;
        if (p0.c(authenticationTokenC, authenticationToken)) {
            return;
        }
        d(authenticationTokenC, authenticationToken);
    }

    public final AuthenticationToken c() {
        return this.f9584e;
    }

    public final void e(AuthenticationToken authenticationToken) {
        f(authenticationToken, true);
    }
}
