package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class x6 {
    public static boolean a(w6 w6Var) {
        return new File(w6Var.a, w6Var.f11133b).delete();
    }

    public static boolean b(w6 w6Var, w6 w6Var2) throws Throwable {
        FileChannel fileChannel;
        FileChannel channel = null;
        try {
            File file = new File(w6Var.a, w6Var.f11133b);
            File file2 = new File(w6Var2.a, w6Var2.f11133b);
            file2.getParentFile().mkdirs();
            file2.delete();
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
                channel.transferFrom(channel2, 0L, channel2.size());
                c2.f(channel2);
                c2.f(channel);
                return true;
            } catch (Exception e2) {
                e = e2;
                FileChannel fileChannel2 = channel;
                channel = channel2;
                fileChannel = fileChannel2;
                try {
                    d1.c(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                    c2.f(channel);
                    c2.f(fileChannel);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    c2.f(channel);
                    c2.f(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel3 = channel;
                channel = channel2;
                fileChannel = fileChannel3;
                c2.f(channel);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public static boolean c(File file, File file2) throws Throwable {
        FileChannel fileChannel;
        FileChannel channel = null;
        try {
            file2.getParentFile().mkdirs();
            file2.delete();
            file2.createNewFile();
            FileChannel channel2 = new FileInputStream(file).getChannel();
            try {
                channel = new FileOutputStream(file2).getChannel();
                channel.transferFrom(channel2, 0L, channel2.size());
                c2.f(channel2);
                c2.f(channel);
                return true;
            } catch (Exception e2) {
                e = e2;
                FileChannel fileChannel2 = channel;
                channel = channel2;
                fileChannel = fileChannel2;
                try {
                    d1.c(6, "FileProcessor", "Copy file failed. " + e.getMessage());
                    c2.f(channel);
                    c2.f(fileChannel);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    c2.f(channel);
                    c2.f(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel3 = channel;
                channel = channel2;
                fileChannel = fileChannel3;
                c2.f(channel);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public static boolean d(w6 w6Var, w6 w6Var2) throws Throwable {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileChannel channel = null;
        try {
            File file = new File(w6Var.a, w6Var.f11133b);
            FileChannel channel2 = new FileInputStream(new File(w6Var2.a, w6Var2.f11133b)).getChannel();
            try {
                channel = new FileOutputStream(file, true).getChannel();
                channel.transferFrom(channel2, channel.size(), channel2.size());
                c2.f(channel2);
                c2.f(channel);
                return true;
            } catch (Exception unused) {
                FileChannel fileChannel3 = channel;
                channel = channel2;
                fileChannel2 = fileChannel3;
                c2.f(channel);
                c2.f(fileChannel2);
                return false;
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel4 = channel;
                channel = channel2;
                fileChannel = fileChannel4;
                c2.f(channel);
                c2.f(fileChannel);
                throw th;
            }
        } catch (Exception unused2) {
            fileChannel2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }
}
