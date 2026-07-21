package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.k<Bitmap> {
    public static final com.bumptech.glide.load.h<Integer> a = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Bitmap.CompressFormat> f9352b = com.bumptech.glide.load.h.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9353c;

    public c(com.bumptech.glide.load.engine.z.b bVar) {
        this.f9353c = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, com.bumptech.glide.load.i iVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.a(f9352b);
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.c b(com.bumptech.glide.load.i iVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #2 {all -> 0x00c0, blocks: (B:3:0x0021, B:13:0x004d, B:29:0x006a, B:31:0x0070, B:35:0x00bc, B:36:0x00bf), top: B:47:0x0021 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x0070, please report this as an issue */
    @Override // com.bumptech.glide.load.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(com.bumptech.glide.load.engine.u<Bitmap> uVar, File file, com.bumptech.glide.load.i iVar) {
        Bitmap bitmap = uVar.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, iVar);
        com.bumptech.glide.r.l.b.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = com.bumptech.glide.r.f.b();
            int iIntValue = ((Integer) iVar.a(a)).intValue();
            boolean z = false;
            OutputStream cVar = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            cVar = this.f9353c != null ? new com.bumptech.glide.load.m.c(fileOutputStream, this.f9353c) : fileOutputStream;
                            bitmap.compress(compressFormatD, iIntValue, cVar);
                            cVar.close();
                            z = true;
                        } catch (IOException e2) {
                            e = e2;
                            cVar = fileOutputStream;
                            if (Log.isLoggable("BitmapEncoder", 3)) {
                                Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                            }
                            if (cVar != null) {
                            }
                            if (Log.isLoggable("BitmapEncoder", 2)) {
                                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + com.bumptech.glide.r.k.h(bitmap) + " in " + com.bumptech.glide.r.f.a(jB) + ", options format: " + iVar.a(f9352b) + ", hasAlpha: " + bitmap.hasAlpha());
                            }
                            com.bumptech.glide.r.l.b.d();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            cVar = fileOutputStream;
                            if (cVar != null) {
                                try {
                                    cVar.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                    cVar.close();
                } catch (IOException unused2) {
                }
                if (Log.isLoggable("BitmapEncoder", 2)) {
                    Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + com.bumptech.glide.r.k.h(bitmap) + " in " + com.bumptech.glide.r.f.a(jB) + ", options format: " + iVar.a(f9352b) + ", hasAlpha: " + bitmap.hasAlpha());
                }
                com.bumptech.glide.r.l.b.d();
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            com.bumptech.glide.r.l.b.d();
            throw th3;
        }
    }
}
