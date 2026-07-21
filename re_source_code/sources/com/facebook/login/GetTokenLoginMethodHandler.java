package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.facebook.FacebookException;
import com.facebook.internal.l0;
import com.facebook.internal.p0;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.w0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GetTokenLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private s f9952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9953k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f9951i = new b(null);
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new a();

    /* JADX INFO: compiled from: GetTokenLoginMethodHandler.kt */
    public static final class a implements Parcelable.Creator<GetTokenLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetTokenLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new GetTokenLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetTokenLoginMethodHandler[] newArray(int i2) {
            return new GetTokenLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: GetTokenLoginMethodHandler.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: GetTokenLoginMethodHandler.kt */
    public static final class c implements p0.a {
        final /* synthetic */ Bundle a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GetTokenLoginMethodHandler f9954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LoginClient.Request f9955c;

        c(Bundle bundle, GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request) {
            this.a = bundle;
            this.f9954b = getTokenLoginMethodHandler;
            this.f9955c = request;
        }

        @Override // com.facebook.internal.p0.a
        public void a(JSONObject jSONObject) {
            try {
                this.a.putString("com.facebook.platform.extra.USER_ID", jSONObject == null ? null : jSONObject.getString(DeepLinkIntentReceiver.DeepLinksKeys.ID));
                this.f9954b.s(this.f9955c, this.a);
            } catch (JSONException e2) {
                this.f9954b.d().f(LoginClient.Result.c.d(LoginClient.Result.f9972f, this.f9954b.d().o(), "Caught exception", e2.getMessage(), null, 8, null));
            }
        }

        @Override // com.facebook.internal.p0.a
        public void b(FacebookException facebookException) {
            this.f9954b.d().f(LoginClient.Result.c.d(LoginClient.Result.f9972f, this.f9954b.d().o(), "Caught exception", facebookException == null ? null : facebookException.getMessage(), null, 8, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9953k = "get_token";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GetTokenLoginMethodHandler getTokenLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(getTokenLoginMethodHandler, "this$0");
        kotlin.jvm.internal.m.f(request, "$request");
        getTokenLoginMethodHandler.q(request, bundle);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void b() {
        s sVar = this.f9952j;
        if (sVar == null) {
            return;
        }
        sVar.b();
        sVar.g(null);
        this.f9952j = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.f9953k;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(final LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        Context contextI = d().i();
        if (contextI == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            contextI = com.facebook.a0.c();
        }
        s sVar = new s(contextI, request);
        this.f9952j = sVar;
        if (kotlin.jvm.internal.m.a(sVar == null ? null : Boolean.valueOf(sVar.h()), Boolean.FALSE)) {
            return 0;
        }
        d().r();
        l0.b bVar = new l0.b() { // from class: com.facebook.login.i
            @Override // com.facebook.internal.l0.b
            public final void a(Bundle bundle) {
                GetTokenLoginMethodHandler.t(this.a, request, bundle);
            }
        };
        s sVar2 = this.f9952j;
        if (sVar2 == null) {
            return 1;
        }
        sVar2.g(bVar);
        return 1;
    }

    public final void p(LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(bundle, "result");
        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
        if (!(string == null || string.length() == 0)) {
            s(request, bundle);
            return;
        }
        d().r();
        String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        p0 p0Var = p0.a;
        p0.E(string2, new c(bundle, this, request));
    }

    public final void q(LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(request, "request");
        s sVar = this.f9952j;
        if (sVar != null) {
            sVar.g(null);
        }
        this.f9952j = null;
        d().s();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            if (stringArrayList == null) {
                stringArrayList = kotlin.collections.u.j();
            }
            Set<String> setN = request.n();
            if (setN == null) {
                setN = w0.d();
            }
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (setN.contains("openid")) {
                if (string == null || string.length() == 0) {
                    d().B();
                    return;
                }
            }
            if (stringArrayList.containsAll(setN)) {
                p(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : setN) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                a("new_permissions", TextUtils.join(",", hashSet));
            }
            request.v(hashSet);
        }
        d().B();
    }

    public final void s(LoginClient.Request request, Bundle bundle) {
        LoginClient.Result resultD;
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(bundle, "result");
        try {
            LoginMethodHandler.a aVar = LoginMethodHandler.f9983f;
            resultD = LoginClient.Result.f9972f.b(request, aVar.a(bundle, com.facebook.w.FACEBOOK_APPLICATION_SERVICE, request.a()), aVar.c(bundle, request.m()));
        } catch (FacebookException e2) {
            resultD = LoginClient.Result.c.d(LoginClient.Result.f9972f, d().o(), null, e2.getMessage(), null, 8, null);
        }
        d().g(resultD);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9953k = "get_token";
    }
}
