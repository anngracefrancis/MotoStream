package androidx.work.impl.utils.o;

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

/* JADX INFO: compiled from: AbstractFuture.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements e.e.c.a.a.a<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final boolean f2617f = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", AdultContentAnalytics.UNLOCK));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f2618g = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final b f2619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f2620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile Object f2621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile e f2622k;
    volatile i l;

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class c {
        static final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final c f2623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f2624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Throwable f2625d;

        static {
            if (a.f2617f) {
                f2623b = null;
                a = null;
            } else {
                f2623b = new c(false, null);
                a = new c(true, null);
            }
        }

        c(boolean z, Throwable th) {
            this.f2624c = z;
            this.f2625d = th;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class d {
        static final d a = new d(new C0055a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f2626b;

        /* JADX INFO: renamed from: androidx.work.impl.utils.o.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractFuture.java */
        class C0055a extends Throwable {
            C0055a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f2626b = (Throwable) a.d(th);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class e {
        static final e a = new e(null, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f2627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f2628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        e f2629d;

        e(Runnable runnable, Executor executor) {
            this.f2627b = runnable;
            this.f2628c = executor;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class f extends b {
        final AtomicReferenceFieldUpdater<i, Thread> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f2630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f2631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f2632d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f2633e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.f2630b = atomicReferenceFieldUpdater2;
            this.f2631c = atomicReferenceFieldUpdater3;
            this.f2632d = atomicReferenceFieldUpdater4;
            this.f2633e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f2632d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f2633e.compareAndSet(aVar, obj, obj2);
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f2631c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.o.a.b
        void d(i iVar, i iVar2) {
            this.f2630b.lazySet(iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.o.a.b
        void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final a<V> f2634f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final e.e.c.a.a.a<? extends V> f2635g;

        g(a<V> aVar, e.e.c.a.a.a<? extends V> aVar2) {
            this.f2634f = aVar;
            this.f2635g = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2634f.f2621j != this) {
                return;
            }
            if (a.f2619h.b(this.f2634f, this, a.j(this.f2635g))) {
                a.f(this.f2634f);
            }
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f2622k != eVar) {
                    return false;
                }
                aVar.f2622k = eVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f2621j != obj) {
                    return false;
                }
                aVar.f2621j = obj2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.o.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.l != iVar) {
                    return false;
                }
                aVar.l = iVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.o.a.b
        void d(i iVar, i iVar2) {
            iVar.f2637c = iVar2;
        }

        @Override // androidx.work.impl.utils.o.a.b
        void e(i iVar, Thread thread) {
            iVar.f2636b = thread;
        }
    }

    /* JADX INFO: compiled from: AbstractFuture.java */
    private static final class i {
        static final i a = new i(false);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Thread f2636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile i f2637c;

        i(boolean z) {
        }

        void a(i iVar) {
            a.f2619h.d(this, iVar);
        }

        void b() {
            Thread thread = this.f2636b;
            if (thread != null) {
                this.f2636b = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.f2619h.e(this, Thread.currentThread());
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
        f2619h = hVar;
        if (th != null) {
            f2618g.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f2620i = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objL = l(this);
            sb.append("SUCCESS, result=[");
            sb.append(t(objL));
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

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T d(T t) {
        t.getClass();
        return t;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f2622k;
        } while (!f2619h.a(this, eVar2, e.a));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f2629d;
            eVar4.f2629d = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
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
    static void f(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.o();
            aVar.b();
            e eVarE = aVar.e(eVar);
            while (eVarE != null) {
                eVar = eVarE.f2629d;
                Runnable runnable = eVarE.f2627b;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f2634f;
                    if (aVar.f2621j == gVar) {
                        if (f2619h.b(aVar, gVar, j(gVar.f2635g))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, eVarE.f2628c);
                }
                eVarE = eVar;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f2618g.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f2625d);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f2626b);
        }
        if (obj == f2620i) {
            return null;
        }
        return obj;
    }

    static Object j(e.e.c.a.a.a<?> aVar) {
        if (aVar instanceof a) {
            Object obj = ((a) aVar).f2621j;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f2624c) {
                return cVar.f2625d != null ? new c(false, cVar.f2625d) : c.f2623b;
            }
            return obj;
        }
        boolean zIsCancelled = aVar.isCancelled();
        if ((!f2617f) && zIsCancelled) {
            return c.f2623b;
        }
        try {
            Object objL = l(aVar);
            return objL == null ? f2620i : objL;
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

    private static <V> V l(Future<V> future) throws ExecutionException {
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

    private void o() {
        i iVar;
        do {
            iVar = this.l;
        } while (!f2619h.c(this, iVar, i.a));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f2637c;
        }
    }

    private void p(i iVar) {
        iVar.f2636b = null;
        while (true) {
            i iVar2 = this.l;
            if (iVar2 == i.a) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f2637c;
                if (iVar2.f2636b != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f2637c = iVar4;
                    if (iVar3.f2636b == null) {
                    }
                } else if (!f2619h.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String t(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.f2621j;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f2617f) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.a : c.f2623b;
        }
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (f2619h.b(aVar, obj, cVar)) {
                if (z) {
                    aVar.m();
                }
                f(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                e.e.c.a.a.a<? extends V> aVar2 = ((g) obj).f2635g;
                if (!(aVar2 instanceof a)) {
                    aVar2.cancel(z);
                    return true;
                }
                aVar = (a) aVar2;
                obj = aVar.f2621j;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = aVar.f2621j;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // e.e.c.a.a.a
    public final void g(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.f2622k;
        if (eVar != e.a) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f2629d = eVar;
                if (f2619h.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f2622k;
                }
            } while (eVar != e.a);
        }
        h(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f2621j;
        if ((obj != null) && (!(obj instanceof g))) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.l;
            if (iVar != i.a) {
                i iVar2 = new i();
                while (true) {
                    iVar2.a(iVar);
                    if (f2619h.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                p(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f2621j;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        p(iVar2);
                        break;
                    }
                    iVar = this.l;
                    if (iVar == i.a) {
                    }
                }
            }
            return i(this.f2621j);
        }
        while (nanos > 0) {
            Object obj3 = this.f2621j;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return i(obj3);
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
        return this.f2621j instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f2621j;
        return (!(obj instanceof g)) & (obj != null);
    }

    protected void m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String n() {
        Object obj = this.f2621j;
        if (obj instanceof g) {
            return "setFuture=[" + t(((g) obj).f2635g) + "]";
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
    protected boolean q(V v) {
        if (v == null) {
            v = (V) f2620i;
        }
        if (!f2619h.b(this, null, v)) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean r(Throwable th) {
        if (!f2619h.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean s(e.e.c.a.a.a<? extends V> aVar) {
        d dVar;
        d(aVar);
        Object obj = this.f2621j;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!f2619h.b(this, null, j(aVar))) {
                    return false;
                }
                f(this);
                return true;
            }
            g gVar = new g(this, aVar);
            if (f2619h.b(this, null, gVar)) {
                try {
                    aVar.g(gVar, androidx.work.impl.utils.o.b.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.a;
                    }
                    f2619h.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f2621j;
        }
        if (obj instanceof c) {
            aVar.cancel(((c) obj).f2624c);
        }
        return false;
    }

    public String toString() {
        String strN;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strN = n();
            } catch (RuntimeException e2) {
                strN = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strN != null && !strN.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strN);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2621j;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return i(obj2);
            }
            i iVar = this.l;
            if (iVar != i.a) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f2619h.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2621j;
                            } else {
                                p(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return i(obj);
                    }
                    iVar = this.l;
                } while (iVar != i.a);
            }
            return i(this.f2621j);
        }
        throw new InterruptedException();
    }
}
