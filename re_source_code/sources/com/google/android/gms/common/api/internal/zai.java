package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zai<O extends Api.ApiOptions> {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Api<O> f11861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final O f11862d;

    private zai(Api<O> api, O o) {
        this.a = false;
        this.f11861c = api;
        this.f11862d = o;
        this.f11860b = Objects.b(api, o);
    }

    public static <O extends Api.ApiOptions> zai<O> a(Api<O> api) {
        return new zai<>(api);
    }

    public static <O extends Api.ApiOptions> zai<O> b(Api<O> api, O o) {
        return new zai<>(api, o);
    }

    public final String c() {
        return this.f11861c.b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zai)) {
            return false;
        }
        zai zaiVar = (zai) obj;
        return !this.a && !zaiVar.a && Objects.a(this.f11861c, zaiVar.f11861c) && Objects.a(this.f11862d, zaiVar.f11862d);
    }

    public final int hashCode() {
        return this.f11860b;
    }

    private zai(Api<O> api) {
        this.a = true;
        this.f11861c = api;
        this.f11862d = null;
        this.f11860b = System.identityHashCode(this);
    }
}
