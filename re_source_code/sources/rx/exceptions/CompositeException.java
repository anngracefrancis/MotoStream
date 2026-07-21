package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public final class CompositeException extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Throwable> f26091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f26092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Throwable f26093h;

    static final class a extends RuntimeException {
        a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        b() {
        }

        abstract Object a();

        abstract void b(Object obj);
    }

    static final class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // rx.exceptions.CompositeException.b
        Object a() {
            return this.a;
        }

        @Override // rx.exceptions.CompositeException.b
        void b(Object obj) {
            this.a.println(obj);
        }
    }

    static final class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // rx.exceptions.CompositeException.b
        Object a() {
            return this.a;
        }

        @Override // rx.exceptions.CompositeException.b
        void b(Object obj) {
            this.a.println(obj);
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f26091f = listUnmodifiableList;
        this.f26092g = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), HttpUrl.FRAGMENT_ENCODE_SET);
        }
    }

    private List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause.getCause();
            }
        }
        return arrayList;
    }

    private Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || cause == th) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause.getCause();
        }
        return cause;
    }

    private void e(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i2 = 1;
        for (Throwable th : this.f26091f) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            a(sb, th, "\t");
            i2++;
        }
        synchronized (bVar.a()) {
            bVar.b(sb.toString());
        }
    }

    public List<Throwable> b() {
        return this.f26091f;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f26093h == null) {
            a aVar = new a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f26091f.iterator();
            Throwable thD = aVar;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : c(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        thD.initCause(next);
                    } catch (Throwable unused) {
                    }
                    thD = d(thD);
                }
            }
            this.f26093h = aVar;
        }
        return this.f26093h;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f26092g;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(new d(printWriter));
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public CompositeException(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f26091f = listUnmodifiableList;
        this.f26092g = listUnmodifiableList.size() + " exceptions occurred. ";
    }
}
