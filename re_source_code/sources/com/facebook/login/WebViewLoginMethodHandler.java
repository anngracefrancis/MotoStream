package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.account.view.LoginActivity;
import com.facebook.FacebookException;
import com.facebook.internal.p0;
import com.facebook.internal.r0;

/* JADX INFO: compiled from: WebViewLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    private r0 l;
    private String m;
    private final String n;
    private final com.facebook.w o;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f9989k = new c(null);
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new b();

    /* JADX INFO: compiled from: WebViewLoginMethodHandler.kt */
    public final class a extends r0.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f9990h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private t f9991i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private z f9992j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f9993k;
        private boolean l;
        public String m;
        public String n;
        final /* synthetic */ WebViewLoginMethodHandler o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WebViewLoginMethodHandler webViewLoginMethodHandler, Context context, String str, Bundle bundle) {
            super(context, str, "oauth", bundle);
            kotlin.jvm.internal.m.f(webViewLoginMethodHandler, "this$0");
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(str, "applicationId");
            kotlin.jvm.internal.m.f(bundle, "parameters");
            this.o = webViewLoginMethodHandler;
            this.f9990h = "fbconnect://success";
            this.f9991i = t.NATIVE_WITH_FALLBACK;
            this.f9992j = z.FACEBOOK;
        }

        @Override // com.facebook.internal.r0.a
        public r0 a() {
            Bundle bundleF = f();
            if (bundleF == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
            }
            bundleF.putString("redirect_uri", this.f9990h);
            bundleF.putString("client_id", c());
            bundleF.putString("e2e", j());
            bundleF.putString("response_type", this.f9992j == z.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain");
            bundleF.putString("return_scopes", "true");
            bundleF.putString(LoginActivity.AUTH_TYPE, i());
            bundleF.putString("login_behavior", this.f9991i.name());
            if (this.f9993k) {
                bundleF.putString("fx_app", this.f9992j.toString());
            }
            if (this.l) {
                bundleF.putString("skip_dedupe", "true");
            }
            r0.b bVar = r0.f9841f;
            Context contextD = d();
            if (contextD != null) {
                return bVar.d(contextD, "oauth", bundleF, g(), this.f9992j, e());
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
        }

        public final String i() {
            String str = this.n;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.m.w("authType");
            throw null;
        }

        public final String j() {
            String str = this.m;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.m.w("e2e");
            throw null;
        }

        public final a k(String str) {
            kotlin.jvm.internal.m.f(str, "authType");
            l(str);
            return this;
        }

        public final void l(String str) {
            kotlin.jvm.internal.m.f(str, "<set-?>");
            this.n = str;
        }

        public final a m(String str) {
            kotlin.jvm.internal.m.f(str, "e2e");
            n(str);
            return this;
        }

        public final void n(String str) {
            kotlin.jvm.internal.m.f(str, "<set-?>");
            this.m = str;
        }

        public final a o(boolean z) {
            this.f9993k = z;
            return this;
        }

        public final a p(boolean z) {
            this.f9990h = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        public final a q(t tVar) {
            kotlin.jvm.internal.m.f(tVar, "loginBehavior");
            this.f9991i = tVar;
            return this;
        }

        public final a r(z zVar) {
            kotlin.jvm.internal.m.f(zVar, "targetApp");
            this.f9992j = zVar;
            return this;
        }

        public final a s(boolean z) {
            this.l = z;
            return this;
        }
    }

    /* JADX INFO: compiled from: WebViewLoginMethodHandler.kt */
    public static final class b implements Parcelable.Creator<WebViewLoginMethodHandler> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new WebViewLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public WebViewLoginMethodHandler[] newArray(int i2) {
            return new WebViewLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: WebViewLoginMethodHandler.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: WebViewLoginMethodHandler.kt */
    public static final class d implements r0.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoginClient.Request f9994b;

        d(LoginClient.Request request) {
            this.f9994b = request;
        }

        @Override // com.facebook.internal.r0.e
        public void a(Bundle bundle, FacebookException facebookException) {
            WebViewLoginMethodHandler.this.w(this.f9994b, bundle, facebookException);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.n = "web_view";
        this.o = com.facebook.w.WEB_VIEW;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void b() {
        r0 r0Var = this.l;
        if (r0Var != null) {
            if (r0Var != null) {
                r0Var.cancel();
            }
            this.l = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.n;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean i() {
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        Bundle bundleQ = q(request);
        d dVar = new d(request);
        String strA = LoginClient.f9960f.a();
        this.m = strA;
        a("e2e", strA);
        androidx.fragment.app.d dVarI = d().i();
        if (dVarI == null) {
            return 0;
        }
        p0 p0Var = p0.a;
        boolean zU = p0.U(dVarI);
        a aVar = new a(this, dVarI, request.a(), bundleQ);
        String str = this.m;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        this.l = aVar.m(str).p(zU).k(request.c()).q(request.j()).r(request.k()).o(request.q()).s(request.z()).h(dVar).a();
        com.facebook.internal.w wVar = new com.facebook.internal.w();
        wVar.setRetainInstance(true);
        wVar.k(this.l);
        wVar.show(dVarI.getSupportFragmentManager(), "FacebookDialogFragment");
        return 1;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public com.facebook.w s() {
        return this.o;
    }

    public final void w(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.m.f(request, "request");
        super.u(request, bundle, facebookException);
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.m);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.n = "web_view";
        this.o = com.facebook.w.WEB_VIEW;
        this.m = parcel.readString();
    }
}
