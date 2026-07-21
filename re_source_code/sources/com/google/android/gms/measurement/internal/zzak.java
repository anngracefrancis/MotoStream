package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzak {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f18061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f18063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f18064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final zzam f18065f;

    private zzak(zzfx zzfxVar, String str, String str2, String str3, long j2, long j3, zzam zzamVar) {
        Preconditions.g(str2);
        Preconditions.g(str3);
        Preconditions.k(zzamVar);
        this.a = str2;
        this.f18061b = str3;
        this.f18062c = TextUtils.isEmpty(str) ? null : str;
        this.f18063d = j2;
        this.f18064e = j3;
        if (j3 != 0 && j3 > j2) {
            zzfxVar.h().K().c("Event created with reverse previous/current timestamps. appId, name", zzet.x(str2), zzet.x(str3));
        }
        this.f18065f = zzamVar;
    }

    final zzak a(zzfx zzfxVar, long j2) {
        return new zzak(zzfxVar, this.f18062c, this.a, this.f18061b, this.f18063d, j2, this.f18065f);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.f18061b;
        String strValueOf = String.valueOf(this.f18065f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + strValueOf.length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(strValueOf);
        sb.append('}');
        return sb.toString();
    }

    zzak(zzfx zzfxVar, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        zzam zzamVar;
        Preconditions.g(str2);
        Preconditions.g(str3);
        this.a = str2;
        this.f18061b = str3;
        this.f18062c = TextUtils.isEmpty(str) ? null : str;
        this.f18063d = j2;
        this.f18064e = j3;
        if (j3 != 0 && j3 > j2) {
            zzfxVar.h().K().b("Event created with reverse previous/current timestamps. appId", zzet.x(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzfxVar.h().H().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objE = zzfxVar.I().E(next, bundle2.get(next));
                    if (objE == null) {
                        zzfxVar.h().K().b("Param value can't be null", zzfxVar.J().A(next));
                        it.remove();
                    } else {
                        zzfxVar.I().L(bundle2, next, objE);
                    }
                }
            }
            zzamVar = new zzam(bundle2);
        } else {
            zzamVar = new zzam(new Bundle());
        }
        this.f18065f = zzamVar;
    }
}
