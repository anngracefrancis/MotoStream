package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdom {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzdom f16037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzdom f16038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzdom f16039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzdom f16040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzdom f16041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzdom f16042k;
    public static final zzdom l;
    public static final zzdom m;
    public static final zzdom n;
    public static final zzdom o;
    private static final /* synthetic */ zzdom[] p;
    private final Class<?> q;
    private final Class<?> r;
    private final Object s;

    static {
        zzdom zzdomVar = new zzdom("VOID", 0, Void.class, Void.class, null);
        f16037f = zzdomVar;
        Class cls = Integer.TYPE;
        zzdom zzdomVar2 = new zzdom("INT", 1, cls, Integer.class, 0);
        f16038g = zzdomVar2;
        zzdom zzdomVar3 = new zzdom("LONG", 2, Long.TYPE, Long.class, 0L);
        f16039h = zzdomVar3;
        zzdom zzdomVar4 = new zzdom("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f16040i = zzdomVar4;
        zzdom zzdomVar5 = new zzdom("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f16041j = zzdomVar5;
        zzdom zzdomVar6 = new zzdom("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f16042k = zzdomVar6;
        zzdom zzdomVar7 = new zzdom("STRING", 6, String.class, String.class, HttpUrl.FRAGMENT_ENCODE_SET);
        l = zzdomVar7;
        zzdom zzdomVar8 = new zzdom("BYTE_STRING", 7, zzdmr.class, zzdmr.class, zzdmr.f15982f);
        m = zzdomVar8;
        zzdom zzdomVar9 = new zzdom("ENUM", 8, cls, Integer.class, null);
        n = zzdomVar9;
        zzdom zzdomVar10 = new zzdom("MESSAGE", 9, Object.class, Object.class, null);
        o = zzdomVar10;
        p = new zzdom[]{zzdomVar, zzdomVar2, zzdomVar3, zzdomVar4, zzdomVar5, zzdomVar6, zzdomVar7, zzdomVar8, zzdomVar9, zzdomVar10};
    }

    private zzdom(String str, int i2, Class cls, Class cls2, Object obj) {
        super(str, i2);
        this.q = cls;
        this.r = cls2;
        this.s = obj;
    }

    public static zzdom[] values() {
        return (zzdom[]) p.clone();
    }

    public final Class<?> g() {
        return this.r;
    }
}
