package com.google.gson.t;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: LazilyParsedNumber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends Number {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f20201f;

    public g(String str) {
        this.f20201f = str;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f20201f);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f20201f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f20201f;
        String str2 = ((g) obj).f20201f;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f20201f);
    }

    public int hashCode() {
        return this.f20201f.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f20201f);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f20201f);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f20201f).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f20201f);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f20201f).longValue();
        }
    }

    public String toString() {
        return this.f20201f;
    }
}
