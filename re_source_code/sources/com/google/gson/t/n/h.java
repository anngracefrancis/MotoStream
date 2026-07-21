package com.google.gson.t.n;

import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: ObjectTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends q<Object> {
    public static final r a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.e f20239b;

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new h(eVar);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ObjectTypeAdapter.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.stream.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.stream.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.stream.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.stream.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    h(com.google.gson.e eVar) {
        this.f20239b = eVar;
    }

    @Override // com.google.gson.q
    public Object b(com.google.gson.stream.a aVar) throws IOException {
        switch (b.a[aVar.Q().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.l()) {
                    arrayList.add(b(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                com.google.gson.t.h hVar = new com.google.gson.t.h();
                aVar.b();
                while (aVar.l()) {
                    hVar.put(aVar.D(), b(aVar));
                }
                aVar.j();
                return hVar;
            case 3:
                return aVar.K();
            case 4:
                return Double.valueOf(aVar.z());
            case 5:
                return Boolean.valueOf(aVar.y());
            case 6:
                aVar.I();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.y();
            return;
        }
        q qVarK = this.f20239b.k(obj.getClass());
        if (!(qVarK instanceof h)) {
            qVarK.d(cVar, obj);
        } else {
            cVar.d();
            cVar.j();
        }
    }
}
