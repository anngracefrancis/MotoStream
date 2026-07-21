package io.sentry;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonObjectSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o2 {
    public final q2 a;

    public o2(int i2) {
        this.a = new q2(i2);
    }

    private void b(h3 h3Var, w1 w1Var, Collection<?> collection) throws IOException {
        h3Var.l();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            a(h3Var, w1Var, it.next());
        }
        h3Var.j();
    }

    private void c(h3 h3Var, w1 w1Var, Date date) throws IOException {
        try {
            h3Var.b(a1.g(date));
        } catch (Exception e2) {
            w1Var.b(s4.ERROR, "Error when serializing Date", e2);
            h3Var.i();
        }
    }

    private void d(h3 h3Var, w1 w1Var, Map<?, ?> map) throws IOException {
        h3Var.f();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                h3Var.k((String) obj);
                a(h3Var, w1Var, map.get(obj));
            }
        }
        h3Var.d();
    }

    private void e(h3 h3Var, w1 w1Var, TimeZone timeZone) throws IOException {
        try {
            h3Var.b(timeZone.getID());
        } catch (Exception e2) {
            w1Var.b(s4.ERROR, "Error when serializing TimeZone", e2);
            h3Var.i();
        }
    }

    public void a(h3 h3Var, w1 w1Var, Object obj) throws IOException {
        if (obj == null) {
            h3Var.i();
            return;
        }
        if (obj instanceof Character) {
            h3Var.b(Character.toString(((Character) obj).charValue()));
            return;
        }
        if (obj instanceof String) {
            h3Var.b((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            h3Var.c(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Number) {
            h3Var.e((Number) obj);
            return;
        }
        if (obj instanceof Date) {
            c(h3Var, w1Var, (Date) obj);
            return;
        }
        if (obj instanceof TimeZone) {
            e(h3Var, w1Var, (TimeZone) obj);
            return;
        }
        if (obj instanceof r2) {
            ((r2) obj).serialize(h3Var, w1Var);
            return;
        }
        if (obj instanceof Collection) {
            b(h3Var, w1Var, (Collection) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            b(h3Var, w1Var, Arrays.asList((Object[]) obj));
            return;
        }
        if (obj instanceof Map) {
            d(h3Var, w1Var, (Map) obj);
            return;
        }
        if (obj instanceof Locale) {
            h3Var.b(obj.toString());
            return;
        }
        if (obj instanceof AtomicIntegerArray) {
            b(h3Var, w1Var, io.sentry.util.n.a((AtomicIntegerArray) obj));
            return;
        }
        if (obj instanceof AtomicBoolean) {
            h3Var.c(((AtomicBoolean) obj).get());
            return;
        }
        if (obj instanceof URI) {
            h3Var.b(obj.toString());
            return;
        }
        if (obj instanceof InetAddress) {
            h3Var.b(obj.toString());
            return;
        }
        if (obj instanceof UUID) {
            h3Var.b(obj.toString());
            return;
        }
        if (obj instanceof Currency) {
            h3Var.b(obj.toString());
            return;
        }
        if (obj instanceof Calendar) {
            d(h3Var, w1Var, io.sentry.util.n.c((Calendar) obj));
            return;
        }
        if (obj.getClass().isEnum()) {
            h3Var.b(obj.toString());
            return;
        }
        try {
            a(h3Var, w1Var, this.a.d(obj, w1Var));
        } catch (Exception e2) {
            w1Var.b(s4.ERROR, "Failed serializing unknown object.", e2);
            h3Var.b("[OBJECT]");
        }
    }
}
