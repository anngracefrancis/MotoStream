package c.f.a;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: AbstractResolvableFuture.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements e.e.c.a.a.a<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final boolean f2955f = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", AdultContentAnalytics.UNLOCK));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f2956g = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final b f2957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f2958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile Object f2959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile e f2960k;
    volatile i l;

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class c {
        static final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final c f2961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f2962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Throwable f2963d;

        static {
            if (a.f2955f) {
                f2961b = null;
                a = null;
            } else {
                f2961b = new c(false, null);
                a = new c(true, null);
            }
        }

        c(boolean z, Throwable th) {
            this.f2962c = z;
            this.f2963d = th;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class d {
        static final d a = new d(new C0069a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f2964b;

        /* JADX INFO: renamed from: c.f.a.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractResolvableFuture.java */
        class C0069a extends Throwable {
            C0069a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f2964b = (Throwable) a.x(th);
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class e {
        static final e a = new e(null, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f2965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f2966c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e f2967d;

        e(Runnable runnable, Executor executor) {
            this.f2965b = runnable;
            this.f2966c = executor;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class f extends b {
        final AtomicReferenceFieldUpdater<i, Thread> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f2968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f2969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f2970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f2971e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.f2968b = atomicReferenceFieldUpdater2;
            this.f2969c = atomicReferenceFieldUpdater3;
            this.f2970d = atomicReferenceFieldUpdater4;
            this.f2971e = atomicReferenceFieldUpdater5;
        }

        @Override // c.f.a.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f2970d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // c.f.a.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f2971e.compareAndSet(aVar, obj, obj2);
        }

        @Override // c.f.a.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f2969c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // c.f.a.a.b
        void d(i iVar, i iVar2) {
            this.f2968b.lazySet(iVar, iVar2);
        }

        @Override // c.f.a.a.b
        void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final a<V> f2972f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final e.e.c.a.a.a<? extends V> f2973g;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2972f.f2959j != this) {
                return;
            }
            if (a.f2957h.b(this.f2972f, this, a.F(this.f2973g))) {
                a.A(this.f2972f);
            }
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class h extends b {
        h() {
            super();
        }

        @Override // c.f.a.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f2960k != eVar) {
                    return false;
                }
                aVar.f2960k = eVar2;
                return true;
            }
        }

        @Override // c.f.a.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f2959j != obj) {
                    return false;
                }
                aVar.f2959j = obj2;
                return true;
            }
        }

        @Override // c.f.a.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.l != iVar) {
                    return false;
                }
                aVar.l = iVar2;
                return true;
            }
        }

        @Override // c.f.a.a.b
        void d(i iVar, i iVar2) {
            iVar.f2975c = iVar2;
        }

        @Override // c.f.a.a.b
        void e(i iVar, Thread thread) {
            iVar.f2974b = thread;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class i {
        static final i a = new i(false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Thread f2974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile i f2975c;

        i(boolean z) {
        }

        void a(i iVar) {
            a.f2957h.d(this, iVar);
        }

        void b() {
            Thread thread = this.f2974b;
            if (thread != null) {
                this.f2974b = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.f2957h.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "l"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "k"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "j"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f2957h = hVar;
        if (th != null) {
            f2956g.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f2958i = new Object();
    }

    protected a() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static void A(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.J();
            aVar.u();
            e eVarY = aVar.y(eVar);
            while (eVarY != null) {
                eVar = eVarY.f2967d;
                Runnable runnable = eVarY.f2965b;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f2972f;
                    if (aVar.f2959j == gVar) {
                        if (f2957h.b(aVar, gVar, F(gVar.f2973g))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    D(runnable, eVarY.f2966c);
                }
                eVarY = eVar;
            }
            return;
        }
    }

    private static void D(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f2956g.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V E(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw v("Task was cancelled.", ((c) obj).f2963d);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f2964b);
        }
        if (obj == f2958i) {
            return null;
        }
        return obj;
    }

    static Object F(e.e.c.a.a.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f2959j;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f2962c) {
                return cVar.f2963d != null ? new c(false, cVar.f2963d) : c.f2961b;
            }
            return obj;
        }
        boolean zIsCancelled = aVar.isCancelled();
        if ((!f2955f) && zIsCancelled) {
            return c.f2961b;
        }
        try {
            Object objG = G(aVar);
            return objG == null ? f2958i : objG;
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new c(false, e2);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + aVar, e2));
        } catch (ExecutionException e3) {
            return new d(e3.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V G(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void J() {
        i iVar;
        do {
            iVar = this.l;
        } while (!f2957h.c(this, iVar, i.a));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f2975c;
        }
    }

    private void K(i iVar) {
        iVar.f2974b = null;
        while (true) {
            i iVar2 = this.l;
            if (iVar2 == i.a) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f2975c;
                if (iVar2.f2974b != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f2975c = iVar4;
                    if (iVar3.f2974b == null) {
                    }
                } else if (!f2957h.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String N(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private void q(StringBuilder sb) {
        try {
            Object objG = G(this);
            sb.append("SUCCESS, result=[");
            sb.append(N(objG));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static CancellationException v(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T x(T t) {
        t.getClass();
        return t;
    }

    private e y(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f2960k;
        } while (!f2957h.a(this, eVar2, e.a));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f2967d;
            eVar4.f2967d = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    protected void H() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String I() {
        Object obj = this.f2959j;
        if (obj instanceof g) {
            return "setFuture=[" + N(((g) obj).f2973g) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected boolean L(V v) {
        if (v == null) {
            v = (V) f2958i;
        }
        if (!f2957h.b(this, null, v)) {
            return false;
        }
        A(this);
        return true;
    }

    protected boolean M(Throwable th) {
        if (!f2957h.b(this, null, new d((Throwable) x(th)))) {
            return false;
        }
        A(this);
        return true;
    }

    protected final boolean O() {
        Object obj = this.f2959j;
        return (obj instanceof c) && ((c) obj).f2962c;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.f2959j;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f2955f) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.a : c.f2961b;
        }
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (f2957h.b(aVar, obj, cVar)) {
                if (z) {
                    aVar.H();
                }
                A(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                e.e.c.a.a.a<? extends V> aVar2 = ((g) obj).f2973g;
                if (!(aVar2 instanceof a)) {
                    aVar2.cancel(z);
                    return true;
                }
                aVar = (a) aVar2;
                obj = aVar.f2959j;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = aVar.f2959j;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // e.e.c.a.a.a
    public final void g(Runnable runnable, Executor executor) {
        x(runnable);
        x(executor);
        e eVar = this.f2960k;
        if (eVar != e.a) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f2967d = eVar;
                if (f2957h.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f2960k;
                }
            } while (eVar != e.a);
        }
        D(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f2959j;
        if ((obj != null) && (!(obj instanceof g))) {
            return E(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.l;
            if (iVar != i.a) {
                i iVar2 = new i();
                while (true) {
                    iVar2.a(iVar);
                    if (f2957h.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                K(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f2959j;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return E(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        K(iVar2);
                        break;
                    }
                    iVar = this.l;
                    if (iVar == i.a) {
                    }
                }
            }
            return E(this.f2959j);
        }
        while (nanos > 0) {
            Object obj3 = this.f2959j;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return E(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2959j instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f2959j;
        return (!(obj instanceof g)) & (obj != null);
    }

    public String toString() {
        String strI;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            q(sb);
        } else {
            try {
                strI = I();
            } catch (RuntimeException e2) {
                strI = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strI != null && !strI.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strI);
                sb.append("]");
            } else if (isDone()) {
                q(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected void u() {
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2959j;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return E(obj2);
            }
            i iVar = this.l;
            if (iVar != i.a) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f2957h.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2959j;
                            } else {
                                K(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return E(obj);
                    }
                    iVar = this.l;
                } while (iVar != i.a);
            }
            return E(this.f2959j);
        }
        throw new InterruptedException();
    }
}
