package com.google.android.gms.internal.measurement;

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
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzfq f17412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzfq f17413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzfq f17414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzfq f17415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzfq f17416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzfq f17417k;
    public static final zzfq l;
    public static final zzfq m;
    public static final zzfq n;
    public static final zzfq o;
    private static final /* synthetic */ zzfq[] p;
    private final Class<?> q;
    private final Class<?> r;
    private final Object s;

    static {
        zzfq zzfqVar = new zzfq("VOID", 0, Void.class, Void.class, null);
        f17412f = zzfqVar;
        Class cls = Integer.TYPE;
        zzfq zzfqVar2 = new zzfq("INT", 1, cls, Integer.class, 0);
        f17413g = zzfqVar2;
        zzfq zzfqVar3 = new zzfq("LONG", 2, Long.TYPE, Long.class, 0L);
        f17414h = zzfqVar3;
        zzfq zzfqVar4 = new zzfq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f17415i = zzfqVar4;
        zzfq zzfqVar5 = new zzfq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f17416j = zzfqVar5;
        zzfq zzfqVar6 = new zzfq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f17417k = zzfqVar6;
        zzfq zzfqVar7 = new zzfq("STRING", 6, String.class, String.class, HttpUrl.FRAGMENT_ENCODE_SET);
        l = zzfqVar7;
        zzfq zzfqVar8 = new zzfq("BYTE_STRING", 7, zzdu.class, zzdu.class, zzdu.f17368f);
        m = zzfqVar8;
        zzfq zzfqVar9 = new zzfq("ENUM", 8, cls, Integer.class, null);
        n = zzfqVar9;
        zzfq zzfqVar10 = new zzfq("MESSAGE", 9, Object.class, Object.class, null);
        o = zzfqVar10;
        p = new zzfq[]{zzfqVar, zzfqVar2, zzfqVar3, zzfqVar4, zzfqVar5, zzfqVar6, zzfqVar7, zzfqVar8, zzfqVar9, zzfqVar10};
    }

    private zzfq(String str, int i2, Class cls, Class cls2, Object obj) {
        super(str, i2);
        this.q = cls;
        this.r = cls2;
        this.s = obj;
    }

    public static zzfq[] values() {
        return (zzfq[]) p.clone();
    }

    public final Class<?> g() {
        return this.r;
    }
}
