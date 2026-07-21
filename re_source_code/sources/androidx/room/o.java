package androidx.room;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: SQLiteCopyOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
class o implements c.u.a.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f2196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f2197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f2198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f2199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c.u.a.c f2200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f2201k;
    private boolean l;

    o(Context context, String str, File file, int i2, c.u.a.c cVar) {
        this.f2196f = context;
        this.f2197g = str;
        this.f2198h = file;
        this.f2199i = i2;
        this.f2200j = cVar;
    }

    private void a(File file) throws IOException {
        ReadableByteChannel channel;
        if (this.f2197g != null) {
            channel = Channels.newChannel(this.f2196f.getAssets().open(this.f2197g));
        } else {
            if (this.f2198h == null) {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
            channel = new FileInputStream(this.f2198h).getChannel();
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f2196f.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        androidx.room.t.d.a(channel, new FileOutputStream(fileCreateTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private void c() {
        String databaseName = getDatabaseName();
        File databasePath = this.f2196f.getDatabasePath(databaseName);
        a aVar = this.f2201k;
        androidx.room.t.a aVar2 = new androidx.room.t.a(databaseName, this.f2196f.getFilesDir(), aVar == null || aVar.f2125j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                    aVar2.c();
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            }
            if (this.f2201k == null) {
                aVar2.c();
                return;
            }
            try {
                int iC = androidx.room.t.c.c(databasePath);
                int i2 = this.f2199i;
                if (iC == i2) {
                    aVar2.c();
                    return;
                }
                if (this.f2201k.a(iC, i2)) {
                    aVar2.c();
                    return;
                }
                if (this.f2196f.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath);
                    } catch (IOException e3) {
                        Log.w("ROOM", "Unable to copy database file.", e3);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar2.c();
                return;
            } catch (IOException e4) {
                Log.w("ROOM", "Unable to read database version.", e4);
                aVar2.c();
                return;
            }
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
        aVar2.c();
        throw th;
    }

    void b(a aVar) {
        this.f2201k = aVar;
    }

    @Override // c.u.a.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f2200j.close();
        this.l = false;
    }

    @Override // c.u.a.c
    public String getDatabaseName() {
        return this.f2200j.getDatabaseName();
    }

    @Override // c.u.a.c
    public synchronized c.u.a.b s0() {
        if (!this.l) {
            c();
            this.l = true;
        }
        return this.f2200j.s0();
    }

    @Override // c.u.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f2200j.setWriteAheadLoggingEnabled(z);
    }
}
