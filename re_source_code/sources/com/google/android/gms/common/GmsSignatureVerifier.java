package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GmsSignatureVerifier {
    private static final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f11629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap f11630c;

    static {
        o oVar = new o();
        oVar.d("com.google.android.gms");
        oVar.a(204200000L);
        i iVar = k.f12080d;
        oVar.c(zzag.v(iVar.E0(), k.f12078b.E0()));
        i iVar2 = k.f12079c;
        oVar.b(zzag.v(iVar2.E0(), k.a.E0()));
        a = oVar.e();
        o oVar2 = new o();
        oVar2.d("com.android.vending");
        oVar2.a(82240000L);
        oVar2.c(zzag.u(iVar.E0()));
        oVar2.b(zzag.u(iVar2.E0()));
        f11629b = oVar2.e();
        f11630c = new HashMap();
    }
}
