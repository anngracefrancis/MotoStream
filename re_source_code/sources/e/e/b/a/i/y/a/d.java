package e.e.b.a.i.y.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: LogSourceMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final d a = new a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<c> f20876c;

    /* JADX INFO: compiled from: LogSourceMetrics.java */
    public static final class a {
        private String a = HttpUrl.FRAGMENT_ENCODE_SET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<c> f20877b = new ArrayList();

        a() {
        }

        public d a() {
            return new d(this.a, Collections.unmodifiableList(this.f20877b));
        }

        public a b(List<c> list) {
            this.f20877b = list;
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    d(String str, List<c> list) {
        this.f20875b = str;
        this.f20876c = list;
    }

    public static a c() {
        return new a();
    }

    @com.google.firebase.encoders.i.f(tag = 2)
    public List<c> a() {
        return this.f20876c;
    }

    @com.google.firebase.encoders.i.f(tag = 1)
    public String b() {
        return this.f20875b;
    }
}
