package com.streamr.client_testing;

import com.streamr.client.authentication.EthereumAuthenticationMethod;
import com.streamr.client.options.EncryptionOptions;
import com.streamr.client.rest.Stream;

public class StreamrClientJS extends StreamrClientWrapper {
    private final String privateKey;
    private final EthereumAuthenticationMethod auth;
    private final EncryptionOptions encryptionOptions;

    public StreamrClientJS(String privateKey, EncryptionOptions encryptionOptions) {
        this.privateKey = privateKey;
        this.auth = new EthereumAuthenticationMethod(privateKey);
        this.encryptionOptions = encryptionOptions;
    }

    public StreamrClientJS() {
        this(StreamTester.generatePrivateKey(), null);
    }

    public StreamrClientJS(EncryptionOptions encryptionOptions) {
        this(StreamTester.generatePrivateKey(), encryptionOptions);
    }

    public String getAddress() {
        return auth.getAddress();
    }
    public String getPrivateKey() {
        return privateKey;
    }

    // @Override
    public PublisherThread toPublisherThread(Stream stream, long interval) {
        return new PublisherThreadJS(this, stream, interval);
    }

    public EncryptionOptions getEncryptionOptions() {
        return encryptionOptions;
    }
}
