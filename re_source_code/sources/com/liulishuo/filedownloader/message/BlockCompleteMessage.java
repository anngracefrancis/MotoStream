package com.liulishuo.filedownloader.message;

import e.h.a.k0.f;

/* JADX INFO: loaded from: classes2.dex */
public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends MessageSnapshot implements BlockCompleteMessage {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final MessageSnapshot f20461h;

        public BlockCompleteMessageImpl(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.e());
            if (messageSnapshot.k() != -3) {
                throw new IllegalArgumentException(f.o("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k())));
            }
            this.f20461h = messageSnapshot;
        }

        @Override // com.liulishuo.filedownloader.message.BlockCompleteMessage
        public MessageSnapshot b() {
            return this.f20461h;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte k() {
            return (byte) 4;
        }
    }

    MessageSnapshot b();
}
