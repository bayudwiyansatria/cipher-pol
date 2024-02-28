package com.bayudwiyansatria.security.utils.pem;

import java.io.Writer;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

/**
 * A generic PEM writer, based on RFC 1421
 *
 * @author Bayu Dwiyan Satria
 * @value 0.0.1
 */
public class PEMWriter extends JcaPEMWriter {

    /**
     * Base constructor.
     *
     * @param out output stream to use.
     */
    public PEMWriter(Writer out) {
        super(out);
    }
}
