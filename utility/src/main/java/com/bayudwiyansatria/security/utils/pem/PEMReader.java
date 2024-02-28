package com.bayudwiyansatria.security.utils.pem;

import java.io.Reader;
import org.bouncycastle.openssl.PEMParser;

public class PEMReader extends PEMParser {

    /**
     * Create a new PEMReader
     *
     * @param reader the Reader
     */
    public PEMReader(Reader reader) {
        super(reader);
    }
}
