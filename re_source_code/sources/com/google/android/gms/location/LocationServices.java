package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbk;

/* JADX INFO: loaded from: classes2.dex */
public class LocationServices {
    private static final Api.ClientKey<zzaz> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzaz, Api.ApiOptions.NoOptions> f17642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f17643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final FusedLocationProviderApi f17644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final GeofencingApi f17645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final SettingsApi f17646f;

    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzaz> {
    }

    static {
        Api.ClientKey<zzaz> clientKey = new Api.ClientKey<>();
        a = clientKey;
        b bVar = new b();
        f17642b = bVar;
        f17643c = new Api<>("LocationServices.API", bVar, clientKey);
        f17644d = new com.google.android.gms.internal.location.zzq();
        f17645e = new com.google.android.gms.internal.location.zzaf();
        f17646f = new zzbk();
    }

    private LocationServices() {
    }
}
