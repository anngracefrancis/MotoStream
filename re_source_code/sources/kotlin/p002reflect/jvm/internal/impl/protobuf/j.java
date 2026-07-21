package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final o f25440e;

    /* JADX INFO: compiled from: LazyField.java */
    static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map.Entry<K, j> f25441f;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f25441f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            j value = this.f25441f.getValue();
            if (value == null) {
                return null;
            }
            return value.e();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof o) {
                return this.f25441f.getValue().d((o) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, j> entry) {
            this.f25441f = entry;
        }
    }

    /* JADX INFO: compiled from: LazyField.java */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f25442f;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f25442f = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f25442f.next();
            return next.getValue() instanceof j ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25442f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f25442f.remove();
        }
    }

    public o e() {
        return c(this.f25440e);
    }

    public boolean equals(Object obj) {
        return e().equals(obj);
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return e().toString();
    }
}
