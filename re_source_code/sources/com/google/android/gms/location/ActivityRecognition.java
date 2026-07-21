package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zze;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityRecognition {
    private static final Api.ClientKey<zzaz> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzaz, Api.ApiOptions.NoOptions> f17594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f17595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final ActivityRecognitionApi f17596d;

    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzaz> {
    }

    static {
        Api.ClientKey<zzaz> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        f17594b = aVar;
        f17595c = new Api<>("ActivityRecognition.API", aVar, clientKey);
        f17596d = new zze();
    }

    private ActivityRecognition() {
    }
}
