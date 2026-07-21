package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: DateTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends q<Date> {
    public static final r a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f20232b;

    /* JADX INFO: compiled from: DateTypeAdapter.java */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f20232b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.t.e.e()) {
            arrayList.add(com.google.gson.t.j.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        Iterator<DateFormat> it = this.f20232b.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.google.gson.t.n.o.a.c(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new JsonSyntaxException(str, e2);
        }
    }

    @Override // com.google.gson.q
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.Q() != com.google.gson.stream.b.NULL) {
            return e(aVar.K());
        }
        aVar.I();
        return null;
    }

    @Override // com.google.gson.q
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized void d(com.google.gson.stream.c cVar, Date date) throws IOException {
        try {
            if (date == null) {
                cVar.y();
            } else {
                cVar.Y(this.f20232b.get(0).format(date));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
