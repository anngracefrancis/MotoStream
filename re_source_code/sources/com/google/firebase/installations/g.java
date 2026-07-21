package com.google.firebase.installations;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: compiled from: CrossProcessLock.java */
/* JADX INFO: loaded from: classes2.dex */
class g {
    private final FileChannel a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileLock f19680b;

    private g(FileChannel fileChannel, FileLock fileLock) {
        this.a = fileChannel;
        this.f19680b = fileLock;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static g a(Context context, String str) {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new g(channel, fileLockLock);
                } catch (IOException e2) {
                    e = e2;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Error e3) {
                    e = e3;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                } catch (OverlappingFileLockException e4) {
                    e = e4;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLockLock != null) {
                        fileLockLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException e5) {
                e = e5;
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException e6) {
            e = e6;
            channel = null;
            fileLockLock = null;
        }
    }

    void b() {
        try {
            this.f19680b.release();
            this.a.close();
        } catch (IOException e2) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e2);
        }
    }
}
