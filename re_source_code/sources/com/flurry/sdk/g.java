package com.flurry.sdk;

import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Set<String> f10766b;

    final class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".flurryagent.");
        }
    }

    g() {
        HashSet hashSet = new HashSet();
        hashSet.add(HttpUrl.FRAGMENT_ENCODE_SET);
        hashSet.add(null);
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f10766b = Collections.unmodifiableSet(hashSet);
        this.a = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    static String a() throws IOException {
        DataInputStream dataInputStream;
        File fileStreamPath = b0.a().getFileStreamPath(".flurryb.");
        String utf = null;
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (1 == dataInputStream.readInt()) {
                    utf = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    d1.d(6, "DeviceIdProvider", "Error when loading deviceId", th);
                } finally {
                    c2.f(dataInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
        return utf;
    }

    static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileStreamPath = b0.a().getFileStreamPath(".flurryb.");
        if (!b2.b(fileStreamPath)) {
            return;
        }
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(fileStreamPath));
            try {
                dataOutputStream2.writeInt(1);
                dataOutputStream2.writeUTF(str);
                c2.f(dataOutputStream2);
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                try {
                    d1.d(6, "DeviceIdProvider", "Error when saving deviceId", th);
                } finally {
                    c2.f(dataOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    final String c() throws IOException {
        String[] list;
        DataInputStream dataInputStream;
        File filesDir = b0.a().getFilesDir();
        String utf = null;
        if (filesDir != null && (list = filesDir.list(new a())) != null && list.length != 0) {
            File fileStreamPath = b0.a().getFileStreamPath(list[0]);
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        if (46586 == dataInputStream.readUnsignedShort() && 2 == dataInputStream.readUnsignedShort()) {
                            dataInputStream.readUTF();
                            utf = dataInputStream.readUTF();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d1.d(6, "DeviceIdProvider", "Error when loading deviceId", th);
                        } finally {
                            c2.f(dataInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
                return utf;
            }
        }
        return null;
    }
}
