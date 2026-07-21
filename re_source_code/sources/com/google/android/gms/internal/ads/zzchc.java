package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchc implements zzdti<zzbbh<String>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15236b;

    private zzchc(zzdtu<zzczt> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15236b = zzdtuVar2;
    }

    public static zzchc a(zzdtu<zzczt> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        return new zzchc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzczt zzcztVar = this.a.get();
        final Context context = this.f15236b.get();
        return (zzbbh) zzdto.b(zzcztVar.g(zzczs.WEBVIEW_COOKIE).d(new Callable(context) { // from class: com.google.android.gms.internal.ads.wi

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Context f13511f;

            {
                this.f13511f = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManagerN = zzk.zzli().n(this.f13511f);
                return cookieManagerN != null ? cookieManagerN.getCookie("googleads.g.doubleclick.net") : HttpUrl.FRAGMENT_ENCODE_SET;
            }
        }).a(1L, TimeUnit.SECONDS).e(Exception.class, xi.a).f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
