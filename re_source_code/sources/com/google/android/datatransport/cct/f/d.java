package com.google.android.datatransport.cct.f;

import java.util.List;

/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends j {
    private final List<m> a;

    d(List<m> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.a = list;
    }

    @Override // com.google.android.datatransport.cct.f.j
    public List<m> c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.a.equals(((j) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}
