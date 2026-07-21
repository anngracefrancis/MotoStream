package com.facebook.internal;

import java.util.Arrays;
import java.util.EnumSet;

/* JADX INFO: compiled from: SmartLoginOption.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum o0 {
    None(0),
    Enabled(1),
    RequireConfirm(2);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9810f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final EnumSet<o0> f9811g;
    private final long l;

    /* JADX INFO: compiled from: SmartLoginOption.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final EnumSet<o0> a(long j2) {
            EnumSet<o0> enumSetNoneOf = EnumSet.noneOf(o0.class);
            for (o0 o0Var : o0.f9811g) {
                if ((o0Var.q() & j2) != 0) {
                    enumSetNoneOf.add(o0Var);
                }
            }
            kotlin.jvm.internal.m.e(enumSetNoneOf, "result");
            return enumSetNoneOf;
        }
    }

    static {
        EnumSet<o0> enumSetAllOf = EnumSet.allOf(o0.class);
        kotlin.jvm.internal.m.e(enumSetAllOf, "allOf(SmartLoginOption::class.java)");
        f9811g = enumSetAllOf;
    }

    o0(long j2) {
        this.l = j2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static o0[] valuesCustom() {
        o0[] o0VarArrValuesCustom = values();
        return (o0[]) Arrays.copyOf(o0VarArrValuesCustom, o0VarArrValuesCustom.length);
    }

    public final long q() {
        return this.l;
    }
}
