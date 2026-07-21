package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
final class n9 extends SSLSocketFactory {
    private SSLSocketFactory a = (SSLSocketFactory) SSLSocketFactory.getDefault();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ m9 f13030b;

    n9(m9 m9Var) {
        this.f13030b = m9Var;
    }

    private final Socket a(Socket socket) throws SocketException {
        if (this.f13030b.q > 0) {
            socket.setReceiveBufferSize(this.f13030b.q);
        }
        this.f13030b.e(socket);
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return a(this.a.createSocket(socket, str, i2, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        return a(this.a.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return a(this.a.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return a(this.a.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return a(this.a.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
