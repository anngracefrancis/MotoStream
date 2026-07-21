package androidx.room.t;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/* JADX INFO: compiled from: DBUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(c.u.a.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursorU0 = bVar.u0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorU0.moveToNext()) {
            try {
                arrayList.add(cursorU0.getString(0));
            } catch (Throwable th) {
                cursorU0.close();
                throw th;
            }
        }
        cursorU0.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.v("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(j jVar, c.u.a.e eVar, boolean z, CancellationSignal cancellationSignal) {
        Cursor cursorQuery = jVar.query(eVar, cancellationSignal);
        if (!z || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : cursorQuery;
    }

    public static int c(File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i2 = byteBufferAllocate.getInt();
            channel.close();
            return i2;
        } catch (Throwable th) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
