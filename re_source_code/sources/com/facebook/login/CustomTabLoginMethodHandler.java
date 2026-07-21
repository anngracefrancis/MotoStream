package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.f0;
import com.facebook.internal.p0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomTabLoginMethodHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static boolean l;
    private String m;
    private String n;
    private String o;
    private final String p;
    private final com.facebook.w q;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f9932k = new b(null);
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new a();

    /* JADX INFO: compiled from: CustomTabLoginMethodHandler.kt */
    public static final class a implements Parcelable.Creator<CustomTabLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler[] newArray(int i2) {
            return new CustomTabLoginMethodHandler[i2];
        }
    }

    /* JADX INFO: compiled from: CustomTabLoginMethodHandler.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.p = "custom_tab";
        this.q = com.facebook.w.CHROME_CUSTOM_TAB;
        p0 p0Var = p0.a;
        this.n = p0.q(20);
        l = false;
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        this.o = com.facebook.internal.v.c(x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(customTabLoginMethodHandler, "this$0");
        kotlin.jvm.internal.m.f(request, "$request");
        kotlin.jvm.internal.m.f(bundle, "$values");
        try {
            customTabLoginMethodHandler.u(request, customTabLoginMethodHandler.k(request, bundle), null);
        } catch (FacebookException e2) {
            customTabLoginMethodHandler.u(request, null, e2);
        }
    }

    private final boolean C(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return kotlin.jvm.internal.m.a(new JSONObject(string).getString("7_challenge"), this.n);
        } catch (JSONException unused) {
            return false;
        }
    }

    private final String w() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        String strA = com.facebook.internal.v.a();
        this.m = strA;
        return strA;
    }

    private final String x() {
        return super.g();
    }

    private final void z(String str, final LoginClient.Request request) {
        int i2;
        if (str != null) {
            if (kotlin.text.u.E(str, "fbconnect://cct.", false, 2, null) || kotlin.text.u.E(str, super.g(), false, 2, null)) {
                Uri uri = Uri.parse(str);
                p0 p0Var = p0.a;
                final Bundle bundleO0 = p0.o0(uri.getQuery());
                bundleO0.putAll(p0.o0(uri.getFragment()));
                if (!C(bundleO0)) {
                    super.u(request, null, new FacebookException("Invalid state parameter"));
                    return;
                }
                String string = bundleO0.getString("error");
                if (string == null) {
                    string = bundleO0.getString("error_type");
                }
                String string2 = bundleO0.getString("error_msg");
                if (string2 == null) {
                    string2 = bundleO0.getString("error_message");
                }
                if (string2 == null) {
                    string2 = bundleO0.getString("error_description");
                }
                String string3 = bundleO0.getString("error_code");
                if (string3 == null) {
                    i2 = -1;
                } else {
                    try {
                        i2 = Integer.parseInt(string3);
                    } catch (NumberFormatException unused) {
                        i2 = -1;
                    }
                }
                p0 p0Var2 = p0.a;
                if (p0.a0(string) && p0.a0(string2) && i2 == -1) {
                    if (bundleO0.containsKey("access_token")) {
                        super.u(request, bundleO0, null);
                        return;
                    } else {
                        com.facebook.a0 a0Var = com.facebook.a0.a;
                        com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.login.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                CustomTabLoginMethodHandler.B(this.f9995f, request, bundleO0);
                            }
                        });
                        return;
                    }
                }
                if (string != null && (kotlin.jvm.internal.m.a(string, "access_denied") || kotlin.jvm.internal.m.a(string, "OAuthAccessDeniedException"))) {
                    super.u(request, null, new FacebookOperationCanceledException());
                } else if (i2 == 4201) {
                    super.u(request, null, new FacebookOperationCanceledException());
                } else {
                    super.u(request, null, new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.p;
    }

    @Override // com.facebook.login.LoginMethodHandler
    protected String g() {
        return this.o;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean j(int i2, int i3, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.m, false)) {
            return super.j(i2, i3, intent);
        }
        if (i2 != 1) {
            return super.j(i2, i3, intent);
        }
        LoginClient.Request requestO = d().o();
        if (requestO == null) {
            return false;
        }
        if (i3 == -1) {
            z(intent != null ? intent.getStringExtra(CustomTabMainActivity.f9593j) : null, requestO);
            return true;
        }
        super.u(requestO, null, new FacebookOperationCanceledException());
        return false;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void l(JSONObject jSONObject) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "param");
        jSONObject.put("7_challenge", this.n);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        LoginClient loginClientD = d();
        if (g().length() == 0) {
            return 0;
        }
        Bundle bundleP = p(q(request), request);
        if (l) {
            bundleP.putString("cct_over_app_switch", "1");
        }
        if (com.facebook.a0.q) {
            if (request.r()) {
                q.f10020f.c(f0.f9773c.a("oauth", bundleP));
            } else {
                q.f10020f.c(com.facebook.internal.u.a.a("oauth", bundleP));
            }
        }
        androidx.fragment.app.d dVarI = loginClientD.i();
        if (dVarI == null) {
            return 0;
        }
        Intent intent = new Intent(dVarI, (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.f9590g, "oauth");
        intent.putExtra(CustomTabMainActivity.f9591h, bundleP);
        intent.putExtra(CustomTabMainActivity.f9592i, w());
        intent.putExtra(CustomTabMainActivity.f9594k, request.k().toString());
        Fragment fragmentK = loginClientD.k();
        if (fragmentK != null) {
            fragmentK.startActivityForResult(intent, 1);
        }
        return 1;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String r() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public com.facebook.w s() {
        return this.q;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.n);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.p = "custom_tab";
        this.q = com.facebook.w.CHROME_CUSTOM_TAB;
        this.n = parcel.readString();
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        this.o = com.facebook.internal.v.c(x());
    }
}
