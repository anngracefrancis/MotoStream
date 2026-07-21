package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UserFeedback.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w5 implements r2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f22811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22813j;

    /* JADX INFO: compiled from: UserFeedback.java */
    public static final class a implements l2<w5> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w5 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            io.sentry.protocol.q qVarA = null;
            String strN0 = null;
            String strN1 = null;
            String strN2 = null;
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "comments":
                        strN2 = n2Var.N0();
                        break;
                    case "name":
                        strN0 = n2Var.N0();
                        break;
                    case "email":
                        strN1 = n2Var.N0();
                        break;
                    case "event_id":
                        qVarA = new io.sentry.protocol.q.a().a(n2Var, w1Var);
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        n2Var.R0(w1Var, map, strB);
                        break;
                }
            }
            n2Var.j();
            if (qVarA != null) {
                w5 w5Var = new w5(qVarA, strN0, strN1, strN2);
                w5Var.a(map);
                return w5Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            w1Var.b(s4.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public w5(io.sentry.protocol.q qVar, String str, String str2, String str3) {
        this.f22809f = qVar;
        this.f22810g = str;
        this.f22811h = str2;
        this.f22812i = str3;
    }

    public void a(Map<String, Object> map) {
        this.f22813j = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("event_id");
        this.f22809f.serialize(h3Var, w1Var);
        if (this.f22810g != null) {
            h3Var.k("name").b(this.f22810g);
        }
        if (this.f22811h != null) {
            h3Var.k("email").b(this.f22811h);
        }
        if (this.f22812i != null) {
            h3Var.k("comments").b(this.f22812i);
        }
        Map<String, Object> map = this.f22813j;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22813j.get(str));
            }
        }
        h3Var.d();
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.f22809f + ", name='" + this.f22810g + "', email='" + this.f22811h + "', comments='" + this.f22812i + "'}";
    }
}
