package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class zznr {
    private static final zzpu a = new n10();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f16524b = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16525c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16526d = -1;

    private final boolean b(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f16524b.matcher(str2);
        if (matcher.find()) {
            try {
                int i2 = Integer.parseInt(matcher.group(1), 16);
                int i3 = Integer.parseInt(matcher.group(2), 16);
                if (i2 > 0 || i3 > 0) {
                    this.f16525c = i2;
                    this.f16526d = i3;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean a(zzpo zzpoVar) {
        for (int i2 = 0; i2 < zzpoVar.a(); i2++) {
            zzpo.zza zzaVarB = zzpoVar.b(i2);
            if (zzaVarB instanceof zzps) {
                zzps zzpsVar = (zzps) zzaVarB;
                if (b(zzpsVar.f16594h, zzpsVar.f16595i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean c() {
        return (this.f16525c == -1 || this.f16526d == -1) ? false : true;
    }
}
