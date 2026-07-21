package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmu {
    private final Clock a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f15414b = Collections.synchronizedList(new ArrayList());

    public zzcmu(Clock clock) {
        this.a = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str, int i2, long j2) {
        List<String> list = this.f15414b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(j2);
        list.add(sb.toString());
    }

    public final <T> zzbbh<T> b(zzcxm zzcxmVar, zzbbh<T> zzbbhVar) {
        long jB = this.a.b();
        String str = zzcxmVar.t;
        if (str != null) {
            zzbar.f(zzbbhVar, new nl(this, str, jB), zzbbm.f14331b);
        }
        return zzbbhVar;
    }

    public final String e() {
        return TextUtils.join("_", this.f15414b);
    }
}
