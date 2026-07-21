package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzky;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c extends f7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f17712d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f17713e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f17714f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f17715g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f17716h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f17717i = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f17718j = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f17719k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final d l;
    private final c7 m;

    c(zzkc zzkcVar) {
        super(zzkcVar);
        this.m = new c7(j());
        this.l = new d(this, f(), "google_app_measurement.db");
    }

    private final long A(String str, String[] strArr, long j2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = x().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j2;
                }
                long j3 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j3;
            } catch (SQLiteException e2) {
                h().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final Object F(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            h().H().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            h().H().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        h().H().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    private static void M(ContentValues contentValues, String str, Object obj) {
        Preconditions.g(str);
        Preconditions.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    private final boolean V(String str, int i2, zzbj.zzb zzbVar) {
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(zzbVar);
        if (TextUtils.isEmpty(zzbVar.I())) {
            h().K().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzet.x(str), Integer.valueOf(i2), String.valueOf(zzbVar.G() ? Integer.valueOf(zzbVar.H()) : null));
            return false;
        }
        byte[] bArrJ = zzbVar.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzbVar.G() ? Integer.valueOf(zzbVar.H()) : null);
        contentValues.put("event_name", zzbVar.I());
        if (n().B(str, zzap.w0)) {
            contentValues.put("session_scoped", zzbVar.P() ? Boolean.valueOf(zzbVar.Q()) : null);
        }
        contentValues.put("data", bArrJ);
        try {
            if (x().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert event filter (got -1). appId", zzet.x(str));
            return true;
        } catch (SQLiteException e2) {
            h().H().c("Error storing event filter. appId", zzet.x(str), e2);
            return false;
        }
    }

    private final boolean W(String str, int i2, zzbj.zze zzeVar) {
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(zzeVar);
        if (TextUtils.isEmpty(zzeVar.F())) {
            h().K().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzet.x(str), Integer.valueOf(i2), String.valueOf(zzeVar.D() ? Integer.valueOf(zzeVar.E()) : null));
            return false;
        }
        byte[] bArrJ = zzeVar.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzeVar.D() ? Integer.valueOf(zzeVar.E()) : null);
        contentValues.put("property_name", zzeVar.F());
        if (n().B(str, zzap.w0)) {
            contentValues.put("session_scoped", zzeVar.J() ? Boolean.valueOf(zzeVar.K()) : null);
        }
        contentValues.put("data", bArrJ);
        try {
            if (x().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert property filter (got -1). appId", zzet.x(str));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing property filter. appId", zzet.x(str), e2);
            return false;
        }
    }

    private final boolean h0() {
        return f().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long i0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = x().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                h().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean p0(String str, List<Integer> list) {
        Preconditions.g(str);
        t();
        d();
        SQLiteDatabase sQLiteDatabaseX = x();
        try {
            long jI0 = i0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, n().t(str, zzap.M)));
            if (jI0 <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 140);
            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(string);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseX.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e2) {
            h().H().c("Database error querying filters. appId", zzet.x(str), e2);
            return false;
        }
    }

    public final void A0() {
        t();
        x().endTransaction();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x008e  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    public final Pair<zzbr.zzc, Long> B(String str, Long l) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        d();
        t();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = x().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        h().P().a("Main event not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        Pair<zzbr.zzc, Long> pairCreate = Pair.create((zzbr.zzc) ((zzfd) ((zzbr.zzc.zza) zzkg.A(zzbr.zzc.c0(), cursorRawQuery.getBlob(0))).y()), Long.valueOf(cursorRawQuery.getLong(1)));
                        cursorRawQuery.close();
                        return pairCreate;
                    } catch (IOException e2) {
                        h().H().d("Failed to merge main event. appId, eventId", zzet.x(str), l, e2);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().b("Error selecting main event", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean B0() {
        return i0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0126  */
    public final zzab C(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        Preconditions.g(str);
        d();
        t();
        String[] strArr = {str};
        zzab zzabVar = new zzab();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseX = x();
                cursorQuery = sQLiteDatabaseX.query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        h().K().b("Not updating daily counts, app is not known. appId", zzet.x(str));
                        cursorQuery.close();
                        return zzabVar;
                    }
                    if (cursorQuery.getLong(0) == j2) {
                        zzabVar.f18051b = cursorQuery.getLong(1);
                        zzabVar.a = cursorQuery.getLong(2);
                        zzabVar.f18052c = cursorQuery.getLong(3);
                        zzabVar.f18053d = cursorQuery.getLong(4);
                        zzabVar.f18054e = cursorQuery.getLong(5);
                    }
                    if (z) {
                        zzabVar.f18051b++;
                    }
                    if (z2) {
                        zzabVar.a++;
                    }
                    if (z3) {
                        zzabVar.f18052c++;
                    }
                    if (z4) {
                        zzabVar.f18053d++;
                    }
                    if (z5) {
                        zzabVar.f18054e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j2));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzabVar.a));
                    contentValues.put("daily_events_count", Long.valueOf(zzabVar.f18051b));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzabVar.f18052c));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzabVar.f18053d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzabVar.f18054e));
                    sQLiteDatabaseX.update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, contentValues, "app_id=?", strArr);
                    cursorQuery.close();
                    return zzabVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Error updating daily counts. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzabVar;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final void C0() {
        int iDelete;
        d();
        t();
        if (h0()) {
            long jA = m().f17925i.a();
            long jB = j().b();
            if (Math.abs(jB - jA) > zzap.F.a(null).longValue()) {
                m().f17925i.b(jB);
                d();
                t();
                if (!h0() || (iDelete = x().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(j().a()), String.valueOf(zzx.N())})) <= 0) {
                    return;
                }
                h().P().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:69:0x017a  */
    public final h D(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        boolean zB = n().B(str, zzap.x0);
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (zB) {
            arrayList.add("current_session_count");
        }
        Cursor cursor2 = null;
        try {
            cursorQuery = x().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                long j2 = cursorQuery.getLong(0);
                long j3 = cursorQuery.getLong(1);
                long j4 = cursorQuery.getLong(2);
                long j5 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                if (cursorQuery.isNull(7)) {
                    boolValueOf = null;
                } else {
                    try {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursorQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                cursor = cursorQuery;
                try {
                    h hVar = new h(str, str2, j2, j3, (!zB || cursorQuery.isNull(8)) ? 0L : cursorQuery.getLong(8), j4, j5, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursor.moveToNext()) {
                        h().H().b("Got multiple records for event aggregates, expected one. appId", zzet.x(str));
                    }
                    cursor.close();
                    return hVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    cursorQuery = cursor;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        h().H().d("Error querying events. appId", zzet.x(str), k().y(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final long D0() {
        return A("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long E0() {
        return A("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean F0() {
        return i0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean G0() {
        return i0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    public final String H(long j2) throws Throwable {
        Cursor cursorRawQuery;
        d();
        t();
        ?? r0 = 0;
        try {
            try {
                cursorRawQuery = x().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf((long) j2)});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        return string;
                    }
                    h().P().a("No expired configs for apps with pending events");
                    cursorRawQuery.close();
                    return null;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().b("Error selecting expired configs", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = j2;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b4  */
    public final List<m7> I(String str) throws Throwable {
        Cursor cursorQuery;
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = x().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = HttpUrl.FRAGMENT_ENCODE_SET;
                        }
                        String str2 = string2;
                        long j2 = cursorQuery.getLong(2);
                        try {
                            Object objF = F(cursorQuery, 3);
                            if (objF == null) {
                                h().H().b("Read invalid user property value, ignoring it. appId", zzet.x(str));
                            } else {
                                arrayList.add(new m7(str, str2, string, j2, objF));
                            }
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return arrayList;
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        h().H().c("Error querying user properties. appId", zzet.x(str), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final List<Pair<zzbr.zzg, Long>> J(String str, int i2, int i3) {
        d();
        t();
        Preconditions.a(i2 > 0);
        Preconditions.a(i3 > 0);
        Preconditions.g(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = x().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!cursorQuery.moveToFirst()) {
                    List<Pair<zzbr.zzg, Long>> listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j2 = cursorQuery.getLong(0);
                    try {
                        byte[] bArrV = p().V(cursorQuery.getBlob(1));
                        if (!arrayList.isEmpty() && bArrV.length + length > i3) {
                            break;
                        }
                        try {
                            zzbr.zzg.zza zzaVar = (zzbr.zzg.zza) zzkg.A(zzbr.zzg.R0(), bArrV);
                            if (!cursorQuery.isNull(2)) {
                                zzaVar.x0(cursorQuery.getInt(2));
                            }
                            length += bArrV.length;
                            arrayList.add(Pair.create((zzbr.zzg) ((zzfd) zzaVar.y()), Long.valueOf(j2)));
                        } catch (IOException e2) {
                            h().H().c("Failed to merge queued bundle. appId", zzet.x(str), e2);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                    } catch (IOException e3) {
                        h().H().c("Failed to unzip queued bundle. appId", zzet.x(str), e3);
                    }
                } while (length <= i3);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e4) {
                h().H().c("Error querying bundles. appId", zzet.x(str), e4);
                List<Pair<zzbr.zzg, Long>> listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x013d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0145  */
    public final List<m7> K(String str, String str2, String str3) throws Throwable {
        String str4;
        Cursor cursorQuery;
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                try {
                    int i2 = 3;
                    ArrayList arrayList2 = new ArrayList(3);
                    try {
                        arrayList2.add(str);
                        StringBuilder sb = new StringBuilder("app_id=?");
                        if (TextUtils.isEmpty(str2)) {
                            str4 = str2;
                        } else {
                            str4 = str2;
                            try {
                                arrayList2.add(str4);
                                sb.append(" and origin=?");
                            } catch (SQLiteException e2) {
                                e = e2;
                                cursorQuery = null;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            arrayList2.add(String.valueOf(str3).concat("*"));
                            sb.append(" and name glob ?");
                        }
                        int i3 = 0;
                        int i4 = 1;
                        int i5 = 2;
                        cursorQuery = x().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
                        try {
                            if (!cursorQuery.moveToFirst()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            while (arrayList.size() < 1000) {
                                String string = cursorQuery.getString(i3);
                                long j2 = cursorQuery.getLong(i4);
                                try {
                                    Object objF = F(cursorQuery, i5);
                                    String string2 = cursorQuery.getString(i2);
                                    if (objF == null) {
                                        try {
                                            h().H().d("(2)Read invalid user property value, ignoring it", zzet.x(str), string2, str3);
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            str4 = string2;
                                        }
                                    } else {
                                        try {
                                            arrayList.add(new m7(str, string2, string, j2, objF));
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                            string2 = string2;
                                            str4 = string2;
                                            h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            return null;
                                        }
                                    }
                                    try {
                                        if (!cursorQuery.moveToNext()) {
                                            cursorQuery.close();
                                            return arrayList;
                                        }
                                        str4 = string2;
                                        i2 = 3;
                                        i4 = 1;
                                        i5 = 2;
                                        i3 = 0;
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                        str4 = string2;
                                        h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return null;
                                    }
                                } catch (SQLiteException e6) {
                                    e = e6;
                                }
                            }
                            h().H().b("Read more than the max allowed user properties, ignoring excess", 1000);
                            cursorQuery.close();
                            return arrayList;
                        } catch (SQLiteException e7) {
                            e = e7;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e8) {
                        e = e8;
                        str4 = str2;
                        cursorQuery = null;
                        h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e9) {
                e = e9;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x016d  */
    public final List<zzv> L(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        d();
        t();
        ArrayList arrayList = new ArrayList();
        try {
            int i2 = 0;
            int i3 = 5;
            Cursor cursorQuery = x().query("conditional_properties", new String[]{RateAndReviewsFragment.BundleCons.APP_ID, "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (arrayList.size() < 1000) {
                    String string = cursorQuery.getString(i2);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objF = F(cursorQuery, 3);
                    boolean z = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(i3);
                    long j2 = cursorQuery.getLong(6);
                    zzkg zzkgVarP = p();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzan> creator = zzan.CREATOR;
                    arrayList.add(new zzv(string, string2, new zzkj(string3, cursorQuery.getLong(10), objF, string2), cursorQuery.getLong(8), z, string4, (zzan) zzkgVarP.y(blob, creator), j2, (zzan) p().y(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (zzan) p().y(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    i3 = 5;
                    i2 = 0;
                }
                h().H().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    h().H().b("Error querying conditional user property value", e);
                    List<zzv> listEmptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return listEmptyList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final void N(h hVar) {
        Preconditions.k(hVar);
        d();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, hVar.a);
        contentValues.put("name", hVar.f17784b);
        contentValues.put("lifetime_count", Long.valueOf(hVar.f17785c));
        contentValues.put("current_bundle_count", Long.valueOf(hVar.f17786d));
        contentValues.put("last_fire_timestamp", Long.valueOf(hVar.f17788f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(hVar.f17789g));
        contentValues.put("last_bundled_day", hVar.f17790h);
        contentValues.put("last_sampled_complex_event_id", hVar.f17791i);
        contentValues.put("last_sampling_rate", hVar.f17792j);
        if (n().B(hVar.a, zzap.x0)) {
            contentValues.put("current_session_count", Long.valueOf(hVar.f17787e));
        }
        Boolean bool = hVar.f17793k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (x().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update event aggregates (got -1). appId", zzet.x(hVar.a));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing event aggregates. appId", zzet.x(hVar.a), e2);
        }
    }

    public final void O(z3 z3Var) {
        Preconditions.k(z3Var);
        d();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, z3Var.t());
        contentValues.put("app_instance_id", z3Var.x());
        contentValues.put("gmp_app_id", z3Var.A());
        contentValues.put("resettable_device_id_hash", z3Var.J());
        contentValues.put("last_bundle_index", Long.valueOf(z3Var.f0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(z3Var.P()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(z3Var.R()));
        contentValues.put("app_version", z3Var.T());
        contentValues.put("app_store", z3Var.X());
        contentValues.put("gmp_version", Long.valueOf(z3Var.Z()));
        contentValues.put("dev_cert_hash", Long.valueOf(z3Var.b0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(z3Var.e0()));
        contentValues.put("day", Long.valueOf(z3Var.j0()));
        contentValues.put("daily_public_events_count", Long.valueOf(z3Var.k0()));
        contentValues.put("daily_events_count", Long.valueOf(z3Var.l0()));
        contentValues.put("daily_conversions_count", Long.valueOf(z3Var.m0()));
        contentValues.put("config_fetched_time", Long.valueOf(z3Var.g0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(z3Var.h0()));
        contentValues.put("app_version_int", Long.valueOf(z3Var.V()));
        contentValues.put("firebase_instance_id", z3Var.M());
        contentValues.put("daily_error_events_count", Long.valueOf(z3Var.h()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(z3Var.g()));
        contentValues.put("health_monitor_sample", z3Var.i());
        contentValues.put("android_id", Long.valueOf(z3Var.k()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(z3Var.l()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(z3Var.m()));
        contentValues.put("admob_app_id", z3Var.D());
        contentValues.put("dynamite_version", Long.valueOf(z3Var.d0()));
        if (z3Var.o() != null) {
            if (z3Var.o().size() == 0) {
                h().K().b("Safelisted events should not be an empty list. appId", z3Var.t());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", z3Var.o()));
            }
        }
        if (zzky.b() && n().B(z3Var.t(), zzap.N0)) {
            contentValues.put("ga_app_id", z3Var.G());
        }
        try {
            SQLiteDatabase sQLiteDatabaseX = x();
            if (sQLiteDatabaseX.update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, contentValues, "app_id = ?", new String[]{z3Var.t()}) == 0 && sQLiteDatabaseX.insertWithOnConflict(DeepLinkIntentReceiver.DeepLinksTargets.APPS, null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update app (got -1). appId", zzet.x(z3Var.t()));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing app. appId", zzet.x(z3Var.t()), e2);
        }
    }

    final void P(String str, List<zzbj.zza> list) {
        boolean z;
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(list);
        SQLiteDatabase sQLiteDatabaseX = x();
        sQLiteDatabaseX.beginTransaction();
        try {
            t();
            d();
            Preconditions.g(str);
            SQLiteDatabase sQLiteDatabaseX2 = x();
            sQLiteDatabaseX2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseX2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbj.zza zzaVar : list) {
                t();
                d();
                Preconditions.g(str);
                Preconditions.k(zzaVar);
                if (zzaVar.G()) {
                    int iH = zzaVar.H();
                    Iterator<zzbj.zzb> it = zzaVar.L().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().G()) {
                                h().K().c("Event filter with no ID. Audience definition ignored. appId, audienceId", zzet.x(str), Integer.valueOf(iH));
                                break;
                            }
                        } else {
                            Iterator<zzbj.zze> it2 = zzaVar.J().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Iterator<zzbj.zzb> it3 = zzaVar.L().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!V(str, iH, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbj.zze> it4 = zzaVar.J().iterator();
                                        while (it4.hasNext()) {
                                            if (!W(str, iH, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        t();
                                        d();
                                        Preconditions.g(str);
                                        SQLiteDatabase sQLiteDatabaseX3 = x();
                                        sQLiteDatabaseX3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iH)});
                                        sQLiteDatabaseX3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iH)});
                                        break;
                                    }
                                    break;
                                }
                                if (!it2.next().D()) {
                                    h().K().c("Property filter with no ID. Audience definition ignored. appId, audienceId", zzet.x(str), Integer.valueOf(iH));
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    h().K().b("Audience with no ID. appId", zzet.x(str));
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbj.zza zzaVar2 : list) {
                arrayList.add(zzaVar2.G() ? Integer.valueOf(zzaVar2.H()) : null);
            }
            p0(str, arrayList);
            sQLiteDatabaseX.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseX.endTransaction();
        }
    }

    @VisibleForTesting
    final void Q(List<Long> list) {
        d();
        t();
        Preconditions.k(list);
        Preconditions.m(list.size());
        if (h0()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (i0(sb2.toString(), null) > 0) {
                h().K().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseX = x();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseX.execSQL(sb3.toString());
            } catch (SQLiteException e2) {
                h().H().b("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean R(zzbr.zzg zzgVar, boolean z) {
        d();
        t();
        Preconditions.k(zzgVar);
        Preconditions.g(zzgVar.L2());
        Preconditions.n(zzgVar.o2());
        C0();
        long jA = j().a();
        if (zzgVar.p2() < jA - zzx.N() || zzgVar.p2() > zzx.N() + jA) {
            h().K().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzet.x(zzgVar.L2()), Long.valueOf(jA), Long.valueOf(zzgVar.p2()));
        }
        try {
            byte[] bArrW = p().W(zzgVar.j());
            h().P().b("Saving bundle, size", Integer.valueOf(bArrW.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzgVar.L2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.p2()));
            contentValues.put("data", bArrW);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.A0()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.N0()));
            }
            try {
                if (x().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                h().H().b("Failed to insert bundle (got -1). appId", zzet.x(zzgVar.L2()));
                return false;
            } catch (SQLiteException e2) {
                h().H().c("Error storing bundle. appId", zzet.x(zzgVar.L2()), e2);
                return false;
            }
        } catch (IOException e3) {
            h().H().c("Data loss. Failed to serialize bundle. appId", zzet.x(zzgVar.L2()), e3);
            return false;
        }
    }

    public final boolean S(zzak zzakVar, long j2, boolean z) {
        d();
        t();
        Preconditions.k(zzakVar);
        Preconditions.g(zzakVar.a);
        zzbr.zzc.zza zzaVarJ = zzbr.zzc.c0().J(zzakVar.f18064e);
        for (String str : zzakVar.f18065f) {
            zzbr.zze.zza zzaVarC = zzbr.zze.T().C(str);
            p().J(zzaVarC, zzakVar.f18065f.W(str));
            zzaVarJ.C(zzaVarC);
        }
        byte[] bArrJ = ((zzbr.zzc) ((zzfd) zzaVarJ.y())).j();
        h().P().c("Saving event, name, data size", k().y(zzakVar.f18061b), Integer.valueOf(bArrJ.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzakVar.a);
        contentValues.put("name", zzakVar.f18061b);
        contentValues.put("timestamp", Long.valueOf(zzakVar.f18063d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", bArrJ);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (x().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            h().H().b("Failed to insert raw event (got -1). appId", zzet.x(zzakVar.a));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing raw event. appId", zzet.x(zzakVar.a), e2);
            return false;
        }
    }

    public final boolean T(m7 m7Var) {
        Preconditions.k(m7Var);
        d();
        t();
        if (o0(m7Var.a, m7Var.f17873c) == null) {
            if (zzkk.Y(m7Var.f17873c)) {
                if (i0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{m7Var.a}) >= 25) {
                    return false;
                }
            } else if (n().B(m7Var.a, zzap.k0)) {
                if (!"_npa".equals(m7Var.f17873c) && i0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{m7Var.a, m7Var.f17872b}) >= 25) {
                    return false;
                }
            } else if (i0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{m7Var.a, m7Var.f17872b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, m7Var.a);
        contentValues.put("origin", m7Var.f17872b);
        contentValues.put("name", m7Var.f17873c);
        contentValues.put("set_timestamp", Long.valueOf(m7Var.f17874d));
        M(contentValues, "value", m7Var.f17875e);
        try {
            if (x().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update user property (got -1). appId", zzet.x(m7Var.a));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing user property. appId", zzet.x(m7Var.a), e2);
        }
        return true;
    }

    public final boolean U(zzv zzvVar) {
        Preconditions.k(zzvVar);
        d();
        t();
        if (o0(zzvVar.f18240f, zzvVar.f18242h.f18224g) == null && i0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzvVar.f18240f}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzvVar.f18240f);
        contentValues.put("origin", zzvVar.f18241g);
        contentValues.put("name", zzvVar.f18242h.f18224g);
        M(contentValues, "value", zzvVar.f18242h.y());
        contentValues.put("active", Boolean.valueOf(zzvVar.f18244j));
        contentValues.put("trigger_event_name", zzvVar.f18245k);
        contentValues.put("trigger_timeout", Long.valueOf(zzvVar.m));
        l();
        contentValues.put("timed_out_event", zzkk.g0(zzvVar.l));
        contentValues.put("creation_timestamp", Long.valueOf(zzvVar.f18243i));
        l();
        contentValues.put("triggered_event", zzkk.g0(zzvVar.n));
        contentValues.put("triggered_timestamp", Long.valueOf(zzvVar.f18242h.f18225h));
        contentValues.put("time_to_live", Long.valueOf(zzvVar.o));
        l();
        contentValues.put("expired_event", zzkk.g0(zzvVar.p));
        try {
            if (x().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update conditional user property (got -1)", zzet.x(zzvVar.f18240f));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing conditional user property", zzet.x(zzvVar.f18240f), e2);
        }
        return true;
    }

    public final boolean X(String str, Long l, long j2, zzbr.zzc zzcVar) {
        d();
        t();
        Preconditions.k(zzcVar);
        Preconditions.g(str);
        Preconditions.k(l);
        byte[] bArrJ = zzcVar.j();
        h().P().c("Saving complex main event, appId, data size", k().y(str), Integer.valueOf(bArrJ.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", bArrJ);
        try {
            if (x().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert complex main event (got -1). appId", zzet.x(str));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing complex main event. appId", zzet.x(str), e2);
            return false;
        }
    }

    public final long Y() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = x().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j2 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j2;
            } catch (SQLiteException e2) {
                h().H().b("Error querying raw events", e2);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0294  */
    public final z3 j0(String str) {
        Cursor cursorQuery;
        Preconditions.g(str);
        d();
        t();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = x().query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    try {
                        z3 z3Var = new z3(this.f17811b.g0(), str);
                        z3Var.c(cursorQuery.getString(0));
                        z3Var.r(cursorQuery.getString(1));
                        z3Var.C(cursorQuery.getString(2));
                        z3Var.H(cursorQuery.getLong(3));
                        z3Var.a(cursorQuery.getLong(4));
                        z3Var.q(cursorQuery.getLong(5));
                        z3Var.I(cursorQuery.getString(6));
                        z3Var.L(cursorQuery.getString(7));
                        z3Var.y(cursorQuery.getLong(8));
                        z3Var.B(cursorQuery.getLong(9));
                        z3Var.e(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                        z3Var.Q(cursorQuery.getLong(11));
                        z3Var.S(cursorQuery.getLong(12));
                        z3Var.U(cursorQuery.getLong(13));
                        z3Var.W(cursorQuery.getLong(14));
                        z3Var.K(cursorQuery.getLong(15));
                        z3Var.N(cursorQuery.getLong(16));
                        z3Var.u(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                        z3Var.F(cursorQuery.getString(18));
                        z3Var.a0(cursorQuery.getLong(19));
                        z3Var.Y(cursorQuery.getLong(20));
                        z3Var.O(cursorQuery.getString(21));
                        z3Var.c0(cursorQuery.isNull(22) ? 0L : cursorQuery.getLong(22));
                        z3Var.s(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                        z3Var.w(cursorQuery.isNull(24) || cursorQuery.getInt(24) != 0);
                        z3Var.v(cursorQuery.getString(25));
                        z3Var.E(cursorQuery.isNull(26) ? 0L : cursorQuery.getLong(26));
                        if (!cursorQuery.isNull(27)) {
                            z3Var.d(Arrays.asList(cursorQuery.getString(27).split(",", -1)));
                        }
                        if (zzky.b() && n().B(str, zzap.N0)) {
                            z3Var.z(cursorQuery.getString(28));
                        }
                        z3Var.p();
                        if (cursorQuery.moveToNext()) {
                            h().H().b("Got multiple records for app, expected one. appId", zzet.x(str));
                        }
                        cursorQuery.close();
                        return z3Var;
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        h().H().c("Error querying app. appId", zzet.x(str), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final List<zzv> k0(String str, String str2, String str3) {
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return L(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    final Map<Integer, List<Integer>> l0(String str, List<String> list) throws Throwable {
        Cursor cursorQuery;
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(list);
        c.e.a aVar = new c.e.a();
        if (list.isEmpty()) {
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=? AND property_name in (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        sb.append(")");
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, str);
        Cursor cursor = null;
        try {
            cursorQuery = x().query("property_filters", new String[]{"audience_id", "filter_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return aVar;
                    }
                    do {
                        int i3 = cursorQuery.getInt(0);
                        List arrayList2 = (List) aVar.get(Integer.valueOf(i3));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            aVar.put(Integer.valueOf(i3), arrayList2);
                        }
                        arrayList2.add(Integer.valueOf(cursorQuery.getInt(1)));
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return aVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public final void m0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        try {
            h().P().b("Deleted user attribute rows", Integer.valueOf(x().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            h().H().d("Error deleting user attribute. appId", zzet.x(str), k().B(str2), e2);
        }
    }

    public final long n0(String str) {
        Preconditions.g(str);
        d();
        t();
        try {
            return x().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, n().t(str, zzap.w))))});
        } catch (SQLiteException e2) {
            h().H().c("Error deleting over the limit events. appId", zzet.x(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    public final m7 o0(String str, String str2) {
        Cursor cursorQuery;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = x().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    try {
                        m7 m7Var = new m7(str, cursorQuery.getString(2), str2, cursorQuery.getLong(0), F(cursorQuery, 1));
                        if (cursorQuery.moveToNext()) {
                            h().H().b("Got multiple records for user property, expected one. appId", zzet.x(str));
                        }
                        cursorQuery.close();
                        return m7Var;
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        h().H().d("Error querying user property. appId", zzet.x(str), k().B(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0146  */
    /* JADX WARN: Code duplicated, block: B:36:0x014e  */
    public final zzv q0(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        Cursor cursor = null;
        try {
            cursorQuery = x().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                String string = cursorQuery.getString(0);
                try {
                    try {
                        Object objF = F(cursorQuery, 1);
                        boolean z = cursorQuery.getInt(2) != 0;
                        String string2 = cursorQuery.getString(3);
                        long j2 = cursorQuery.getLong(4);
                        zzkg zzkgVarP = p();
                        byte[] blob = cursorQuery.getBlob(5);
                        Parcelable.Creator<zzan> creator = zzan.CREATOR;
                        zzv zzvVar = new zzv(str, string, new zzkj(str2, cursorQuery.getLong(8), objF, string), cursorQuery.getLong(6), z, string2, (zzan) zzkgVarP.y(blob, creator), j2, (zzan) p().y(cursorQuery.getBlob(7), creator), cursorQuery.getLong(9), (zzan) p().y(cursorQuery.getBlob(10), creator));
                        if (cursorQuery.moveToNext()) {
                            h().H().c("Got multiple records for conditional property, expected one", zzet.x(str), k().B(str2));
                        }
                        cursorQuery.close();
                        return zzvVar;
                    } catch (SQLiteException e2) {
                        e = e2;
                        h().H().d("Error querying conditional property", zzet.x(str), k().B(str2), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        h().H().d("Error querying conditional property", zzet.x(str), k().B(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0072: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0072 */
    public final byte[] r0(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.g(str);
        d();
        t();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = x().query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    byte[] blob = cursorQuery.getBlob(0);
                    if (cursorQuery.moveToNext()) {
                        h().H().b("Got multiple records for app config, expected one. appId", zzet.x(str));
                    }
                    cursorQuery.close();
                    return blob;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Error querying remote config. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final int s0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        try {
            return x().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            h().H().d("Error deleting conditional property", zzet.x(str), k().B(str2), e2);
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    final Map<Integer, List<Integer>> t0(String str) throws Throwable {
        Cursor cursorRawQuery;
        t();
        d();
        Preconditions.g(str);
        c.e.a aVar = new c.e.a();
        SQLiteDatabase sQLiteDatabaseX = x();
        ?? r2 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseX.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                        cursorRawQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        int i2 = cursorRawQuery.getInt(0);
                        List arrayList = (List) aVar.get(Integer.valueOf(i2));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            aVar.put(Integer.valueOf(i2), arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    return aVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Database error querying scoped filters. appId", zzet.x(str), e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r2 = sQLiteDatabaseX;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    final Map<Integer, zzbr.zzi> u0(String str) throws Throwable {
        Cursor cursorQuery;
        t();
        d();
        Preconditions.g(str);
        SQLiteDatabase sQLiteDatabaseX = x();
        ?? r8 = 0;
        try {
            try {
                cursorQuery = sQLiteDatabaseX.query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    c.e.a aVar = new c.e.a();
                    do {
                        int i2 = cursorQuery.getInt(0);
                        try {
                            aVar.put(Integer.valueOf(i2), (zzbr.zzi) ((zzfd) ((zzbr.zzi.zza) zzkg.A(zzbr.zzi.a0(), cursorQuery.getBlob(1))).y()));
                        } catch (IOException e2) {
                            h().H().d("Failed to merge filter results. appId, audienceId, error", zzet.x(str), Integer.valueOf(i2), e2);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filter results. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r8 = sQLiteDatabaseX;
                if (r8 != 0) {
                    r8.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r8 != 0) {
                r8.close();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    final Map<Integer, List<zzbj.zzb>> v0(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        t();
        d();
        Preconditions.g(str);
        Preconditions.g(str2);
        c.e.a aVar = new c.e.a();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<zzbj.zzb>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            zzbj.zzb zzbVar = (zzbj.zzb) ((zzfd) ((zzbj.zzb.zza) zzkg.A(zzbj.zzb.R(), cursorQuery.getBlob(1))).y());
                            int i2 = cursorQuery.getInt(0);
                            List arrayList = (List) aVar.get(Integer.valueOf(i2));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                aVar.put(Integer.valueOf(i2), arrayList);
                            }
                            arrayList.add(zzbVar);
                        } catch (IOException e2) {
                            h().H().c("Failed to merge filter. appId", zzet.x(str), e2);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
                r9.close();
            }
            throw th;
        }
    }

    public final void w() {
        t();
        x().setTransactionSuccessful();
    }

    public final void w0() {
        t();
        x().beginTransaction();
    }

    @VisibleForTesting
    final SQLiteDatabase x() {
        d();
        try {
            return this.l.getWritableDatabase();
        } catch (SQLiteException e2) {
            h().K().b("Error opening database", e2);
            throw e2;
        }
    }

    public final long x0(String str) {
        Preconditions.g(str);
        return A("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    public final String y() throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        ?? X = x();
        try {
            try {
                cursorRawQuery = X.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().b("Database error getting next bundle app id", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (X != 0) {
                    X.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
            X = 0;
            if (X != 0) {
                X.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    final Map<Integer, List<zzbj.zze>> y0(String str, String str2) throws Throwable {
        Cursor cursorQuery;
        t();
        d();
        Preconditions.g(str);
        Preconditions.g(str2);
        c.e.a aVar = new c.e.a();
        ?? r9 = 0;
        try {
            try {
                cursorQuery = x().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        Map<Integer, List<zzbj.zze>> mapEmptyMap = Collections.emptyMap();
                        cursorQuery.close();
                        return mapEmptyMap;
                    }
                    do {
                        try {
                            zzbj.zze zzeVar = (zzbj.zze) ((zzfd) ((zzbj.zze.zza) zzkg.A(zzbj.zze.L(), cursorQuery.getBlob(1))).y());
                            int i2 = cursorQuery.getInt(0);
                            List arrayList = (List) aVar.get(Integer.valueOf(i2));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                aVar.put(Integer.valueOf(i2), arrayList);
                            }
                            arrayList.add(zzeVar);
                        } catch (IOException e2) {
                            h().H().c("Failed to merge filter", zzet.x(str), e2);
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
                r9.close();
            }
            throw th;
        }
    }

    public final long z(zzbr.zzg zzgVar) throws IOException {
        d();
        t();
        Preconditions.k(zzgVar);
        Preconditions.g(zzgVar.L2());
        byte[] bArrJ = zzgVar.j();
        long jX = p().x(bArrJ);
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzgVar.L2());
        contentValues.put("metadata_fingerprint", Long.valueOf(jX));
        contentValues.put("metadata", bArrJ);
        try {
            x().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jX;
        } catch (SQLiteException e2) {
            h().H().c("Error storing raw event metadata. appId", zzet.x(zzgVar.L2()), e2);
            throw e2;
        }
    }

    @VisibleForTesting
    protected final long z0(String str, String str2) throws Throwable {
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        SQLiteDatabase sQLiteDatabaseX = x();
        sQLiteDatabaseX.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    long jA = A(sb.toString(), new String[]{str}, -1L);
                    if (jA == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (sQLiteDatabaseX.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            h().H().c("Failed to insert column (got -1). appId", zzet.x(str), str2);
                            sQLiteDatabaseX.endTransaction();
                            return -1L;
                        }
                        jA = 0;
                        h().H().d("Error inserting column. appId", zzet.x(str), str2, e);
                        sQLiteDatabaseX.endTransaction();
                        return j2;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                        contentValues2.put(str2, Long.valueOf(1 + jA));
                        if (sQLiteDatabaseX.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                            h().H().c("Failed to update column (got 0). appId", zzet.x(str), str2);
                            sQLiteDatabaseX.endTransaction();
                            return -1L;
                        }
                        sQLiteDatabaseX.setTransactionSuccessful();
                        sQLiteDatabaseX.endTransaction();
                        return jA;
                    } catch (SQLiteException e2) {
                        e = e2;
                        j2 = jA;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabaseX.endTransaction();
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
