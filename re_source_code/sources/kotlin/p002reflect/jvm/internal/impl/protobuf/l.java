package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LazyStringArrayList.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends AbstractList<String> implements RandomAccess, m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m f25446f = new l().k();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Object> f25447g;

    public l() {
        this.f25447g = new ArrayList();
    }

    private static d f(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        return obj instanceof String ? d.n((String) obj) : d.h((byte[]) obj);
    }

    private static String g(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof d ? ((d) obj).D() : i.b((byte[]) obj);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public d N0(int i2) {
        Object obj = this.f25447g.get(i2);
        d dVarF = f(obj);
        if (dVarF != obj) {
            this.f25447g.set(i2, dVarF);
        }
        return dVarF;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i2, String str) {
        this.f25447g.add(i2, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f25447g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i2) {
        Object obj = this.f25447g.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String strD = dVar.D();
            if (dVar.t()) {
                this.f25447g.set(i2, strD);
            }
            return strD;
        }
        byte[] bArr = (byte[]) obj;
        String strB = i.b(bArr);
        if (i.a(bArr)) {
            this.f25447g.set(i2, strB);
        }
        return strB;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public void h1(d dVar) {
        this.f25447g.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public String remove(int i2) {
        Object objRemove = this.f25447g.remove(i2);
        ((AbstractList) this).modCount++;
        return g(objRemove);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public List<?> j() {
        return Collections.unmodifiableList(this.f25447g);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public m k() {
        return new u(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String set(int i2, String str) {
        return g(this.f25447g.set(i2, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f25447g.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends String> collection) {
        if (collection instanceof m) {
            collection = ((m) collection).j();
        }
        boolean zAddAll = this.f25447g.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public l(m mVar) {
        this.f25447g = new ArrayList(mVar.size());
        addAll(mVar);
    }
}
