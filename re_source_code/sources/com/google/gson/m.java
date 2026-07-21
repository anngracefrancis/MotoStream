package com.google.gson;

import java.math.BigInteger;

/* JADX INFO: compiled from: JsonPrimitive.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends j {
    private static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f20152b;

    public m(Boolean bool) {
        D(bool);
    }

    private static boolean A(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean y(m mVar) {
        Object obj = mVar.f20152b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean C() {
        return this.f20152b instanceof String;
    }

    void D(Object obj) {
        if (obj instanceof Character) {
            this.f20152b = String.valueOf(((Character) obj).charValue());
        } else {
            com.google.gson.t.a.a((obj instanceof Number) || A(obj));
            this.f20152b = obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f20152b == null) {
            return mVar.f20152b == null;
        }
        if (y(this) && y(mVar)) {
            return v().longValue() == mVar.v().longValue();
        }
        Object obj2 = this.f20152b;
        if (!(obj2 instanceof Number) || !(mVar.f20152b instanceof Number)) {
            return obj2.equals(mVar.f20152b);
        }
        double dDoubleValue = v().doubleValue();
        double dDoubleValue2 = mVar.v().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f20152b == null) {
            return 31;
        }
        if (y(this)) {
            jDoubleToLongBits = v().longValue();
        } else {
            Object obj = this.f20152b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(v().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean q() {
        return x() ? r().booleanValue() : Boolean.parseBoolean(w());
    }

    Boolean r() {
        return (Boolean) this.f20152b;
    }

    public double s() {
        return z() ? v().doubleValue() : Double.parseDouble(w());
    }

    public int t() {
        return z() ? v().intValue() : Integer.parseInt(w());
    }

    public long u() {
        return z() ? v().longValue() : Long.parseLong(w());
    }

    public Number v() {
        Object obj = this.f20152b;
        return obj instanceof String ? new com.google.gson.t.g((String) this.f20152b) : (Number) obj;
    }

    public String w() {
        if (z()) {
            return v().toString();
        }
        return x() ? r().toString() : (String) this.f20152b;
    }

    public boolean x() {
        return this.f20152b instanceof Boolean;
    }

    public boolean z() {
        return this.f20152b instanceof Number;
    }

    public m(Number number) {
        D(number);
    }

    public m(String str) {
        D(str);
    }
}
