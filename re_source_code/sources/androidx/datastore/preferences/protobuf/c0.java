package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q0 f1270f;

    /* JADX INFO: compiled from: LazyField.java */
    static class b<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map.Entry<K, c0> f1271f;

        public c0 a() {
            return this.f1271f.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f1271f.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            c0 value = this.f1271f.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof q0) {
                return this.f1271f.getValue().d((q0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, c0> entry) {
            this.f1271f = entry;
        }
    }

    /* JADX INFO: compiled from: LazyField.java */
    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f1272f;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f1272f = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f1272f.next();
            return next.getValue() instanceof c0 ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1272f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1272f.remove();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public q0 f() {
        return c(this.f1270f);
    }

    @Override // androidx.datastore.preferences.protobuf.d0
    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
