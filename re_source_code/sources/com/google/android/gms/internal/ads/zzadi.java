package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzadi {

    @VisibleForTesting
    boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<zzadg> f13824b = new LinkedList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f13825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f13826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzadi f13827e;

    public zzadi(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f13825c = linkedHashMap;
        this.f13826d = new Object();
        this.a = true;
        linkedHashMap.put("action", str);
        linkedHashMap.put("ad_format", str2);
    }

    public final boolean a(zzadg zzadgVar, long j2, String... strArr) {
        synchronized (this.f13826d) {
            for (String str : strArr) {
                this.f13824b.add(new zzadg(j2, str, zzadgVar));
            }
        }
        return true;
    }

    public final void b(zzadi zzadiVar) {
        synchronized (this.f13826d) {
            this.f13827e = zzadiVar;
        }
    }

    public final zzadg c(long j2) {
        if (this.a) {
            return new zzadg(j2, null, null);
        }
        return null;
    }

    public final void d(String str, String str2) {
        zzacy zzacyVarL;
        if (!this.a || TextUtils.isEmpty(str2) || (zzacyVarL = zzk.zzlk().l()) == null) {
            return;
        }
        synchronized (this.f13826d) {
            zzadc zzadcVarE = zzacyVarL.e(str);
            Map<String, String> map = this.f13825c;
            map.put(str, zzadcVarE.a(map.get(str), str2));
        }
    }

    public final String e() {
        String string;
        StringBuilder sb = new StringBuilder();
        synchronized (this.f13826d) {
            for (zzadg zzadgVar : this.f13824b) {
                long jA = zzadgVar.a();
                String strB = zzadgVar.b();
                zzadg zzadgVarC = zzadgVar.c();
                if (zzadgVarC != null && jA > 0) {
                    long jA2 = jA - zzadgVarC.a();
                    sb.append(strB);
                    sb.append('.');
                    sb.append(jA2);
                    sb.append(',');
                }
            }
            this.f13824b.clear();
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        }
        return string;
    }

    @VisibleForTesting
    final Map<String, String> f() {
        zzadi zzadiVar;
        synchronized (this.f13826d) {
            zzacy zzacyVarL = zzk.zzlk().l();
            if (zzacyVarL != null && (zzadiVar = this.f13827e) != null) {
                return zzacyVarL.a(this.f13825c, zzadiVar.f());
            }
            return this.f13825c;
        }
    }
}
