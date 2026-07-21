package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public abstract class zzbft implements Releasable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Context f14430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f14431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected WeakReference<zzbdf> f14432h;

    public zzbft(zzbdf zzbdfVar) {
        this.f14430f = zzbdfVar.getContext();
        this.f14431g = zzk.zzlg().g0(this.f14430f, zzbdfVar.b().f14326f);
        this.f14432h = new WeakReference<>(zzbdfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String A(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    b2 = 0;
                }
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    b2 = 1;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    b2 = 2;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    b2 = 3;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    b2 = 4;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    b2 = 5;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    b2 = 6;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    b2 = 7;
                }
                break;
            case 3387234:
                if (str.equals("noop")) {
                    b2 = 8;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    b2 = 9;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    b2 = 10;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    b2 = 11;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 2:
            case 4:
            case 5:
            case 8:
            case 9:
            default:
                return "internal";
            case 1:
            case 3:
                return "network";
            case 6:
            case 7:
                return "policy";
            case 10:
            case 11:
                return "io";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String str, Map<String, String> map) {
        zzbdf zzbdfVar = this.f14432h.get();
        if (zzbdfVar != null) {
            zzbdfVar.y(str, map);
        }
    }

    public abstract void b();

    @Override // com.google.android.gms.common.api.Releasable
    public void c() {
    }

    protected final void j(String str, String str2, int i2) {
        zzazt.a.post(new ea(this, str, str2, i2));
    }

    @VisibleForTesting
    public final void k(String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        zzazt.a.post(new da(this, str, str2, i2, i3, j2, j3, z, i4, i5));
    }

    @VisibleForTesting
    public final void l(String str, String str2, int i2, int i3, boolean z, int i4, int i5) {
        zzazt.a.post(new aa(this, str, str2, i2, 0, z, i4, i5));
    }

    @VisibleForTesting
    public final void m(String str, String str2, long j2, long j3, boolean z) {
        zzazt.a.post(new ba(this, str, str2, j2, j3, z));
    }

    @VisibleForTesting
    public final void p(String str, String str2, long j2, long j3, boolean z, int i2, int i3) {
        zzazt.a.post(new ca(this, str, str2, j2, j3, z, i2, i3));
    }

    @VisibleForTesting
    public final void q(String str, String str2, String str3, String str4) {
        zzazt.a.post(new ga(this, str, str2, str3, str4));
    }

    @VisibleForTesting
    public final void s(String str, String str2, long j2) {
        zzazt.a.post(new fa(this, str, str2, j2));
    }

    protected void t(int i2) {
    }

    protected void u(int i2) {
    }

    protected void v(int i2) {
    }

    protected void w(int i2) {
    }

    public boolean x(String str, String[] strArr) {
        return y(str);
    }

    public abstract boolean y(String str);

    protected String z(String str) {
        zzyt.a();
        return zzazt.t(str);
    }
}
