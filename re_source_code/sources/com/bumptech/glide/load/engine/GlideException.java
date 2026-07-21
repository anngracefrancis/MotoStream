package com.bumptech.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public final class GlideException extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final StackTraceElement[] f9037f = new StackTraceElement[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<Throwable> f9038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.f f9039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.a f9040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Class<?> f9041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f9042k;
    private Exception l;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof GlideException)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((GlideException) th).e().iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i2 = i3;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List<Throwable> e() {
        return this.f9038g;
    }

    public List<Throwable> f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List<Throwable> listF = f();
        int size = listF.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), listF.get(i2));
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f9042k);
        Class<?> cls = this.f9041j;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        sb.append(cls != null ? ", " + this.f9041j : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(this.f9040i != null ? ", " + this.f9040i : HttpUrl.FRAGMENT_ENCODE_SET);
        if (this.f9039h != null) {
            str = ", " + this.f9039h;
        }
        sb.append(str);
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            sb.append(" causes:");
        }
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    void i(com.bumptech.glide.load.f fVar, com.bumptech.glide.load.a aVar) {
        j(fVar, aVar, null);
    }

    void j(com.bumptech.glide.load.f fVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.f9039h = fVar;
        this.f9040i = aVar;
        this.f9041j = cls;
    }

    public void k(Exception exc) {
        this.l = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.f9042k = str;
        setStackTrace(f9037f);
        this.f9038g = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    private static final class a implements Appendable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Appendable f9043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f9044g = true;

        a(Appendable appendable) {
            this.f9043f = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? HttpUrl.FRAGMENT_ENCODE_SET : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            if (this.f9044g) {
                this.f9044g = false;
                this.f9043f.append("  ");
            }
            this.f9044g = c2 == '\n';
            this.f9043f.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.f9044g) {
                this.f9044g = false;
                this.f9043f.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f9044g = z;
            this.f9043f.append(charSequenceA, i2, i3);
            return this;
        }
    }
}
