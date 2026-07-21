package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class uu {
    private static final Class<?> a = a();

    private static Class<?> a() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno b() {
        if (a != null) {
            try {
                return d("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzdno.f16009c;
    }

    static zzdno c() {
        zzdno zzdnoVarD;
        if (a != null) {
            try {
                zzdnoVarD = d("loadGeneratedRegistry");
            } catch (Exception unused) {
                zzdnoVarD = null;
            }
        } else {
            zzdnoVarD = null;
        }
        if (zzdnoVarD == null) {
            zzdnoVarD = zzdno.b();
        }
        return zzdnoVarD == null ? b() : zzdnoVarD;
    }

    private static final zzdno d(String str) throws Exception {
        return (zzdno) a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
