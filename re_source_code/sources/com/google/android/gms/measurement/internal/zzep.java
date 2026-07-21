package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzep extends u2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g3 f18091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18092d;

    zzep(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18091c = new g3(this, f(), "google_app_measurement_local.db");
    }

    private static long B(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j2 = cursorQuery.getLong(0);
            cursorQuery.close();
            return j2;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00de A[Catch: all -> 0x00fa, TryCatch #14 {all -> 0x00fa, blocks: (B:54:0x00d8, B:56:0x00de, B:57:0x00e1), top: B:92:0x00d8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:77:0x0124  */
    /* JADX WARN: Code duplicated, block: B:79:0x0129  */
    /* JADX WARN: Code duplicated, block: B:83:0x0135  */
    /* JADX WARN: Code duplicated, block: B:85:0x013a  */
    /* JADX WARN: Code duplicated, block: B:92:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private final boolean D(int i2, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseL;
        ?? RawQuery;
        b();
        d();
        ?? r3 = 0;
        if (this.f18092d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i2));
        contentValues.put("entry", bArr);
        int i3 = 0;
        int i4 = 5;
        for (int i5 = 5; i3 < i5; i5 = 5) {
            ?? r8 = 0;
            r8 = 0;
            r8 = 0;
            r8 = 0;
            r8 = 0;
            ?? r9 = 0;
            r8 = 0;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseL = L();
                try {
                    if (sQLiteDatabaseL == null) {
                        try {
                            this.f18092d = true;
                            if (sQLiteDatabaseL != null) {
                                sQLiteDatabaseL.close();
                            }
                            return r3;
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            try {
                                h().H().b("Error writing entry to local database", e);
                                this.f18092d = true;
                                if (r8 != 0) {
                                    r8.close();
                                }
                                if (sQLiteDatabaseL != null) {
                                    sQLiteDatabaseL.close();
                                }
                                i3++;
                                r3 = 0;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            RawQuery = 0;
                            sQLiteDatabase = sQLiteDatabaseL;
                            RawQuery = RawQuery;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseL = sQLiteDatabase;
                                    r8 = RawQuery;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseL != null) {
                                        sQLiteDatabaseL.close();
                                    }
                                    throw th;
                                }
                            }
                            h().H().b("Error writing entry to local database", e);
                            this.f18092d = true;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            r3 = 0;
                        }
                    } else {
                        try {
                            sQLiteDatabaseL.beginTransaction();
                            long j2 = 0;
                            RawQuery = sQLiteDatabaseL.rawQuery("select count(1) from messages", null);
                            if (RawQuery != 0) {
                                try {
                                    if (RawQuery.moveToFirst()) {
                                        j2 = RawQuery.getLong(r3);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    r9 = RawQuery;
                                    SystemClock.sleep(i4);
                                    i4 += 20;
                                    if (r9 != 0) {
                                        r9.close();
                                    }
                                    if (sQLiteDatabaseL != null) {
                                        sQLiteDatabaseL.close();
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (SQLiteFullException e4) {
                                    e = e4;
                                    r8 = RawQuery;
                                    h().H().b("Error writing entry to local database", e);
                                    this.f18092d = true;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseL != null) {
                                        sQLiteDatabaseL.close();
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    sQLiteDatabase = sQLiteDatabaseL;
                                    RawQuery = RawQuery;
                                    if (sQLiteDatabase != null) {
                                        if (sQLiteDatabase.inTransaction()) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                    }
                                    h().H().b("Error writing entry to local database", e);
                                    this.f18092d = true;
                                    if (RawQuery != 0) {
                                        RawQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i3++;
                                    r3 = 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    r8 = RawQuery;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseL != null) {
                                        sQLiteDatabaseL.close();
                                    }
                                    throw th;
                                }
                            }
                            if (j2 >= 100000) {
                                h().H().a("Data loss, local db full");
                                long j3 = (100000 - j2) + 1;
                                String[] strArr = new String[1];
                                strArr[r3] = Long.toString(j3);
                                long jDelete = sQLiteDatabaseL.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (jDelete != j3) {
                                    h().H().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j3), Long.valueOf(jDelete), Long.valueOf(j3 - jDelete));
                                }
                            }
                            sQLiteDatabaseL.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseL.setTransactionSuccessful();
                            sQLiteDatabaseL.endTransaction();
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            sQLiteDatabaseL.close();
                            return true;
                        } catch (SQLiteFullException e6) {
                            e = e6;
                        } catch (SQLiteException e7) {
                            e = e7;
                            RawQuery = 0;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused2) {
                    r9 = 0;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabaseL = null;
            } catch (SQLiteFullException e8) {
                e = e8;
                sQLiteDatabaseL = null;
            } catch (SQLiteException e9) {
                e = e9;
                RawQuery = 0;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabaseL = null;
            }
            if (r8 != 0) {
                r8.close();
            }
            if (sQLiteDatabaseL != null) {
                sQLiteDatabaseL.close();
            }
            throw th;
        }
        h().K().a("Failed to write entry to local database");
        return false;
    }

    @VisibleForTesting
    private final SQLiteDatabase L() throws SQLiteException {
        if (this.f18092d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f18091c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f18092d = true;
        return null;
    }

    @VisibleForTesting
    private final boolean M() {
        return f().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.u2
    protected final boolean A() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0202 A[Catch: all -> 0x0250, TryCatch #24 {all -> 0x0250, blocks: (B:123:0x01fc, B:125:0x0202, B:126:0x0205, B:133:0x0220, B:141:0x0233), top: B:164:0x01fc }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0214  */
    /* JADX WARN: Code duplicated, block: B:130:0x0219  */
    /* JADX WARN: Code duplicated, block: B:136:0x0227  */
    /* JADX WARN: Code duplicated, block: B:138:0x022c  */
    /* JADX WARN: Code duplicated, block: B:143:0x0242  */
    /* JADX WARN: Code duplicated, block: B:145:0x0247  */
    /* JADX WARN: Code duplicated, block: B:150:0x0254  */
    /* JADX WARN: Code duplicated, block: B:152:0x0259  */
    /* JADX WARN: Code duplicated, block: B:164:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x024a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x024a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x024a A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v16, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r15v7, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r15v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r15v9, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v22, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final List<AbstractSafeParcelable> C(int i2) throws Throwable {
        ?? L;
        ?? Query;
        ?? r10;
        ?? r15;
        ?? r11;
        ?? r16;
        int i3;
        zzkj zzkjVarCreateFromParcel;
        zzv zzvVarCreateFromParcel;
        String str;
        String[] strArr;
        d();
        b();
        ?? r3 = 0;
        if (this.f18092d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!M()) {
            return arrayList;
        }
        int i4 = 0;
        int i5 = 5;
        for (int i6 = 5; i4 < i6; i6 = 5) {
            try {
                L = L();
                try {
                    if (L == 0) {
                        try {
                            this.f18092d = true;
                            if (L != 0) {
                                L.close();
                            }
                            return r3;
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            r10 = r3;
                            r15 = L;
                            h().H().b("Error reading entries from local database", e);
                            this.f18092d = true;
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (r15 != 0) {
                                r15.close();
                            }
                            i4++;
                            r3 = 0;
                        } catch (SQLiteException e3) {
                            e = e3;
                            Query = r3;
                            L = L;
                            if (L != 0) {
                                try {
                                    if (L.inTransaction()) {
                                        L.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r3 = Query;
                                    if (r3 != 0) {
                                        r3.close();
                                    }
                                    if (L != 0) {
                                        L.close();
                                    }
                                    throw th;
                                }
                            }
                            h().H().b("Error reading entries from local database", e);
                            this.f18092d = true;
                            if (Query != 0) {
                                Query.close();
                            }
                            if (L != 0) {
                                L.close();
                            }
                            i4++;
                            r3 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        try {
                            L.beginTransaction();
                            long j2 = -1;
                            try {
                                if (n().r(zzap.G0)) {
                                    long jB = B(L);
                                    if (jB != -1) {
                                        try {
                                            str = "rowid<?";
                                            strArr = new String[]{String.valueOf(jB)};
                                        } catch (SQLiteFullException e4) {
                                            e = e4;
                                            r10 = 0;
                                            r15 = L;
                                            h().H().b("Error reading entries from local database", e);
                                            this.f18092d = true;
                                            if (r10 != 0) {
                                                r10.close();
                                            }
                                            if (r15 != 0) {
                                                r15.close();
                                            }
                                            i4++;
                                            r3 = 0;
                                        } catch (SQLiteException e5) {
                                            e = e5;
                                            Query = 0;
                                            L = L;
                                            if (L != 0) {
                                                if (L.inTransaction()) {
                                                    L.endTransaction();
                                                }
                                            }
                                            h().H().b("Error reading entries from local database", e);
                                            this.f18092d = true;
                                            if (Query != 0) {
                                                Query.close();
                                            }
                                            if (L != 0) {
                                                L.close();
                                            }
                                            i4++;
                                            r3 = 0;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r3 = 0;
                                            if (r3 != 0) {
                                                r3.close();
                                            }
                                            if (L != 0) {
                                                L.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        str = null;
                                        strArr = null;
                                    }
                                    String str2 = str;
                                    i3 = 3;
                                    String[] strArr2 = strArr;
                                    r3 = L;
                                    Query = L.query("messages", new String[]{"rowid", "type", "entry"}, str2, strArr2, null, null, "rowid asc", Integer.toString(100));
                                } else {
                                    ?? r4 = L;
                                    i3 = 3;
                                    Cursor cursorQuery = r4.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                                    r3 = r4;
                                    Query = cursorQuery;
                                }
                                while (Query.moveToNext()) {
                                    try {
                                        j2 = Query.getLong(0);
                                        int i7 = Query.getInt(1);
                                        byte[] blob = Query.getBlob(2);
                                        if (i7 == 0) {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    zzan zzanVarCreateFromParcel = zzan.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (zzanVarCreateFromParcel != null) {
                                                        arrayList.add(zzanVarCreateFromParcel);
                                                    }
                                                } catch (Throwable th4) {
                                                    parcelObtain.recycle();
                                                    throw th4;
                                                }
                                            } catch (SafeParcelReader.ParseException unused) {
                                                h().H().a("Failed to load event from local database");
                                                parcelObtain.recycle();
                                            }
                                        } else if (i7 == 1) {
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                    parcelObtain2.setDataPosition(0);
                                                    zzkjVarCreateFromParcel = zzkj.CREATOR.createFromParcel(parcelObtain2);
                                                    parcelObtain2.recycle();
                                                } catch (Throwable th5) {
                                                    parcelObtain2.recycle();
                                                    throw th5;
                                                }
                                            } catch (SafeParcelReader.ParseException unused2) {
                                                h().H().a("Failed to load user property from local database");
                                                parcelObtain2.recycle();
                                                zzkjVarCreateFromParcel = null;
                                            }
                                            if (zzkjVarCreateFromParcel != null) {
                                                arrayList.add(zzkjVarCreateFromParcel);
                                            }
                                        } else if (i7 == 2) {
                                            Parcel parcelObtain3 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain3.unmarshall(blob, 0, blob.length);
                                                    parcelObtain3.setDataPosition(0);
                                                    zzvVarCreateFromParcel = zzv.CREATOR.createFromParcel(parcelObtain3);
                                                    parcelObtain3.recycle();
                                                } catch (Throwable th6) {
                                                    parcelObtain3.recycle();
                                                    throw th6;
                                                }
                                            } catch (SafeParcelReader.ParseException unused3) {
                                                h().H().a("Failed to load user property from local database");
                                                parcelObtain3.recycle();
                                                zzvVarCreateFromParcel = null;
                                            }
                                            if (zzvVarCreateFromParcel != null) {
                                                arrayList.add(zzvVarCreateFromParcel);
                                            }
                                        } else if (i7 == i3) {
                                            h().K().a("Skipping app launch break");
                                        } else {
                                            h().H().a("Unknown record type in local database");
                                        }
                                    } catch (SQLiteDatabaseLockedException unused4) {
                                        r16 = r3;
                                        r11 = Query;
                                        SystemClock.sleep(i5);
                                        i5 += 20;
                                        if (r11 != 0) {
                                            r11.close();
                                        }
                                        if (r16 != 0) {
                                            r16.close();
                                        }
                                        i4++;
                                        r3 = 0;
                                    } catch (SQLiteFullException e6) {
                                        e = e6;
                                        r15 = r3;
                                        r10 = Query;
                                        h().H().b("Error reading entries from local database", e);
                                        this.f18092d = true;
                                        if (r10 != 0) {
                                            r10.close();
                                        }
                                        if (r15 != 0) {
                                            r15.close();
                                        }
                                        i4++;
                                        r3 = 0;
                                    } catch (SQLiteException e7) {
                                        e = e7;
                                        L = r3;
                                        Query = Query;
                                        if (L != 0) {
                                            if (L.inTransaction()) {
                                                L.endTransaction();
                                            }
                                        }
                                        h().H().b("Error reading entries from local database", e);
                                        this.f18092d = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (L != 0) {
                                            L.close();
                                        }
                                        i4++;
                                        r3 = 0;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        L = r3;
                                        r3 = Query;
                                        if (r3 != 0) {
                                            r3.close();
                                        }
                                        if (L != 0) {
                                            L.close();
                                        }
                                        throw th;
                                    }
                                }
                                if (r3.delete("messages", "rowid <= ?", new String[]{Long.toString(j2)}) < arrayList.size()) {
                                    h().H().a("Fewer entries removed from local database than expected");
                                }
                                r3.setTransactionSuccessful();
                                r3.endTransaction();
                                Query.close();
                                r3.close();
                                return arrayList;
                            } catch (SQLiteDatabaseLockedException unused5) {
                                r16 = r3;
                                r11 = 0;
                                SystemClock.sleep(i5);
                                i5 += 20;
                                if (r11 != 0) {
                                    r11.close();
                                }
                                if (r16 != 0) {
                                    r16.close();
                                }
                                i4++;
                                r3 = 0;
                            } catch (SQLiteFullException e8) {
                                e = e8;
                                L = r3;
                            } catch (SQLiteException e9) {
                                e = e9;
                                L = r3;
                            } catch (Throwable th8) {
                                th = th8;
                                L = r3;
                            }
                        } catch (SQLiteFullException e10) {
                            e = e10;
                        } catch (SQLiteException e11) {
                            e = e11;
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused6) {
                    r3 = L;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                r11 = 0;
                r16 = 0;
            } catch (SQLiteFullException e12) {
                e = e12;
                r10 = 0;
                r15 = 0;
            } catch (SQLiteException e13) {
                e = e13;
                Query = 0;
                L = 0;
            } catch (Throwable th10) {
                th = th10;
                r3 = 0;
                L = 0;
            }
            if (r3 != 0) {
                r3.close();
            }
            if (L != 0) {
                L.close();
            }
            throw th;
        }
        h().K().a("Failed to read events from database in reasonable time");
        return null;
    }

    public final boolean E(zzan zzanVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzanVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return D(0, bArrMarshall);
        }
        h().K().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean F(zzkj zzkjVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzkjVar.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return D(1, bArrMarshall);
        }
        h().K().a("User property too long for local database. Sending directly to service");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final boolean H(zzv zzvVar) {
        l();
        byte[] bArrG0 = zzkk.g0(zzvVar);
        if (bArrG0.length <= 131072) {
            return D(2, bArrG0);
        }
        h().K().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final void I() {
        b();
        d();
        try {
            int iDelete = L().delete("messages", null, null) + 0;
            if (iDelete > 0) {
                h().P().b("Reset local analytics data. records", Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e2) {
            h().H().b("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean J() {
        return D(3, new byte[0]);
    }

    public final boolean K() {
        d();
        b();
        if (this.f18092d || !M()) {
            return false;
        }
        int i2 = 5;
        for (int i3 = 0; i3 < 5; i3++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseL = L();
                    if (sQLiteDatabaseL == null) {
                        this.f18092d = true;
                        if (sQLiteDatabaseL != null) {
                            sQLiteDatabaseL.close();
                        }
                        return false;
                    }
                    sQLiteDatabaseL.beginTransaction();
                    sQLiteDatabaseL.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    sQLiteDatabaseL.setTransactionSuccessful();
                    sQLiteDatabaseL.endTransaction();
                    sQLiteDatabaseL.close();
                    return true;
                } catch (SQLiteFullException e2) {
                    h().H().b("Error deleting app launch break from local database", e2);
                    this.f18092d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i2);
                i2 += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e3) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                h().H().b("Error deleting app launch break from local database", e3);
                this.f18092d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        h().K().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.k3, com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzhc p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzeq q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzik r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzif s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzep t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.k3
    public final /* bridge */ /* synthetic */ zzjl u() {
        return super.u();
    }
}
