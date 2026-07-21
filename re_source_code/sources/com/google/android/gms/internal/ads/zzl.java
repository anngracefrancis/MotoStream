package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class zzl {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16415b;

    public zzl(String str, String str2) {
        this.a = str;
        this.f16415b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f16415b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzl.class == obj.getClass()) {
            zzl zzlVar = (zzl) obj;
            if (TextUtils.equals(this.a, zzlVar.a) && TextUtils.equals(this.f16415b, zzlVar.f16415b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.f16415b.hashCode();
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.f16415b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length());
        sb.append("Header[name=");
        sb.append(str);
        sb.append(",value=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}
