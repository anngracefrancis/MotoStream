package com.facebook.o0.r0;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.s;

/* JADX INFO: compiled from: Model.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f10447b = q0.k(s.a("embedding.weight", "embed.weight"), s.a("dense1.weight", "fc1.weight"), s.a("dense2.weight", "fc2.weight"), s.a("dense3.weight", "fc3.weight"), s.a("dense1.bias", "fc1.bias"), s.a("dense2.bias", "fc2.bias"), s.a("dense3.bias", "fc3.bias"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f10448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f10449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f10450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f10451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f10452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f10453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final f f10454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f f10455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f10456k;
    private final f l;
    private final f m;
    private final Map<String, f> n;

    /* JADX INFO: compiled from: Model.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final Map<String, f> b(File file) {
            j jVar = j.a;
            Map<String, f> mapC = j.c(file);
            if (mapC == null) {
                return null;
            }
            HashMap map = new HashMap();
            Map map2 = g.f10447b;
            for (Map.Entry<String, f> entry : mapC.entrySet()) {
                String key = entry.getKey();
                if (map2.containsKey(entry.getKey()) && (key = (String) map2.get(entry.getKey())) == null) {
                    return null;
                }
                map.put(key, entry.getValue());
            }
            return map;
        }

        public final g a(File file) {
            m.f(file, "file");
            Map<String, f> mapB = b(file);
            kotlin.jvm.internal.g gVar = null;
            if (mapB == null) {
                return null;
            }
            try {
                return new g(mapB, gVar);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private g(Map<String, f> map) {
        f fVar = map.get("embed.weight");
        if (fVar == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10448c = fVar;
        i iVar = i.a;
        f fVar2 = map.get("convs.0.weight");
        if (fVar2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10449d = i.l(fVar2);
        f fVar3 = map.get("convs.1.weight");
        if (fVar3 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10450e = i.l(fVar3);
        f fVar4 = map.get("convs.2.weight");
        if (fVar4 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10451f = i.l(fVar4);
        f fVar5 = map.get("convs.0.bias");
        if (fVar5 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10452g = fVar5;
        f fVar6 = map.get("convs.1.bias");
        if (fVar6 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10453h = fVar6;
        f fVar7 = map.get("convs.2.bias");
        if (fVar7 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10454i = fVar7;
        f fVar8 = map.get("fc1.weight");
        if (fVar8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10455j = i.k(fVar8);
        f fVar9 = map.get("fc2.weight");
        if (fVar9 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.f10456k = i.k(fVar9);
        f fVar10 = map.get("fc1.bias");
        if (fVar10 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.l = fVar10;
        f fVar11 = map.get("fc2.bias");
        if (fVar11 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        this.m = fVar11;
        this.n = new HashMap();
        for (String str : w0.i(h.a.MTML_INTEGRITY_DETECT.k(), h.a.MTML_APP_EVENT_PREDICTION.k())) {
            String strN = m.n(str, ".weight");
            String strN2 = m.n(str, ".bias");
            f fVar12 = map.get(strN);
            f fVar13 = map.get(strN2);
            if (fVar12 != null) {
                i iVar2 = i.a;
                this.n.put(strN, i.k(fVar12));
            }
            if (fVar13 != null) {
                this.n.put(strN2, fVar13);
            }
        }
    }

    public /* synthetic */ g(Map map, kotlin.jvm.internal.g gVar) {
        this(map);
    }

    public final f b(f fVar, String[] strArr, String str) {
        m.f(fVar, "dense");
        m.f(strArr, "texts");
        m.f(str, "task");
        i iVar = i.a;
        f fVarC = i.c(i.e(strArr, 128, this.f10448c), this.f10449d);
        i.a(fVarC, this.f10452g);
        i.i(fVarC);
        f fVarC2 = i.c(fVarC, this.f10450e);
        i.a(fVarC2, this.f10453h);
        i.i(fVarC2);
        f fVarG = i.g(fVarC2, 2);
        f fVarC3 = i.c(fVarG, this.f10451f);
        i.a(fVarC3, this.f10454i);
        i.i(fVarC3);
        f fVarG2 = i.g(fVarC, fVarC.b(1));
        f fVarG3 = i.g(fVarG, fVarG.b(1));
        f fVarG4 = i.g(fVarC3, fVarC3.b(1));
        i.f(fVarG2, 1);
        i.f(fVarG3, 1);
        i.f(fVarG4, 1);
        f fVarD = i.d(i.b(new f[]{fVarG2, fVarG3, fVarG4, fVar}), this.f10455j, this.l);
        i.i(fVarD);
        f fVarD2 = i.d(fVarD, this.f10456k, this.m);
        i.i(fVarD2);
        f fVar2 = this.n.get(m.n(str, ".weight"));
        f fVar3 = this.n.get(m.n(str, ".bias"));
        if (fVar2 == null || fVar3 == null) {
            return null;
        }
        f fVarD3 = i.d(fVarD2, fVar2, fVar3);
        i.j(fVarD3);
        return fVarD3;
    }
}
