package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzha;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class AppMeasurementSdk {
    private final zzx a;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    @KeepForSdk
    public static final class ConditionalUserProperty {
        private ConditionalUserProperty() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzgx {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzha {
    }

    public AppMeasurementSdk(zzx zzxVar) {
        this.a = zzxVar;
    }

    @KeepForSdk
    public static AppMeasurementSdk k(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzx.e(context, str, str2, str3, bundle).f();
    }

    @KeepForSdk
    public void a(String str) {
        this.a.B(str);
    }

    @KeepForSdk
    public void b(String str, String str2, Bundle bundle) {
        this.a.C(str, str2, bundle);
    }

    @KeepForSdk
    public void c(String str) {
        this.a.I(str);
    }

    @KeepForSdk
    public long d() {
        return this.a.P();
    }

    @KeepForSdk
    public String e() {
        return this.a.V();
    }

    @KeepForSdk
    public String f() {
        return this.a.M();
    }

    @KeepForSdk
    public List<Bundle> g(String str, String str2) {
        return this.a.A(str, str2);
    }

    @KeepForSdk
    public String h() {
        return this.a.T();
    }

    @KeepForSdk
    public String i() {
        return this.a.Q();
    }

    @KeepForSdk
    public String j() {
        return this.a.G();
    }

    @KeepForSdk
    public int l(String str) {
        return this.a.L(str);
    }

    @KeepForSdk
    public Map<String, Object> m(String str, String str2, boolean z) {
        return this.a.h(str, str2, z);
    }

    @KeepForSdk
    public void n(String str, String str2, Bundle bundle) {
        this.a.s(str, str2, bundle);
    }

    @KeepForSdk
    public void o(Bundle bundle) {
        this.a.a(bundle, false);
    }

    @KeepForSdk
    public Bundle p(Bundle bundle) {
        return this.a.a(bundle, true);
    }

    @KeepForSdk
    public void q(Bundle bundle) {
        this.a.k(bundle);
    }

    @KeepForSdk
    public void r(Activity activity, String str, String str2) {
        this.a.j(activity, str, str2);
    }

    @KeepForSdk
    public void s(String str, String str2, Object obj) {
        this.a.u(str, str2, obj);
    }
}
