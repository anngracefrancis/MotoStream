package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {
    public static final Integer a = 50;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f11029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    LinkedHashMap<String, List<String>> f11030c = new LinkedHashMap<>();

    final class a implements y1<List<s0>> {
        a() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    final class b implements y1<List<s0>> {
        b() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    final class c implements y1<List<s0>> {
        c() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    final class d implements y1<List<s0>> {
        d() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    final class e implements y1<List<s0>> {
        e() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    public r0(String str) {
        this.f11029b = str + "Main";
    }

    private synchronized void d(String str, List<String> list, String str2) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Saving Index File for " + str + " file name:" + b0.a().getFileStreamPath(i(str)));
        c7 c7Var = new c7(b0.a().getFileStreamPath(i(str)), str2, 1, new c());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new s0(it.next()));
        }
        c7Var.b(arrayList);
    }

    private synchronized void f() {
        LinkedList linkedList = new LinkedList(this.f11030c.keySet());
        new c7(b0.a().getFileStreamPath(i(this.f11029b)), ".YFlurrySenderIndex.info.", 1, new d()).c();
        if (!linkedList.isEmpty()) {
            String str = this.f11029b;
            d(str, linkedList, str);
        }
    }

    static void h(String str) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Deleting Index File for " + str + " file name:" + b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            d1.c(5, "FlurryDataSenderIndex", "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    static String i(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    private static byte[] l(String str) {
        byte[] bArr;
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading block File for " + str + " file name:" + b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str)));
        DataInputStream dataInputStream = null;
        byte[] bArr2 = null;
        if (!fileStreamPath.exists()) {
            d1.c(4, "FlurryDataSenderIndex", "Agent cache file doesn't exist.");
            return null;
        }
        d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " Found file.");
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                int unsignedShort = dataInputStream2.readUnsignedShort();
                if (unsignedShort == 0) {
                    c2.f(dataInputStream2);
                    return null;
                }
                bArr2 = new byte[unsignedShort];
                dataInputStream2.readFully(bArr2);
                dataInputStream2.readUnsignedShort();
                c2.f(dataInputStream2);
                return bArr2;
            } catch (Throwable th) {
                th = th;
                byte[] bArr3 = bArr2;
                dataInputStream = dataInputStream2;
                bArr = bArr3;
                try {
                    d1.d(6, "FlurryDataSenderIndex", "Error when loading persistent file", th);
                    return bArr;
                } finally {
                    c2.f(dataInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
    }

    private synchronized boolean m(String str) {
        boolean zC;
        c2.d();
        c7 c7Var = new c7(b0.a().getFileStreamPath(i(str)), ".YFlurrySenderIndex.info.", 1, new e());
        List<String> listK = k(str);
        if (listK != null && !listK.isEmpty()) {
            d1.c(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: notSentBlocks = " + listK.size());
            for (String str2 : listK) {
                q0.b(str2).c();
                d1.c(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(str2)));
            }
        }
        this.f11030c.remove(str);
        zC = c7Var.c();
        f();
        return zC;
    }

    public final List<String> a() {
        return new ArrayList(this.f11030c.keySet());
    }

    final synchronized List<String> b(String str) {
        ArrayList arrayList;
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " file name:" + b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        ArrayList arrayList2 = null;
        DataInputStream dataInputStream = null;
        if (fileStreamPath.exists()) {
            d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " Found file.");
            try {
                try {
                    DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        int unsignedShort = dataInputStream2.readUnsignedShort();
                        if (unsignedShort == 0) {
                            c2.f(dataInputStream2);
                            return null;
                        }
                        arrayList = new ArrayList(unsignedShort);
                        for (int i2 = 0; i2 < unsignedShort; i2++) {
                            try {
                                int unsignedShort2 = dataInputStream2.readUnsignedShort();
                                d1.c(4, "FlurryDataSenderIndex", "read iter " + i2 + " dataLength = " + unsignedShort2);
                                byte[] bArr = new byte[unsignedShort2];
                                dataInputStream2.readFully(bArr);
                                arrayList.add(new String(bArr));
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                        dataInputStream2.readUnsignedShort();
                        c2.f(dataInputStream2);
                        arrayList2 = arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        arrayList = null;
                    }
                    dataInputStream = dataInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    arrayList = null;
                }
                d1.d(6, "FlurryDataSenderIndex", "Error when loading persistent file", th);
                c2.f(dataInputStream);
                arrayList2 = arrayList;
            } catch (Throwable th4) {
                c2.f(dataInputStream);
                throw th4;
            }
        } else {
            d1.c(5, "FlurryDataSenderIndex", "Agent cache file doesn't exist.");
        }
        return arrayList2;
    }

    public final synchronized void c(q0 q0Var, String str) {
        boolean z;
        d1.c(4, "FlurryDataSenderIndex", "addBlockInfo".concat(String.valueOf(str)));
        String str2 = q0Var.a;
        List<String> linkedList = this.f11030c.get(str);
        if (linkedList == null) {
            d1.c(4, "FlurryDataSenderIndex", "New Data Key");
            linkedList = new LinkedList<>();
            z = true;
        } else {
            z = false;
        }
        linkedList.add(str2);
        if (linkedList.size() > a.intValue()) {
            q0.b(linkedList.get(0)).c();
            linkedList.remove(0);
        }
        this.f11030c.put(str, linkedList);
        d(str, linkedList, ".YFlurrySenderIndex.info.");
        if (z) {
            f();
        }
    }

    public final boolean e(String str, String str2) {
        boolean zRemove;
        List<String> list = this.f11030c.get(str2);
        if (list != null) {
            q0.b(str).c();
            zRemove = list.remove(str);
        } else {
            zRemove = false;
        }
        if (list == null || list.isEmpty()) {
            m(str2);
        } else {
            this.f11030c.put(str2, list);
            d(str2, list, ".YFlurrySenderIndex.info.");
        }
        return zRemove;
    }

    final void g(String str) throws Throwable {
        List<String> listB = b(str);
        if (listB == null) {
            d1.l("FlurryDataSenderIndex", "No old file to replace");
            return;
        }
        for (String str2 : listB) {
            byte[] bArrL = l(str2);
            if (bArrL == null) {
                d1.c(6, "FlurryDataSenderIndex", "File does not exist");
            } else {
                c2.d();
                d1.c(5, "FlurryDataSenderIndex", "Saving Block File for " + str2 + " file name:" + b0.a().getFileStreamPath(q0.a(str2)));
                q0.b(str2).b(new q0(bArrL));
                c2.d();
                d1.c(5, "FlurryDataSenderIndex", "Deleting  block File for " + str2 + " file name:" + b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2))));
                File fileStreamPath = b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2)));
                if (fileStreamPath.exists()) {
                    d1.c(5, "FlurryDataSenderIndex", "Found file for " + str2 + ". Deleted - " + fileStreamPath.delete());
                }
            }
        }
        d(str, listB, ".YFlurrySenderIndex.info.");
        h(str);
    }

    final synchronized List<String> j(String str) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " file name:" + b0.a().getFileStreamPath(i(str)));
        List list = (List) new c7(b0.a().getFileStreamPath(i(str)), ".YFlurrySenderIndex.info.", 1, new b()).a();
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((s0) it.next()).a);
        }
        return arrayList;
    }

    public final List<String> k(String str) {
        List<String> list = this.f11030c.get(str);
        return list == null ? Collections.emptyList() : new ArrayList(list);
    }
}
