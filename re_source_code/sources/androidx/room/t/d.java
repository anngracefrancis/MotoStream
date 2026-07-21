package androidx.room.t;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: FileUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    @SuppressLint({"LambdaLast"})
    public static void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream inputStreamNewInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream outputStreamNewOutputStream = Channels.newOutputStream(fileChannel);
                byte[] bArr = new byte[RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT];
                while (true) {
                    int i2 = inputStreamNewInputStream.read(bArr);
                    if (i2 <= 0) {
                        break;
                    } else {
                        outputStreamNewOutputStream.write(bArr, 0, i2);
                    }
                }
            } else {
                fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            }
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
