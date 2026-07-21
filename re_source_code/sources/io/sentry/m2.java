package io.sentry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonObjectDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class m2 {
    private final ArrayList<c> a = new ArrayList<>();

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.sentry.vendor.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[io.sentry.vendor.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NUMBER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[io.sentry.vendor.gson.stream.b.END_DOCUMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    interface b {
        Object a() throws IOException;
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private interface c {
        Object getValue();
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class f implements c {
        final String a;

        f(String str) {
            this.a = str;
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class g implements c {
        final Object a;

        g(Object obj) {
            this.a = obj;
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }
    }

    private c b() {
        if (this.a.isEmpty()) {
            return null;
        }
        ArrayList<c> arrayList = this.a;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean c() {
        if (e()) {
            return true;
        }
        c cVarB = b();
        m();
        if (!(b() instanceof f)) {
            if (!(b() instanceof d)) {
                return false;
            }
            d dVar = (d) b();
            if (cVarB == null || dVar == null) {
                return false;
            }
            dVar.a.add(cVarB.getValue());
            return false;
        }
        f fVar = (f) b();
        m();
        e eVar = (e) b();
        if (fVar == null || cVarB == null || eVar == null) {
            return false;
        }
        eVar.a.put(fVar.a, cVarB.getValue());
        return false;
    }

    private boolean d(b bVar) throws IOException {
        Object objA = bVar.a();
        if (b() == null && objA != null) {
            n(new g(objA));
            return true;
        }
        if (b() instanceof f) {
            f fVar = (f) b();
            m();
            ((e) b()).a.put(fVar.a, objA);
            return false;
        }
        if (!(b() instanceof d)) {
            return false;
        }
        ((d) b()).a.add(objA);
        return false;
    }

    private boolean e() {
        return this.a.size() == 1;
    }

    static /* synthetic */ Object j() throws IOException {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Object h(n2 n2Var) throws IOException {
        try {
            try {
                return Integer.valueOf(n2Var.z());
            } catch (Exception unused) {
                return Double.valueOf(n2Var.y());
            }
        } catch (Exception unused2) {
            return Long.valueOf(n2Var.A());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void l(final n2 n2Var) throws IOException {
        boolean zC;
        a aVar = null;
        switch (a.a[n2Var.N().ordinal()]) {
            case 1:
                n2Var.a();
                n(new d(aVar));
                zC = false;
                break;
            case 2:
                n2Var.f();
                zC = c();
                break;
            case 3:
                n2Var.b();
                n(new e(aVar));
                zC = false;
                break;
            case 4:
                n2Var.j();
                zC = c();
                break;
            case 5:
                n(new f(n2Var.B()));
                zC = false;
                break;
            case 6:
                zC = d(new b() { // from class: io.sentry.k
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        return n2Var.J();
                    }
                });
                break;
            case 7:
                zC = d(new b() { // from class: io.sentry.l
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        return this.a.h(n2Var);
                    }
                });
                break;
            case 8:
                zC = d(new b() { // from class: io.sentry.m
                    @Override // io.sentry.m2.b
                    public final Object a() {
                        return Boolean.valueOf(n2Var.x());
                    }
                });
                break;
            case 9:
                n2Var.H();
                zC = d(new b() { // from class: io.sentry.j
                    @Override // io.sentry.m2.b
                    public final Object a() throws IOException {
                        m2.j();
                        return null;
                    }
                });
                break;
            case 10:
                zC = true;
                break;
            default:
                zC = false;
                break;
        }
        if (zC) {
            return;
        }
        l(n2Var);
    }

    private void m() {
        if (this.a.isEmpty()) {
            return;
        }
        ArrayList<c> arrayList = this.a;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(c cVar) {
        this.a.add(cVar);
    }

    public Object a(n2 n2Var) throws IOException {
        l(n2Var);
        c cVarB = b();
        if (cVarB != null) {
            return cVarB.getValue();
        }
        return null;
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class d implements c {
        final ArrayList<Object> a;

        private d() {
            this.a = new ArrayList<>();
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: JsonObjectDeserializer.java */
    private static final class e implements c {
        final HashMap<String, Object> a;

        private e() {
            this.a = new HashMap<>();
        }

        @Override // io.sentry.m2.c
        public Object getValue() {
            return this.a;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
