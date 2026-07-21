package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class zzcqt {
    private String a;

    public static class zza {
        private String a;

        public final zza b(String str) {
            this.a = str;
            return this;
        }
    }

    private zzcqt(zza zzaVar) {
        this.a = zzaVar.a;
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String b() {
        return this.a.toLowerCase(Locale.ROOT);
    }

    public final int c() {
        String str = this.a;
        str.hashCode();
        switch (str) {
            case "NATIVE":
                return 6;
            case "INTERSTITIAL":
                return 3;
            case "REWARDED":
                return 7;
            case "BANNER":
                return 1;
            default:
                return 0;
        }
    }
}
