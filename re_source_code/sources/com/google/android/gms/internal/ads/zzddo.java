package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzddo {

    @Deprecated
    public static final zzdho a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final zzdho f15882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzdho f15883c;

    static {
        zzdho zzdhoVar = (zzdho) ((zzdob) zzdho.B().v("TINK_MAC_1_0_0").u(zzdbl.a("TinkMac", "Mac", "HmacKey", 0, true)).p0());
        a = zzdhoVar;
        f15882b = (zzdho) ((zzdob) zzdho.B().j(zzdhoVar).v("TINK_MAC_1_1_0").p0());
        f15883c = (zzdho) ((zzdob) zzdho.B().j(zzdhoVar).v("TINK_MAC").p0());
        try {
            a();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void a() throws GeneralSecurityException {
        zzdcf.m("TinkMac", new xr());
        zzdbl.b(f15883c);
    }
}
