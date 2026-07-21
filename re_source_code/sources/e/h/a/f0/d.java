package e.h.a.f0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.SparseArray;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.k0.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SqliteDatabaseImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements e.h.a.f0.a {
    private final SQLiteDatabase a = new e(e.h.a.k0.c.a()).getWritableDatabase();

    /* JADX INFO: compiled from: SqliteDatabaseImpl.java */
    public class a implements e.h.a.f0.a.InterfaceC0272a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f21256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private b f21257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final SparseArray<FileDownloadModel> f21258h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final SparseArray<List<com.liulishuo.filedownloader.model.a>> f21259i;

        a(d dVar) {
            this(null, null);
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void K(FileDownloadModel fileDownloadModel) {
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T(FileDownloadModel fileDownloadModel) {
            SparseArray<FileDownloadModel> sparseArray = this.f21258h;
            if (sparseArray != null) {
                sparseArray.put(fileDownloadModel.e(), fileDownloadModel);
            }
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void T0() {
            b bVar = this.f21257g;
            if (bVar != null) {
                bVar.c();
            }
            int size = this.f21256f.size();
            if (size < 0) {
                return;
            }
            d.this.a.beginTransaction();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    int iKeyAt = this.f21256f.keyAt(i2);
                    FileDownloadModel fileDownloadModel = this.f21256f.get(iKeyAt);
                    d.this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                    d.this.a.insert("filedownloader", null, fileDownloadModel.C());
                    if (fileDownloadModel.a() > 1) {
                        List<com.liulishuo.filedownloader.model.a> listN = d.this.n(iKeyAt);
                        if (listN.size() > 0) {
                            d.this.a.delete("filedownloaderConnection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                            for (com.liulishuo.filedownloader.model.a aVar : listN) {
                                aVar.i(fileDownloadModel.e());
                                d.this.a.insert("filedownloaderConnection", null, aVar.l());
                            }
                        }
                    }
                } catch (Throwable th) {
                    d.this.a.endTransaction();
                    throw th;
                }
            }
            SparseArray<FileDownloadModel> sparseArray = this.f21258h;
            if (sparseArray != null && this.f21259i != null) {
                int size2 = sparseArray.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    int iE = this.f21258h.valueAt(i3).e();
                    List<com.liulishuo.filedownloader.model.a> listN2 = d.this.n(iE);
                    if (listN2 != null && listN2.size() > 0) {
                        this.f21259i.put(iE, listN2);
                    }
                }
            }
            d.this.a.setTransactionSuccessful();
            d.this.a.endTransaction();
        }

        @Override // e.h.a.f0.a.InterfaceC0272a
        public void f0(int i2, FileDownloadModel fileDownloadModel) {
            this.f21256f.put(i2, fileDownloadModel);
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            b bVar = d.this.new b();
            this.f21257g = bVar;
            return bVar;
        }

        a(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
            this.f21256f = new SparseArray<>();
            this.f21258h = sparseArray;
            this.f21259i = sparseArray2;
        }
    }

    /* JADX INFO: compiled from: SqliteDatabaseImpl.java */
    class b implements Iterator<FileDownloadModel> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Cursor f21261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List<Integer> f21262g = new ArrayList();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f21263h;

        b() {
            this.f21261f = d.this.a.rawQuery("SELECT * FROM filedownloader", null);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDownloadModel next() {
            FileDownloadModel fileDownloadModelT = d.t(this.f21261f);
            this.f21263h = fileDownloadModelT.e();
            return fileDownloadModelT;
        }

        void c() {
            this.f21261f.close();
            if (this.f21262g.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.f21262g);
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "delete %s", strJoin);
            }
            d.this.a.execSQL(f.o("DELETE FROM %s WHERE %s IN (%s);", "filedownloader", "_id", strJoin));
            d.this.a.execSQL(f.o("DELETE FROM %s WHERE %s IN (%s);", "filedownloaderConnection", DeepLinkIntentReceiver.DeepLinksKeys.ID, strJoin));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21261f.moveToNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f21262g.add(Integer.valueOf(this.f21263h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FileDownloadModel t(Cursor cursor) {
        FileDownloadModel fileDownloadModel = new FileDownloadModel();
        fileDownloadModel.v(cursor.getInt(cursor.getColumnIndex("_id")));
        fileDownloadModel.B(cursor.getString(cursor.getColumnIndex("url")));
        fileDownloadModel.w(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        fileDownloadModel.y((byte) cursor.getShort(cursor.getColumnIndex("status")));
        fileDownloadModel.x(cursor.getLong(cursor.getColumnIndex("sofar")));
        fileDownloadModel.z(cursor.getLong(cursor.getColumnIndex("total")));
        fileDownloadModel.t(cursor.getString(cursor.getColumnIndex("errMsg")));
        fileDownloadModel.s(cursor.getString(cursor.getColumnIndex("etag")));
        fileDownloadModel.u(cursor.getString(cursor.getColumnIndex("filename")));
        fileDownloadModel.r(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return fileDownloadModel;
    }

    private void w(int i2, ContentValues contentValues) {
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
    }

    @Override // e.h.a.f0.a
    public void a(int i2) {
    }

    @Override // e.h.a.f0.a
    public e.h.a.f0.a.InterfaceC0272a b() {
        return new a(this);
    }

    @Override // e.h.a.f0.a
    public void c(int i2, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void clear() {
        this.a.delete("filedownloader", null, null);
        this.a.delete("filedownloaderConnection", null, null);
    }

    @Override // e.h.a.f0.a
    public void d(int i2, long j2) {
        remove(i2);
    }

    @Override // e.h.a.f0.a
    public void e(int i2, String str, long j2, long j3, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j2));
        contentValues.put("total", Long.valueOf(j3));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i3));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void f(int i2, int i3, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        this.a.update("filedownloaderConnection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
    }

    @Override // e.h.a.f0.a
    public void g(com.liulishuo.filedownloader.model.a aVar) {
        this.a.insert("filedownloaderConnection", null, aVar.l());
    }

    @Override // e.h.a.f0.a
    public void h(int i2) {
        this.a.execSQL("DELETE FROM filedownloaderConnection WHERE id = " + i2);
    }

    @Override // e.h.a.f0.a
    public void i(int i2) {
    }

    @Override // e.h.a.f0.a
    public void j(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            e.h.a.k0.d.i(this, "update but model == null!", new Object[0]);
        } else if (o(fileDownloadModel.e()) == null) {
            u(fileDownloadModel);
        } else {
            this.a.update("filedownloader", fileDownloadModel.C(), "_id = ? ", new String[]{String.valueOf(fileDownloadModel.e())});
        }
    }

    @Override // e.h.a.f0.a
    public void k(int i2, Throwable th, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void l(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public void m(int i2, long j2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public List<com.liulishuo.filedownloader.model.a> n(int i2) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.a.rawQuery(f.o("SELECT * FROM %s WHERE %s = ?", "filedownloaderConnection", DeepLinkIntentReceiver.DeepLinksKeys.ID), new String[]{Integer.toString(i2)});
            while (cursorRawQuery.moveToNext()) {
                com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
                aVar.i(i2);
                aVar.j(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                aVar.k(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("startOffset")));
                aVar.g(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                aVar.h(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("endOffset")));
                arrayList.add(aVar);
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @Override // e.h.a.f0.a
    public FileDownloadModel o(int i2) throws Throwable {
        Throwable th;
        Cursor cursorRawQuery;
        try {
            cursorRawQuery = this.a.rawQuery(f.o("SELECT * FROM %s WHERE %s = ?", "filedownloader", "_id"), new String[]{Integer.toString(i2)});
            try {
                if (!cursorRawQuery.moveToNext()) {
                    cursorRawQuery.close();
                    return null;
                }
                FileDownloadModel fileDownloadModelT = t(cursorRawQuery);
                cursorRawQuery.close();
                return fileDownloadModelT;
            } catch (Throwable th2) {
                th = th2;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorRawQuery = null;
        }
    }

    @Override // e.h.a.f0.a
    public void p(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        this.a.update("filedownloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
    }

    @Override // e.h.a.f0.a
    public void q(int i2, long j2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j2));
        w(i2, contentValues);
    }

    @Override // e.h.a.f0.a
    public boolean remove(int i2) {
        return this.a.delete("filedownloader", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
    }

    public void u(FileDownloadModel fileDownloadModel) {
        this.a.insert("filedownloader", null, fileDownloadModel.C());
    }

    public e.h.a.f0.a.InterfaceC0272a v(SparseArray<FileDownloadModel> sparseArray, SparseArray<List<com.liulishuo.filedownloader.model.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }
}
