package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.internal.q0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.w0;

/* JADX INFO: compiled from: LoginManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f10051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile x f10053d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SharedPreferences f10056g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10059j;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private t f10054e = t.NATIVE_WITH_FALLBACK;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private r f10055f = r.FRIENDS;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10057h = "rerequest";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private z f10060k = z.FACEBOOK;

    /* JADX INFO: compiled from: LoginManager.kt */
    private static final class a implements c0 {
        private final Activity a;

        public a(Activity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            this.a = activity;
        }

        @Override // com.facebook.login.c0
        public Activity a() {
            return this.a;
        }

        @Override // com.facebook.login.c0
        public void startActivityForResult(Intent intent, int i2) {
            kotlin.jvm.internal.m.f(intent, "intent");
            a().startActivityForResult(intent, i2);
        }
    }

    /* JADX INFO: compiled from: LoginManager.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> d() {
            return w0.i("ads_management", "create_event", "rsvp_event");
        }

        public final y b(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            kotlin.jvm.internal.m.f(request, "request");
            kotlin.jvm.internal.m.f(accessToken, "newToken");
            Set<String> setN = request.n();
            Set setH0 = kotlin.collections.c0.H0(kotlin.collections.c0.R(accessToken.j()));
            if (request.s()) {
                setH0.retainAll(setN);
            }
            Set setH1 = kotlin.collections.c0.H0(kotlin.collections.c0.R(setN));
            setH1.removeAll(setH0);
            return new y(accessToken, authenticationToken, setH0, setH1);
        }

        public x c() {
            if (x.f10053d == null) {
                synchronized (this) {
                    b bVar = x.a;
                    x.f10053d = new x();
                    kotlin.u uVar = kotlin.u.a;
                }
            }
            x xVar = x.f10053d;
            if (xVar != null) {
                return xVar;
            }
            kotlin.jvm.internal.m.w("instance");
            throw null;
        }

        public final boolean e(String str) {
            if (str != null) {
                return kotlin.text.u.E(str, "publish", false, 2, null) || kotlin.text.u.E(str, "manage", false, 2, null) || x.f10051b.contains(str);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: LoginManager.kt */
    private static final class c {
        public static final c a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static w f10061b;

        private c() {
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0011 A[Catch: all -> 0x000a, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x0011, B:14:0x0015, B:15:0x0022), top: B:20:0x0003 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x0015 A[Catch: all -> 0x000a, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x0011, B:14:0x0015, B:15:0x0022), top: B:20:0x0003 }] */
        /* JADX WARN: Code duplicated, block: B:9:0x000e  */
        public final synchronized w a(Context context) {
            if (context != null) {
                if (context == null) {
                    return null;
                }
                if (f10061b == null) {
                    com.facebook.a0 a0Var = com.facebook.a0.a;
                    f10061b = new w(context, com.facebook.a0.d());
                }
                return f10061b;
            }
            com.facebook.a0 a0Var2 = com.facebook.a0.a;
            context = com.facebook.a0.c();
            if (context == null) {
                return null;
            }
            if (f10061b == null) {
                com.facebook.a0 a0Var3 = com.facebook.a0.a;
                f10061b = new w(context, com.facebook.a0.d());
            }
            return f10061b;
            throw th;
        }
    }

    static {
        b bVar = new b(null);
        a = bVar;
        f10051b = bVar.d();
        String string = x.class.toString();
        kotlin.jvm.internal.m.e(string, "LoginManager::class.java.toString()");
        f10052c = string;
    }

    public x() {
        q0 q0Var = q0.a;
        q0.l();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        SharedPreferences sharedPreferences = com.facebook.a0.c().getSharedPreferences("com.facebook.loginManager", 0);
        kotlin.jvm.internal.m.e(sharedPreferences, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.f10056g = sharedPreferences;
        if (com.facebook.a0.q) {
            com.facebook.internal.v vVar = com.facebook.internal.v.a;
            if (com.facebook.internal.v.a() != null) {
                c.c.b.b.a(com.facebook.a0.c(), "com.android.chrome", new q());
                c.c.b.b.b(com.facebook.a0.c(), com.facebook.a0.c().getPackageName());
            }
        }
    }

    private final void e(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z, com.facebook.z<y> zVar) {
        if (accessToken != null) {
            AccessToken.f9559f.h(accessToken);
            Profile.f9636f.a();
        }
        if (authenticationToken != null) {
            AuthenticationToken.f9565f.a(authenticationToken);
        }
        if (zVar != null) {
            y yVarB = (accessToken == null || request == null) ? null : a.b(request, accessToken, authenticationToken);
            if (z || (yVarB != null && yVarB.b().isEmpty())) {
                zVar.onCancel();
                return;
            }
            if (facebookException != null) {
                zVar.onError(facebookException);
            } else {
                if (accessToken == null || yVarB == null) {
                    return;
                }
                t(true);
                zVar.onSuccess(yVarB);
            }
        }
    }

    public static x g() {
        return a.c();
    }

    private final void j(Context context, LoginClient.Result.a aVar, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        w wVarA = c.a.a(context);
        if (wVarA == null) {
            return;
        }
        if (request == null) {
            w.k(wVarA, "fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put("try_login_activity", z ? "1" : "0");
        wVarA.f(request.b(), map2, aVar, map, exc, request.q() ? "foa_mobile_login_complete" : "fb_mobile_login_complete");
    }

    private final void n(Context context, LoginClient.Request request) {
        w wVarA = c.a.a(context);
        if (wVarA == null || request == null) {
            return;
        }
        wVarA.i(request, request.q() ? "foa_mobile_login_start" : "fb_mobile_login_start");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean p(x xVar, int i2, Intent intent, com.facebook.z zVar, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if ((i3 & 4) != 0) {
            zVar = null;
        }
        return xVar.o(i2, intent, zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(x xVar, com.facebook.z zVar, int i2, Intent intent) {
        kotlin.jvm.internal.m.f(xVar, "this$0");
        return xVar.o(i2, intent, zVar);
    }

    private final boolean s(Intent intent) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return com.facebook.a0.c().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void t(boolean z) {
        SharedPreferences.Editor editorEdit = this.f10056g.edit();
        editorEdit.putBoolean("express_login_allowed", z);
        editorEdit.apply();
    }

    private final void u(c0 c0Var, LoginClient.Request request) throws FacebookException {
        n(c0Var.a(), request);
        com.facebook.internal.t.a.c(com.facebook.internal.t.c.Login.k(), new com.facebook.internal.t.a() { // from class: com.facebook.login.m
            @Override // com.facebook.internal.t.a
            public final boolean a(int i2, Intent intent) {
                return x.v(this.a, i2, intent);
            }
        });
        if (w(c0Var, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        j(c0Var.a(), LoginClient.Result.a.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(x xVar, int i2, Intent intent) {
        kotlin.jvm.internal.m.f(xVar, "this$0");
        return p(xVar, i2, intent, null, 4, null);
    }

    private final boolean w(c0 c0Var, LoginClient.Request request) {
        Intent intentF = f(request);
        if (!s(intentF)) {
            return false;
        }
        try {
            c0Var.startActivityForResult(intentF, LoginClient.f9960f.b());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void x(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (a.e(str)) {
                throw new FacebookException("Cannot pass a publish or manage permission (" + str + ") to a request for read authorization");
            }
        }
    }

    protected LoginClient.Request d(u uVar) {
        String strA;
        kotlin.jvm.internal.m.f(uVar, "loginConfig");
        p pVar = p.S256;
        try {
            b0 b0Var = b0.a;
            strA = b0.b(uVar.a(), pVar);
        } catch (FacebookException unused) {
            pVar = p.PLAIN;
            strA = uVar.a();
        }
        String str = strA;
        t tVar = this.f10054e;
        Set setI0 = kotlin.collections.c0.I0(uVar.c());
        r rVar = this.f10055f;
        String str2 = this.f10057h;
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String strD = com.facebook.a0.d();
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.e(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(tVar, setI0, rVar, str2, strD, string, this.f10060k, uVar.b(), uVar.a(), str, pVar);
        request.w(AccessToken.f9559f.g());
        request.u(this.f10058i);
        request.x(this.f10059j);
        request.t(this.l);
        request.y(this.m);
        return request;
    }

    protected Intent f(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        Intent intent = new Intent();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        intent.setClass(com.facebook.a0.c(), FacebookActivity.class);
        intent.setAction(request.j().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public final void k(Activity activity, u uVar) {
        kotlin.jvm.internal.m.f(activity, "activity");
        kotlin.jvm.internal.m.f(uVar, "loginConfig");
        if (activity instanceof androidx.activity.result.c) {
            Log.w(f10052c, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        u(new a(activity), d(uVar));
    }

    public final void l(Activity activity, Collection<String> collection) {
        kotlin.jvm.internal.m.f(activity, "activity");
        x(collection);
        k(activity, new u(collection, null, 2, null));
    }

    public void m() {
        AccessToken.f9559f.h(null);
        AuthenticationToken.f9565f.a(null);
        Profile.f9636f.c(null);
        t(false);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    public boolean o(int i2, Intent intent, com.facebook.z<y> zVar) {
        LoginClient.Result.a aVar;
        AccessToken accessToken;
        AuthenticationToken authenticationToken;
        LoginClient.Request request;
        Map<String, String> map;
        boolean z;
        AuthenticationToken authenticationToken2;
        LoginClient.Result.a aVar2 = LoginClient.Result.a.ERROR;
        FacebookException facebookException = null;
        boolean z2 = false;
        if (intent != null) {
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                request = result.l;
                LoginClient.Result.a aVar3 = result.f9973g;
                if (i2 != -1) {
                    if (i2 != 0) {
                        accessToken = null;
                        authenticationToken2 = null;
                    } else {
                        accessToken = null;
                        authenticationToken2 = null;
                        z2 = true;
                    }
                } else if (aVar3 == LoginClient.Result.a.SUCCESS) {
                    accessToken = result.f9974h;
                    authenticationToken2 = result.f9975i;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.f9976j);
                    accessToken = null;
                }
                map = result.m;
                z = z2;
                authenticationToken = authenticationToken2;
                aVar = aVar3;
            } else {
                aVar = aVar2;
                accessToken = null;
                authenticationToken = null;
                request = null;
                map = null;
                z = false;
            }
        } else if (i2 == 0) {
            aVar = LoginClient.Result.a.CANCEL;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = true;
        } else {
            aVar = aVar2;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = false;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        FacebookException facebookException2 = facebookException;
        LoginClient.Request request2 = request;
        j(null, aVar, map, facebookException2, true, request2);
        e(accessToken, authenticationToken, request2, facebookException2, z, zVar);
        return true;
    }

    public final void q(com.facebook.y yVar, final com.facebook.z<y> zVar) {
        if (!(yVar instanceof com.facebook.internal.t)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((com.facebook.internal.t) yVar).b(com.facebook.internal.t.c.Login.k(), new com.facebook.internal.t.a() { // from class: com.facebook.login.n
            @Override // com.facebook.internal.t.a
            public final boolean a(int i2, Intent intent) {
                return x.r(this.a, zVar, i2, intent);
            }
        });
    }
}
