package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n3 {
    private static final List<s6> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(s6.SESSION_ID);
        arrayList.add(s6.SESSION_INFO);
        arrayList.add(s6.REPORTED_ID);
    }

    public static g0.b a(File file) {
        try {
            return b(c(file));
        } catch (IOException e2) {
            d1.j("FileWriterUtils", "Invalid frame data file: " + file + " => " + e2.toString());
            g0.b bVar = g0.b.IOEXCEPTION;
            bVar.n = e2.toString();
            return bVar;
        }
    }

    private static g0.b b(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet();
        g0.b bVar = g0.b.SUCCEED;
        int i2 = 0;
        int i3 = 0;
        while (bArr.length > i2) {
            try {
                if (bArr.length - i2 <= 0) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame version";
                    break;
                }
                int i4 = i2 + 1;
                byte[] bArr2 = new byte[3];
                if (bArr.length - i4 < 3) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame type";
                    break;
                }
                bArr2[0] = bArr[i4];
                bArr2[1] = bArr[i4 + 1];
                bArr2[2] = bArr[i4 + 2];
                int i5 = i4 + 3;
                byte[] bArr3 = new byte[4];
                System.arraycopy(bArr2, 0, bArr3, 1, 3);
                int i6 = ByteBuffer.wrap(bArr3).getInt();
                arrayList.add(s6.g(i6));
                for (s6 s6Var : a) {
                    if (i6 == s6Var.T) {
                        treeSet.add(s6Var);
                    }
                }
                if (bArr.length - i5 < 8) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame timestamp";
                    break;
                }
                int i7 = i5 + 8;
                if (bArr.length - i7 < 8) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame relative timestamp";
                    break;
                }
                int i8 = i7 + 8;
                byte[] bArr4 = new byte[4];
                if (bArr.length - i8 < 4) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame payload length";
                    break;
                }
                System.arraycopy(bArr, i8, bArr4, 0, 4);
                int i9 = i8 + 4;
                int i10 = ByteBuffer.wrap(bArr4).getInt();
                byte[] bArr5 = new byte[i10];
                if (bArr.length - i9 < i10) {
                    bVar = g0.b.EOF;
                    bVar.n = "EOF frame payload";
                    break;
                }
                System.arraycopy(bArr, i9, bArr5, 0, i10);
                int i11 = i9 + i10;
                try {
                    new JSONObject(new String(bArr5));
                    if (bArr.length - i11 < 4) {
                        bVar = g0.b.EOF;
                        bVar.n = "EOF frame checksum";
                        break;
                    }
                    i2 = i11 + 4;
                    i3++;
                } catch (JSONException e2) {
                    d1.j("FileWriterUtils", "Invalid Frame Payload: " + s6.g(i6));
                    g0.b bVar2 = g0.b.PAYLOAD_ERROR;
                    bVar2.n = e2.toString();
                    bVar = bVar2;
                }
            } catch (Exception | VirtualMachineError e3) {
                d1.j("FileWriterUtils", "Invalid Payload: " + e3.toString());
                g0.b bVar3 = g0.b.PAYLOAD_ERROR;
                bVar3.n = e3.toString();
                bVar = bVar3;
            }
        }
        if (bVar == g0.b.SUCCEED && treeSet.size() < a.size()) {
            bVar = g0.b.FRAME_MISSING;
        }
        bVar.o = bArr.length;
        bVar.p = i3;
        bVar.q = arrayList;
        bVar.r = treeSet;
        return bVar;
    }

    private static byte[] c(File file) throws IOException {
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        byte[] bArr2 = new byte[length];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int i2 = fileInputStream.read(bArr, 0, length);
            if (i2 < length) {
                int i3 = length - i2;
                while (i3 > 0) {
                    int i4 = fileInputStream.read(bArr2, 0, i3);
                    System.arraycopy(bArr2, 0, bArr, length - i3, i4);
                    i3 -= i4;
                }
            }
            return bArr;
        } finally {
            fileInputStream.close();
        }
    }
}
