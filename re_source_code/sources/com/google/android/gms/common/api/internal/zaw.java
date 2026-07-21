package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

/* JADX INFO: loaded from: classes2.dex */
public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Api.Client f11879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zaq f11880k;
    private final ClientSettings l;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> m;

    public zaw(Context context, Api<O> api, Looper looper, Api.Client client, zaq zaqVar, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.f11879j = client;
        this.f11880k = zaqVar;
        this.l = clientSettings;
        this.m = abstractClientBuilder;
        this.f11668i.g(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.Client i(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        this.f11880k.a(zaaVar);
        return this.f11879j;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zace k(Context context, Handler handler) {
        return new zace(context, handler, this.l, this.m);
    }

    public final Api.Client m() {
        return this.f11879j;
    }
}
