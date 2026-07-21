package io.sentry;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonObjectReader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class n2 extends io.sentry.vendor.gson.stream.a {
    public n2(Reader reader) {
        super(reader);
    }

    public static Date n0(String str, w1 w1Var) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return a1.e(str);
            } catch (Exception e2) {
                w1Var.b(s4.ERROR, "Error when deserializing millis timestamp format.", e2);
                return null;
            }
        } catch (Exception unused) {
            return a1.f(str);
        }
    }

    public Integer E0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return Integer.valueOf(z());
        }
        H();
        return null;
    }

    public <T> List<T> F0(w1 w1Var, l2<T> l2Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        a();
        ArrayList arrayList = new ArrayList();
        if (l()) {
            do {
                try {
                    arrayList.add(l2Var.a(this, w1Var));
                } catch (Exception e2) {
                    w1Var.b(s4.WARNING, "Failed to deserialize object in list.", e2);
                }
            } while (N() == io.sentry.vendor.gson.stream.b.BEGIN_OBJECT);
        }
        f();
        return arrayList;
    }

    public Long G0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return Long.valueOf(A());
        }
        H();
        return null;
    }

    public <T> Map<String, T> J0(w1 w1Var, l2<T> l2Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        b();
        HashMap map = new HashMap();
        if (l()) {
            while (true) {
                try {
                    map.put(B(), l2Var.a(this, w1Var));
                } catch (Exception e2) {
                    w1Var.b(s4.WARNING, "Failed to deserialize object in map.", e2);
                }
                if (N() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && N() != io.sentry.vendor.gson.stream.b.NAME) {
                    break;
                }
            }
        }
        j();
        return map;
    }

    public Object K0() throws IOException {
        return new m2().a(this);
    }

    public <T> T M0(w1 w1Var, l2<T> l2Var) throws Exception {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return l2Var.a(this, w1Var);
        }
        H();
        return null;
    }

    public String N0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return J();
        }
        H();
        return null;
    }

    public TimeZone Q0(w1 w1Var) throws IOException {
        if (N() == io.sentry.vendor.gson.stream.b.NULL) {
            H();
            return null;
        }
        try {
            return TimeZone.getTimeZone(J());
        } catch (Exception e2) {
            w1Var.b(s4.ERROR, "Error when deserializing TimeZone", e2);
            return null;
        }
    }

    public void R0(w1 w1Var, Map<String, Object> map, String str) {
        try {
            map.put(str, K0());
        } catch (Exception e2) {
            w1Var.a(s4.ERROR, e2, "Error deserializing unknown key: %s", str);
        }
    }

    public Boolean p0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return Boolean.valueOf(x());
        }
        H();
        return null;
    }

    public Date q0(w1 w1Var) throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return n0(J(), w1Var);
        }
        H();
        return null;
    }

    public Double t0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return Double.valueOf(y());
        }
        H();
        return null;
    }

    public Float x0() throws IOException {
        return Float.valueOf((float) y());
    }

    public Float y0() throws IOException {
        if (N() != io.sentry.vendor.gson.stream.b.NULL) {
            return x0();
        }
        H();
        return null;
    }
}
