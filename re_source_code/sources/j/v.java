package j;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f22865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private y f22866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f22869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final h f22870k;

    public v(h hVar) {
        kotlin.jvm.internal.m.f(hVar, "upstream");
        this.f22870k = hVar;
        f fVarI = hVar.i();
        this.f22865f = fVarI;
        y yVar = fVarI.f22831f;
        this.f22866g = yVar;
        this.f22867h = yVar != null ? yVar.f22879c : -1;
    }

    @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22868i = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    @Override // j.d0
    public long read(f fVar, long j2) {
        y yVar;
        kotlin.jvm.internal.m.f(fVar, "sink");
        boolean z = false;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.f22868i)) {
            throw new IllegalStateException("closed".toString());
        }
        y yVar2 = this.f22866g;
        if (yVar2 == null) {
            z = true;
        } else {
            y yVar3 = this.f22865f.f22831f;
            if (yVar2 == yVar3) {
                int i2 = this.f22867h;
                kotlin.jvm.internal.m.c(yVar3);
                if (i2 == yVar3.f22879c) {
                    z = true;
                }
            }
        }
        if (!z) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        if (!this.f22870k.request(this.f22869j + 1)) {
            return -1L;
        }
        if (this.f22866g == null && (yVar = this.f22865f.f22831f) != null) {
            this.f22866g = yVar;
            kotlin.jvm.internal.m.c(yVar);
            this.f22867h = yVar.f22879c;
        }
        long jMin = Math.min(j2, this.f22865f.size() - this.f22869j);
        this.f22865f.j(fVar, this.f22869j, jMin);
        this.f22869j += jMin;
        return jMin;
    }

    @Override // j.d0
    public e0 timeout() {
        return this.f22870k.timeout();
    }
}
