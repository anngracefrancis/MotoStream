package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.g0.f;
import java.io.File;

/* JADX INFO: compiled from: MessageSnapshotTaker.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static MessageSnapshot a(int i2, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            return z ? new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, length) : new LargeMessageSnapshot.CompletedSnapshot(i2, true, length);
        }
        return z ? new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, (int) length) : new SmallMessageSnapshot.CompletedSnapshot(i2, true, (int) length);
    }

    public static MessageSnapshot b(int i2, long j2, Throwable th) {
        return j2 > 2147483647L ? new LargeMessageSnapshot.ErrorMessageSnapshot(i2, j2, th) : new SmallMessageSnapshot.ErrorMessageSnapshot(i2, (int) j2, th);
    }

    public static MessageSnapshot c(e.h.a.a aVar) {
        return aVar.h() ? new LargeMessageSnapshot.PausedSnapshot(aVar.getId(), aVar.o(), aVar.E()) : new SmallMessageSnapshot.PausedSnapshot(aVar.getId(), aVar.B(), aVar.i());
    }

    public static MessageSnapshot d(int i2, long j2, long j3, boolean z) {
        if (j3 > 2147483647L) {
            return z ? new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i2, j2, j3) : new LargeMessageSnapshot.WarnMessageSnapshot(i2, j2, j3);
        }
        return z ? new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i2, (int) j2, (int) j3) : new SmallMessageSnapshot.WarnMessageSnapshot(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot e(byte b2, FileDownloadModel fileDownloadModel, f.a aVar) {
        MessageSnapshot errorMessageSnapshot;
        int iE = fileDownloadModel.e();
        if (b2 == -4) {
            throw new IllegalStateException(e.h.a.k0.f.o("please use #catchWarn instead %d", Integer.valueOf(iE)));
        }
        if (b2 == -3) {
            return fileDownloadModel.o() ? new LargeMessageSnapshot.CompletedSnapshot(iE, false, fileDownloadModel.k()) : new SmallMessageSnapshot.CompletedSnapshot(iE, false, (int) fileDownloadModel.k());
        }
        if (b2 == -1) {
            errorMessageSnapshot = fileDownloadModel.o() ? new LargeMessageSnapshot.ErrorMessageSnapshot(iE, fileDownloadModel.g(), aVar.a()) : new SmallMessageSnapshot.ErrorMessageSnapshot(iE, (int) fileDownloadModel.g(), aVar.a());
        } else {
            if (b2 == 1) {
                return fileDownloadModel.o() ? new LargeMessageSnapshot.PendingMessageSnapshot(iE, fileDownloadModel.g(), fileDownloadModel.k()) : new SmallMessageSnapshot.PendingMessageSnapshot(iE, (int) fileDownloadModel.g(), (int) fileDownloadModel.k());
            }
            if (b2 == 2) {
                String strD = fileDownloadModel.p() ? fileDownloadModel.d() : null;
                return fileDownloadModel.o() ? new LargeMessageSnapshot.ConnectedMessageSnapshot(iE, aVar.c(), fileDownloadModel.k(), fileDownloadModel.b(), strD) : new SmallMessageSnapshot.ConnectedMessageSnapshot(iE, aVar.c(), (int) fileDownloadModel.k(), fileDownloadModel.b(), strD);
            }
            if (b2 == 3) {
                return fileDownloadModel.o() ? new LargeMessageSnapshot.ProgressMessageSnapshot(iE, fileDownloadModel.g()) : new SmallMessageSnapshot.ProgressMessageSnapshot(iE, (int) fileDownloadModel.g());
            }
            if (b2 != 5) {
                if (b2 == 6) {
                    return new MessageSnapshot.StartedMessageSnapshot(iE);
                }
                String strO = e.h.a.k0.f.o("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b2));
                e.h.a.k0.d.i(c.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b2));
                IllegalStateException illegalStateException = aVar.a() != null ? new IllegalStateException(strO, aVar.a()) : new IllegalStateException(strO);
                return fileDownloadModel.o() ? new LargeMessageSnapshot.ErrorMessageSnapshot(iE, fileDownloadModel.g(), illegalStateException) : new SmallMessageSnapshot.ErrorMessageSnapshot(iE, (int) fileDownloadModel.g(), illegalStateException);
            }
            errorMessageSnapshot = fileDownloadModel.o() ? new LargeMessageSnapshot.RetryMessageSnapshot(iE, fileDownloadModel.g(), aVar.a(), aVar.b()) : new SmallMessageSnapshot.RetryMessageSnapshot(iE, (int) fileDownloadModel.g(), aVar.a(), aVar.b());
        }
        return errorMessageSnapshot;
    }

    public static MessageSnapshot f(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.k() == -3) {
            return new BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(e.h.a.k0.f.o("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k())));
    }
}
