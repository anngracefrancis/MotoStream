package e.e.b.a.i.b0.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes2.dex */
@Singleton
public class r0 implements j0, com.google.android.datatransport.runtime.synchronization.a, i0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e.e.b.a.b f20785f = e.e.b.a.b.b("proto");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t0 f20786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f20787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final e.e.b.a.i.c0.a f20788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k0 f20789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Provider<String> f20790k;

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface b<T, U> {
        U a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SQLiteEventStore.java */
    static class c {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f20791b;

        private c(String str, String str2) {
            this.a = str;
            this.f20791b = str2;
        }
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface d<T> {
        T a();
    }

    @Inject
    r0(e.e.b.a.i.c0.a aVar, e.e.b.a.i.c0.a aVar2, k0 k0Var, t0 t0Var, @Named("PACKAGE_NAME") Provider<String> provider) {
        this.f20786g = t0Var;
        this.f20787h = aVar;
        this.f20788i = aVar2;
        this.f20789j = k0Var;
        this.f20790k = provider;
    }

    private boolean B() {
        return p() * x() >= this.f20789j.f();
    }

    private List<q0> D(List<q0> list, Map<Long, Set<c>> map) {
        ListIterator<q0> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            q0 next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                e.e.b.a.i.j.a aVarL = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    aVarL.c(cVar.a, cVar.f20791b);
                }
                listIterator.set(q0.a(next.c(), next.d(), aVarL.d()));
            }
        }
        return list;
    }

    private /* synthetic */ Object E0(List list, e.e.b.a.i.q qVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            e.e.b.a.i.j.a aVarK = e.e.b.a.i.j.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z) {
                aVarK.h(new e.e.b.a.i.i(r1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new e.e.b.a.i.i(r1(cursor.getString(4)), n1(j2)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(q0.a(j2, qVar, aVarK.d()));
        }
        return null;
    }

    static /* synthetic */ Object G0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j2 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j2));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j2), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    private /* synthetic */ Object H(Cursor cursor) {
        while (cursor.moveToNext()) {
            d(cursor.getInt(0), e.e.b.a.i.y.a.c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer K(long j2, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j2)};
        t1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: e.e.b.a.i.b0.j.j
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                this.a.I((Cursor) obj);
                return null;
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Long K0(e.e.b.a.i.j jVar, e.e.b.a.i.q qVar, SQLiteDatabase sQLiteDatabase) {
        if (B()) {
            d(1L, e.e.b.a.i.y.a.c.b.CACHE_FULL, jVar.j());
            return -1L;
        }
        long j2 = j(sQLiteDatabase, qVar);
        int iE = this.f20789j.e();
        byte[] bArrA = jVar.e().a();
        boolean z = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(j2));
        contentValues.put("transport_name", jVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(jVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(jVar.k()));
        contentValues.put("payload_encoding", jVar.e().b().a());
        contentValues.put("code", jVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            double length = bArrA.length;
            double d2 = iE;
            Double.isNaN(length);
            Double.isNaN(d2);
            int iCeil = (int) Math.ceil(length / d2);
            for (int i2 = 1; i2 <= iCeil; i2++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i2 - 1) * iE, Math.min(i2 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : jVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    static /* synthetic */ byte[] M0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            byte[] bArr2 = (byte[]) arrayList.get(i2);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    static /* synthetic */ Object N(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    private /* synthetic */ Object N0(Cursor cursor) {
        while (cursor.moveToNext()) {
            d(cursor.getInt(0), e.e.b.a.i.y.a.c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    static /* synthetic */ Object Q(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    private /* synthetic */ Object R0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        t1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: e.e.b.a.i.b0.j.v
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                this.a.Q0((Cursor) obj);
                return null;
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    static /* synthetic */ SQLiteDatabase T(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    static /* synthetic */ Long W(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    static /* synthetic */ Object X0(String str, e.e.b.a.i.y.a.c.b bVar, long j2, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) t1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.f())}), new b() { // from class: e.e.b.a.i.b0.j.y
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.f())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.f()));
            contentValues.put("events_dropped_count", Long.valueOf(j2));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    static /* synthetic */ e.e.b.a.i.y.a.f Y(long j2, Cursor cursor) {
        cursor.moveToNext();
        return e.e.b.a.i.y.a.f.c().c(cursor.getLong(0)).b(j2).a();
    }

    static /* synthetic */ e.e.b.a.i.y.a.f Z(final long j2, SQLiteDatabase sQLiteDatabase) {
        return (e.e.b.a.i.y.a.f) t1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: e.e.b.a.i.b0.j.c
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.Y(j2, (Cursor) obj);
            }
        });
    }

    static /* synthetic */ Object Z0(long j2, e.e.b.a.i.q qVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{qVar.b(), String.valueOf(e.e.b.a.i.d0.a.a(qVar.d()))}) < 1) {
            contentValues.put("backend_name", qVar.b());
            contentValues.put("priority", Integer.valueOf(e.e.b.a.i.d0.a.a(qVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    static /* synthetic */ Long a0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    private /* synthetic */ Object a1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f20787h.a()).execute();
        return null;
    }

    private e.e.b.a.i.y.a.c.b e(int i2) {
        e.e.b.a.i.y.a.c.b bVar = e.e.b.a.i.y.a.c.b.REASON_UNKNOWN;
        if (i2 == bVar.f()) {
            return bVar;
        }
        e.e.b.a.i.y.a.c.b bVar2 = e.e.b.a.i.y.a.c.b.MESSAGE_TOO_OLD;
        if (i2 == bVar2.f()) {
            return bVar2;
        }
        e.e.b.a.i.y.a.c.b bVar3 = e.e.b.a.i.y.a.c.b.CACHE_FULL;
        if (i2 == bVar3.f()) {
            return bVar3;
        }
        e.e.b.a.i.y.a.c.b bVar4 = e.e.b.a.i.y.a.c.b.PAYLOAD_TOO_BIG;
        if (i2 == bVar4.f()) {
            return bVar4;
        }
        e.e.b.a.i.y.a.c.b bVar5 = e.e.b.a.i.y.a.c.b.MAX_RETRIES_REACHED;
        if (i2 == bVar5.f()) {
            return bVar5;
        }
        e.e.b.a.i.y.a.c.b bVar6 = e.e.b.a.i.y.a.c.b.INVALID_PAYLOD;
        if (i2 == bVar6.f()) {
            return bVar6;
        }
        e.e.b.a.i.y.a.c.b bVar7 = e.e.b.a.i.y.a.c.b.SERVER_ERROR;
        if (i2 == bVar7.f()) {
            return bVar7;
        }
        e.e.b.a.i.z.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i2));
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean f0(e.e.b.a.i.q qVar, SQLiteDatabase sQLiteDatabase) {
        Long lZ = z(sQLiteDatabase, qVar);
        return lZ == null ? Boolean.FALSE : (Boolean) t1(l().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lZ.toString()}), new b() { // from class: e.e.b.a.i.b0.j.e0
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    private void f(final SQLiteDatabase sQLiteDatabase) {
        q1(new d() { // from class: e.e.b.a.i.b0.j.e
            @Override // e.e.b.a.i.b0.j.r0.d
            public final Object a() {
                r0.N(sQLiteDatabase);
                return null;
            }
        }, new b() { // from class: e.e.b.a.i.b0.j.b
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                r0.Q((Throwable) obj);
                throw null;
            }
        });
    }

    private List<q0> f1(SQLiteDatabase sQLiteDatabase, final e.e.b.a.i.q qVar, int i2) {
        final ArrayList arrayList = new ArrayList();
        Long lZ = z(sQLiteDatabase, qVar);
        if (lZ == null) {
            return arrayList;
        }
        t1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lZ.toString()}, null, null, null, String.valueOf(i2)), new b() { // from class: e.e.b.a.i.b0.j.o
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                this.a.F0(arrayList, qVar, (Cursor) obj);
                return null;
            }
        });
        return arrayList;
    }

    private Map<Long, Set<c>> h1(SQLiteDatabase sQLiteDatabase, List<q0> list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).c());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        t1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: e.e.b.a.i.b0.j.t
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                r0.G0(map, (Cursor) obj);
                return null;
            }
        });
        return map;
    }

    static /* synthetic */ List i0(SQLiteDatabase sQLiteDatabase) {
        return (List) t1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: e.e.b.a.i.b0.j.h
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.m0((Cursor) obj);
            }
        });
    }

    private long j(SQLiteDatabase sQLiteDatabase, e.e.b.a.i.q qVar) {
        Long lZ = z(sQLiteDatabase, qVar);
        if (lZ != null) {
            return lZ.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", qVar.b());
        contentValues.put("priority", Integer.valueOf(e.e.b.a.i.d0.a.a(qVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (qVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(qVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private static byte[] k1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void l1(e.e.b.a.i.y.a.a.C0257a c0257a, Map<String, List<e.e.b.a.i.y.a.c>> map) {
        for (Map.Entry<String, List<e.e.b.a.i.y.a.c>> entry : map.entrySet()) {
            c0257a.a(e.e.b.a.i.y.a.d.c().c(entry.getKey()).b(entry.getValue()).a());
        }
    }

    private e.e.b.a.i.y.a.b m() {
        return e.e.b.a.i.y.a.b.b().b(e.e.b.a.i.y.a.e.c().b(k()).c(k0.a.f()).a()).a();
    }

    static /* synthetic */ List m0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(e.e.b.a.i.q.a().b(cursor.getString(1)).d(e.e.b.a.i.d0.a.b(cursor.getInt(2))).c(k1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List p0(e.e.b.a.i.q qVar, SQLiteDatabase sQLiteDatabase) {
        List<q0> listF1 = f1(sQLiteDatabase, qVar, this.f20789j.d());
        for (e.e.b.a.d dVar : e.e.b.a.d.values()) {
            if (dVar != qVar.d()) {
                int iD = this.f20789j.d() - listF1.size();
                if (iD <= 0) {
                    break;
                }
                listF1.addAll(f1(sQLiteDatabase, qVar.f(dVar), iD));
            }
        }
        return D(listF1, h1(sQLiteDatabase, listF1));
    }

    private byte[] n1(long j2) {
        return (byte[]) t1(l().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num"), new b() { // from class: e.e.b.a.i.b0.j.g
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.M0((Cursor) obj);
            }
        });
    }

    private long p() {
        return l().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ e.e.b.a.i.y.a.a t0(Map map, e.e.b.a.i.y.a.a.C0257a c0257a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            e.e.b.a.i.y.a.c.b bVarE = e(cursor.getInt(1));
            long j2 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(e.e.b.a.i.y.a.c.c().c(bVarE).b(j2).a());
        }
        l1(c0257a, map);
        c0257a.e(y());
        c0257a.d(m());
        c0257a.c(this.f20790k.get());
        return c0257a.b();
    }

    private <T> T q1(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.f20788i.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f20788i.a() >= ((long) this.f20789j.b()) + jA) {
                    return bVar.a(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static e.e.b.a.b r1(String str) {
        return str == null ? f20785f : e.e.b.a.b.b(str);
    }

    private static String s1(Iterable<q0> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<q0> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static <T> T t1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    private long x() {
        return l().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ e.e.b.a.i.y.a.a y0(String str, final Map map, final e.e.b.a.i.y.a.a.C0257a c0257a, SQLiteDatabase sQLiteDatabase) {
        return (e.e.b.a.i.y.a.a) t1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: e.e.b.a.i.b0.j.u
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.t0(map, c0257a, (Cursor) obj);
            }
        });
    }

    private e.e.b.a.i.y.a.f y() {
        final long jA = this.f20787h.a();
        return (e.e.b.a.i.y.a.f) A(new b() { // from class: e.e.b.a.i.b0.j.l
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.Z(jA, (SQLiteDatabase) obj);
            }
        });
    }

    private Long z(SQLiteDatabase sQLiteDatabase, e.e.b.a.i.q qVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(qVar.b(), String.valueOf(e.e.b.a.i.d0.a.a(qVar.d()))));
        if (qVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(qVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) t1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: e.e.b.a.i.b0.j.q
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.a0((Cursor) obj);
            }
        });
    }

    <T> T A(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            T tA = bVar.a(sQLiteDatabaseL);
            sQLiteDatabaseL.setTransactionSuccessful();
            return tA;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    public /* synthetic */ Object F0(List list, e.e.b.a.i.q qVar, Cursor cursor) {
        E0(list, qVar, cursor);
        return null;
    }

    @Override // e.e.b.a.i.b0.j.j0
    public Iterable<q0> G(final e.e.b.a.i.q qVar) {
        return (Iterable) A(new b() { // from class: e.e.b.a.i.b0.j.d
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.p0(qVar, (SQLiteDatabase) obj);
            }
        });
    }

    public /* synthetic */ Object I(Cursor cursor) {
        H(cursor);
        return null;
    }

    @Override // e.e.b.a.i.b0.j.j0
    public void O(final e.e.b.a.i.q qVar, final long j2) {
        A(new b() { // from class: e.e.b.a.i.b0.j.f
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                r0.Z0(j2, qVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    public /* synthetic */ Object Q0(Cursor cursor) {
        N0(cursor);
        return null;
    }

    @Override // e.e.b.a.i.b0.j.j0
    public q0 S0(final e.e.b.a.i.q qVar, final e.e.b.a.i.j jVar) {
        e.e.b.a.i.z.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", qVar.d(), jVar.j(), qVar.b());
        long jLongValue = ((Long) A(new b() { // from class: e.e.b.a.i.b0.j.s
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.K0(jVar, qVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return q0.a(jLongValue, qVar, jVar);
    }

    public /* synthetic */ Object T0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        R0(str, str2, sQLiteDatabase);
        return null;
    }

    @Override // e.e.b.a.i.b0.j.j0
    public Iterable<e.e.b.a.i.q> U() {
        return (Iterable) A(new b() { // from class: e.e.b.a.i.b0.j.x
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.i0((SQLiteDatabase) obj);
            }
        });
    }

    @Override // e.e.b.a.i.b0.j.j0
    public long W0(e.e.b.a.i.q qVar) {
        return ((Long) t1(l().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{qVar.b(), String.valueOf(e.e.b.a.i.d0.a.a(qVar.d()))}), new b() { // from class: e.e.b.a.i.b0.j.m
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return r0.W((Cursor) obj);
            }
        })).longValue();
    }

    @Override // e.e.b.a.i.b0.j.i0
    public void a() {
        A(new b() { // from class: e.e.b.a.i.b0.j.p
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                this.a.c1((SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a
    public <T> T b(com.google.android.datatransport.runtime.synchronization.a.InterfaceC0172a<T> interfaceC0172a) {
        SQLiteDatabase sQLiteDatabaseL = l();
        f(sQLiteDatabaseL);
        try {
            T tExecute = interfaceC0172a.execute();
            sQLiteDatabaseL.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    @Override // e.e.b.a.i.b0.j.j0
    public boolean b1(final e.e.b.a.i.q qVar) {
        return ((Boolean) A(new b() { // from class: e.e.b.a.i.b0.j.k
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.f0(qVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // e.e.b.a.i.b0.j.i0
    public e.e.b.a.i.y.a.a c() {
        final e.e.b.a.i.y.a.a.C0257a c0257aE = e.e.b.a.i.y.a.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (e.e.b.a.i.y.a.a) A(new b() { // from class: e.e.b.a.i.b0.j.n
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.y0(str, map, c0257aE, (SQLiteDatabase) obj);
            }
        });
    }

    public /* synthetic */ Object c1(SQLiteDatabase sQLiteDatabase) {
        a1(sQLiteDatabase);
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f20786g.close();
    }

    @Override // e.e.b.a.i.b0.j.i0
    public void d(final long j2, final e.e.b.a.i.y.a.c.b bVar, final String str) {
        A(new b() { // from class: e.e.b.a.i.b0.j.i
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                r0.X0(str, bVar, j2, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // e.e.b.a.i.b0.j.j0
    public void e1(Iterable<q0> iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + s1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            A(new b() { // from class: e.e.b.a.i.b0.j.r
                @Override // e.e.b.a.i.b0.j.r0.b
                public final Object a(Object obj) {
                    this.a.T0(str, str2, (SQLiteDatabase) obj);
                    return null;
                }
            });
        }
    }

    long k() {
        return p() * x();
    }

    SQLiteDatabase l() {
        final t0 t0Var = this.f20786g;
        t0Var.getClass();
        return (SQLiteDatabase) q1(new d() { // from class: e.e.b.a.i.b0.j.f0
            @Override // e.e.b.a.i.b0.j.r0.d
            public final Object a() {
                return t0Var.getWritableDatabase();
            }
        }, new b() { // from class: e.e.b.a.i.b0.j.a
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                r0.T((Throwable) obj);
                throw null;
            }
        });
    }

    @Override // e.e.b.a.i.b0.j.j0
    public int o() {
        final long jA = this.f20787h.a() - this.f20789j.c();
        return ((Integer) A(new b() { // from class: e.e.b.a.i.b0.j.w
            @Override // e.e.b.a.i.b0.j.r0.b
            public final Object a(Object obj) {
                return this.a.K(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // e.e.b.a.i.b0.j.j0
    public void q(Iterable<q0> iterable) {
        if (iterable.iterator().hasNext()) {
            l().compileStatement("DELETE FROM events WHERE _id in " + s1(iterable)).execute();
        }
    }
}
