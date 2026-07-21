package androidx.work.impl.n;

/* JADX INFO: compiled from: WorkProgressDao_Impl.java */
/* JADX INFO: loaded from: classes.dex */
public final class o implements n {
    private final androidx.room.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.c<m> f2521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.q f2522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.q f2523d;

    /* JADX INFO: compiled from: WorkProgressDao_Impl.java */
    class a extends androidx.room.c<m> {
        a(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(c.u.a.f fVar, m mVar) throws Throwable {
            String str = mVar.a;
            if (str == null) {
                fVar.I0(1);
            } else {
                fVar.w(1, str);
            }
            byte[] bArrL = androidx.work.e.l(mVar.f2520b);
            if (bArrL == null) {
                fVar.I0(2);
            } else {
                fVar.o0(2, bArrL);
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    /* JADX INFO: compiled from: WorkProgressDao_Impl.java */
    class b extends androidx.room.q {
        b(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* JADX INFO: compiled from: WorkProgressDao_Impl.java */
    class c extends androidx.room.q {
        c(androidx.room.j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public o(androidx.room.j jVar) {
        this.a = jVar;
        this.f2521b = new a(jVar);
        this.f2522c = new b(jVar);
        this.f2523d = new c(jVar);
    }

    @Override // androidx.work.impl.n.n
    public void a() {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2523d.acquire();
        this.a.beginTransaction();
        try {
            fVarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2523d.release(fVarAcquire);
        }
    }

    @Override // androidx.work.impl.n.n
    public void b(m mVar) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f2521b.insert(mVar);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.n.n
    public void delete(String str) {
        this.a.assertNotSuspendingTransaction();
        c.u.a.f fVarAcquire = this.f2522c.acquire();
        if (str == null) {
            fVarAcquire.I0(1);
        } else {
            fVarAcquire.w(1, str);
        }
        this.a.beginTransaction();
        try {
            fVarAcquire.E();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f2522c.release(fVarAcquire);
        }
    }
}
