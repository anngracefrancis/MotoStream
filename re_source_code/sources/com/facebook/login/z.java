package com.facebook.login;

import java.util.Arrays;

/* JADX INFO: compiled from: LoginTargetApp.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum z {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram");


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10065f = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f10069j;

    /* JADX INFO: compiled from: LoginTargetApp.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final z a(String str) {
            z[] zVarArrValuesCustom = z.valuesCustom();
            int length = zVarArrValuesCustom.length;
            int i2 = 0;
            while (i2 < length) {
                z zVar = zVarArrValuesCustom[i2];
                i2++;
                if (kotlin.jvm.internal.m.a(zVar.toString(), str)) {
                    return zVar;
                }
            }
            return z.FACEBOOK;
        }
    }

    z(String str) {
        this.f10069j = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static z[] valuesCustom() {
        z[] zVarArrValuesCustom = values();
        return (z[]) Arrays.copyOf(zVarArrValuesCustom, zVarArrValuesCustom.length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f10069j;
    }
}
