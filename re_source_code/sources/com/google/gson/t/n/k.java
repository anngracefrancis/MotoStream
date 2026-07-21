package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: TimeTypeAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends q<Time> {
    public static final r a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateFormat f20256b = new SimpleDateFormat("hh:mm:ss a");

    /* JADX INFO: compiled from: TimeTypeAdapter.java */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // com.google.gson.q
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Time b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.Q() == com.google.gson.stream.b.NULL) {
            aVar.I();
            return null;
        }
        try {
            return new Time(this.f20256b.parse(aVar.K()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.q
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(com.google.gson.stream.c cVar, Time time) throws IOException {
        cVar.Y(time == null ? null : this.f20256b.format((Date) time));
    }
}
