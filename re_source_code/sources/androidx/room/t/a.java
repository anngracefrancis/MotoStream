package androidx.room.t;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: CopyLock.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final Map<String, Lock> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f2209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lock f2210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FileChannel f2212e;

    public a(String str, File file, boolean z) {
        File file2 = new File(file, str + ".lck");
        this.f2209b = file2;
        this.f2210c = a(file2.getAbsolutePath());
        this.f2211d = z;
    }

    private static Lock a(String str) {
        Lock reentrantLock;
        Map<String, Lock> map = a;
        synchronized (map) {
            reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }

    public void b() {
        this.f2210c.lock();
        if (this.f2211d) {
            try {
                FileChannel channel = new FileOutputStream(this.f2209b).getChannel();
                this.f2212e = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f2212e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f2210c.unlock();
    }
}
