package com.liulishuo.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import e.h.a.k0.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MessageSnapshot implements Parcelable {
    public static final Parcelable.Creator<MessageSnapshot> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f20475g;

    public static class NoFieldException extends IllegalStateException {
        NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(f.o("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k()), messageSnapshot.getClass().getName()));
        }
    }

    public static class StartedMessageSnapshot extends MessageSnapshot {
        StartedMessageSnapshot(int i2) {
            super(i2);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 6;
        }

        StartedMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    static class a implements Parcelable.Creator<MessageSnapshot> {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0094  */
        /* JADX WARN: Code duplicated, block: B:48:0x0097  */
        /* JADX WARN: Instruction removed from duplicated block: B:48:0x0097, please report this as an issue */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageSnapshot createFromParcel(Parcel parcel) {
            MessageSnapshot warnMessageSnapshot;
            MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte b2 = parcel.readByte();
            if (b2 == -4) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.WarnMessageSnapshot(parcel) : new SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            } else if (b2 == -3) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.CompletedSnapshot(parcel) : new SmallMessageSnapshot.CompletedSnapshot(parcel);
            } else if (b2 == -1) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ErrorMessageSnapshot(parcel) : new SmallMessageSnapshot.ErrorMessageSnapshot(parcel);
            } else if (b2 == 1) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.PendingMessageSnapshot(parcel) : new SmallMessageSnapshot.PendingMessageSnapshot(parcel);
            } else if (b2 == 2) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ConnectedMessageSnapshot(parcel) : new SmallMessageSnapshot.ConnectedMessageSnapshot(parcel);
            } else if (b2 == 3) {
                warnMessageSnapshot = z ? new LargeMessageSnapshot.ProgressMessageSnapshot(parcel) : new SmallMessageSnapshot.ProgressMessageSnapshot(parcel);
            } else {
                if (b2 != 5) {
                    if (b2 != 6) {
                        messageSnapshot = null;
                    } else {
                        warnMessageSnapshot = new StartedMessageSnapshot(parcel);
                    }
                    if (messageSnapshot != null) {
                        messageSnapshot.f20475g = z;
                        return messageSnapshot;
                    }
                    throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
                }
                warnMessageSnapshot = z ? new LargeMessageSnapshot.RetryMessageSnapshot(parcel) : new SmallMessageSnapshot.RetryMessageSnapshot(parcel);
            }
            messageSnapshot = warnMessageSnapshot;
            if (messageSnapshot != null) {
                messageSnapshot.f20475g = z;
                return messageSnapshot;
            }
            throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) b2));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageSnapshot[] newArray(int i2) {
            return new MessageSnapshot[i2];
        }
    }

    public interface b {
        MessageSnapshot a();
    }

    MessageSnapshot(int i2) {
        this.f20474f = i2;
    }

    public String c() {
        throw new NoFieldException("getEtag", this);
    }

    public String d() {
        throw new NoFieldException("getFileName", this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f20474f;
    }

    public long f() {
        throw new NoFieldException("getLargeSofarBytes", this);
    }

    public long g() {
        throw new NoFieldException("getLargeTotalBytes", this);
    }

    public int h() {
        throw new NoFieldException("getRetryingTimes", this);
    }

    public int i() {
        throw new NoFieldException("getSmallSofarBytes", this);
    }

    public int j() {
        throw new NoFieldException("getSmallTotalBytes", this);
    }

    public abstract /* synthetic */ byte k();

    public Throwable l() {
        throw new NoFieldException("getThrowable", this);
    }

    public boolean m() {
        return this.f20475g;
    }

    public boolean n() {
        throw new NoFieldException("isResuming", this);
    }

    public boolean o() {
        throw new NoFieldException("isReusedDownloadedFile", this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f20475g ? (byte) 1 : (byte) 0);
        parcel.writeByte(k());
        parcel.writeInt(this.f20474f);
    }

    MessageSnapshot(Parcel parcel) {
        this.f20474f = parcel.readInt();
    }
}
