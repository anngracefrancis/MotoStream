package com.google.android.datatransport.cct.f;

/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends k {
    private final k.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.cct.f.a f11251b;

    /* JADX INFO: compiled from: AutoValue_ClientInfo.java */
    static final class b extends k.a {
        private k.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.google.android.datatransport.cct.f.a f11252b;

        b() {
        }

        @Override // com.google.android.datatransport.cct.f.k.a
        public k a() {
            return new e(this.a, this.f11252b);
        }

        @Override // com.google.android.datatransport.cct.f.k.a
        public k.a b(com.google.android.datatransport.cct.f.a aVar) {
            this.f11252b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.k.a
        public k.a c(k.b bVar) {
            this.a = bVar;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.f.k
    public com.google.android.datatransport.cct.f.a b() {
        return this.f11251b;
    }

    @Override // com.google.android.datatransport.cct.f.k
    public k.b c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        k.b bVar = this.a;
        if (bVar != null ? bVar.equals(kVar.c()) : kVar.c() == null) {
            com.google.android.datatransport.cct.f.a aVar = this.f11251b;
            if (aVar == null) {
                if (kVar.b() == null) {
                    return true;
                }
            } else if (aVar.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.f.a aVar = this.f11251b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.f11251b + "}";
    }

    private e(k.b bVar, com.google.android.datatransport.cct.f.a aVar) {
        this.a = bVar;
        this.f11251b = aVar;
    }
}
