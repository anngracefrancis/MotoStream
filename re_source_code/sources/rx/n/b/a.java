package rx.n.b;

import rx.g;

/* JADX INFO: compiled from: ProducerArbiter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final g f26606f = new C0453a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f26607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    g f26608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f26609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f26610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f26611k;
    g l;

    /* JADX INFO: renamed from: rx.n.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProducerArbiter.java */
    static class C0453a implements g {
        C0453a() {
        }

        @Override // rx.g
        public void request(long j2) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j2 = this.f26610j;
                long j3 = this.f26611k;
                g gVar = this.l;
                if (j2 == 0 && j3 == 0 && gVar == null) {
                    this.f26609i = false;
                    return;
                }
                this.f26610j = 0L;
                this.f26611k = 0L;
                this.l = null;
                long j4 = this.f26607g;
                if (j4 != Long.MAX_VALUE) {
                    long j5 = j4 + j2;
                    if (j5 < 0 || j5 == Long.MAX_VALUE) {
                        this.f26607g = Long.MAX_VALUE;
                        j4 = Long.MAX_VALUE;
                    } else {
                        j4 = j5 - j3;
                        if (j4 < 0) {
                            throw new IllegalStateException("more produced than requested");
                        }
                        this.f26607g = j4;
                    }
                }
                if (gVar == null) {
                    g gVar2 = this.f26608h;
                    if (gVar2 != null && j2 != 0) {
                        gVar2.request(j2);
                    }
                } else if (gVar == f26606f) {
                    this.f26608h = null;
                } else {
                    this.f26608h = gVar;
                    gVar.request(j4);
                }
            }
        }
    }

    public void b(long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("n > 0 required");
        }
        synchronized (this) {
            if (this.f26609i) {
                this.f26611k += j2;
                return;
            }
            this.f26609i = true;
            try {
                long j3 = this.f26607g;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 - j2;
                    if (j4 < 0) {
                        throw new IllegalStateException("more items arrived than were requested");
                    }
                    this.f26607g = j4;
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f26609i = false;
                    throw th;
                }
            }
        }
    }

    public void c(g gVar) {
        synchronized (this) {
            if (this.f26609i) {
                if (gVar == null) {
                    gVar = f26606f;
                }
                this.l = gVar;
                return;
            }
            this.f26609i = true;
            try {
                this.f26608h = gVar;
                if (gVar != null) {
                    gVar.request(this.f26607g);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f26609i = false;
                    throw th;
                }
            }
        }
    }

    @Override // rx.g
    public void request(long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.f26609i) {
                this.f26610j += j2;
                return;
            }
            this.f26609i = true;
            try {
                long j3 = this.f26607g + j2;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
                this.f26607g = j3;
                g gVar = this.f26608h;
                if (gVar != null) {
                    gVar.request(j2);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f26609i = false;
                    throw th;
                }
            }
        }
    }
}
