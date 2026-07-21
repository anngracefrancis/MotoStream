package e.e.b.a.i;

import java.util.Arrays;

/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private final e.e.b.a.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f20838b;

    public i(e.e.b.a.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.a = bVar;
        this.f20838b = bArr;
    }

    public byte[] a() {
        return this.f20838b;
    }

    public e.e.b.a.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.a.equals(iVar.a)) {
            return Arrays.equals(this.f20838b, iVar.f20838b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f20838b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.a + ", bytes=[...]}";
    }
}
