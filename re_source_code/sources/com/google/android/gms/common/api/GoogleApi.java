package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class GoogleApi<O extends Api.ApiOptions> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Api<O> f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final O f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zai<O> f11663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Looper f11664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GoogleApiClient f11666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final StatusExceptionMapper f11667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final GoogleApiManager f11668i;

    @KeepForSdk
    public static class Settings {

        @KeepForSdk
        public static final Settings a = new Builder().a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StatusExceptionMapper f11669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Looper f11670c;

        @KeepForSdk
        public static class Builder {
            private StatusExceptionMapper a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Looper f11671b;

            @KeepForSdk
            public Builder() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @KeepForSdk
            public Settings a() {
                if (this.a == null) {
                    this.a = new ApiExceptionMapper();
                }
                if (this.f11671b == null) {
                    this.f11671b = Looper.getMainLooper();
                }
                return new Settings(this.a, this.f11671b);
            }

            @KeepForSdk
            public Builder b(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.l(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.a = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f11669b = statusExceptionMapper;
            this.f11670c = looper;
        }
    }

    @KeepForSdk
    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        Preconditions.l(context, "Null context is not permitted.");
        Preconditions.l(api, "Api must not be null.");
        Preconditions.l(looper, "Looper must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f11661b = api;
        this.f11662c = null;
        this.f11664e = looper;
        this.f11663d = zai.a(api);
        this.f11666g = new zabp(this);
        GoogleApiManager googleApiManagerK = GoogleApiManager.k(applicationContext);
        this.f11668i = googleApiManagerK;
        this.f11665f = googleApiManagerK.o();
        this.f11667h = new ApiExceptionMapper();
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T j(int i2, T t) {
        t.r();
        this.f11668i.h(this, i2, t);
        return t;
    }

    @KeepForSdk
    public GoogleApiClient a() {
        return this.f11666g;
    }

    @KeepForSdk
    protected ClientSettings.Builder b() {
        Account account;
        GoogleSignInAccount googleSignInAccountX;
        GoogleSignInAccount googleSignInAccountX2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.f11662c;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountX2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).x()) == null) {
            O o2 = this.f11662c;
            account = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).getAccount() : null;
        } else {
            account = googleSignInAccountX2.getAccount();
        }
        ClientSettings.Builder builderC = builder.c(account);
        O o3 = this.f11662c;
        return builderC.a((!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountX = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).x()) == null) ? Collections.emptySet() : googleSignInAccountX.J0()).d(this.a.getClass().getName()).e(this.a.getPackageName());
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T c(T t) {
        return (T) j(0, t);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T d(T t) {
        return (T) j(1, t);
    }

    public final Api<O> e() {
        return this.f11661b;
    }

    @KeepForSdk
    public Context f() {
        return this.a;
    }

    public final int g() {
        return this.f11665f;
    }

    @KeepForSdk
    public Looper h() {
        return this.f11664e;
    }

    public Api.Client i(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        return this.f11661b.d().c(this.a, looper, b().b(), this.f11662c, zaaVar, zaaVar);
    }

    public zace k(Context context, Handler handler) {
        return new zace(context, handler, b().b());
    }

    public final zai<O> l() {
        return this.f11663d;
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        Preconditions.l(context, "Null context is not permitted.");
        Preconditions.l(api, "Api must not be null.");
        Preconditions.l(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f11661b = api;
        this.f11662c = o;
        this.f11664e = settings.f11670c;
        this.f11663d = zai.b(api, o);
        this.f11666g = new zabp(this);
        GoogleApiManager googleApiManagerK = GoogleApiManager.k(applicationContext);
        this.f11668i = googleApiManagerK;
        this.f11665f = googleApiManagerK.o();
        this.f11667h = settings.f11669b;
        googleApiManagerK.g(this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().b(statusExceptionMapper).a());
    }
}
